package WebService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Tag;
import service.TagService;

public class TagWebService {

	public void getTagById(HttpServletRequest request, HttpServletResponse response) {
		int t_id = Integer.parseInt(request.getParameter("t_id"));
		Tag t = TagService.selectTagById(t_id);

		ObjectMapper om = new ObjectMapper();
		try {
			if (t.getT_id()==t_id) {
				String json = om.writeValueAsString(t);
				response.getWriter().append(json).close();

			} else {
				String message = "Tag not found";
				String json = om.writeValueAsString(message);
				response.getWriter().append(json).close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void getTagByName(HttpServletRequest request, HttpServletResponse response) {
		String tag_name = request.getParameter("t_name");
		Tag t = TagService.selectTagByName(tag_name);

		ObjectMapper om = new ObjectMapper();
		try {
			if (t.getT_name().equals(tag_name.toLowerCase())) {
				String json = om.writeValueAsString(t);
				response.getWriter().append(json).close();

			} else {
				String message = "Tag not found";
				String json = om.writeValueAsString(message);
				response.getWriter().append(json).close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
