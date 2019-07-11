package webservice;

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
			if (t.getT_id() == t_id) {
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

	public void deleteTagById(HttpServletRequest request, HttpServletResponse response) {
		int t_id = Integer.parseInt(request.getParameter("t_id"));
		Tag t = TagService.selectTagById(t_id);

		ObjectMapper om = new ObjectMapper();
		try {
			if (t.getT_id() == t_id) {
				TagService.deleteTagById(t_id);

			} else {
				String message = "Tag not found";
				String json = om.writeValueAsString(message);
				response.getWriter().append(json).close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateTag(HttpServletRequest request, HttpServletResponse response) {
		int t_id = Integer.parseInt(request.getParameter("t_id"));
		String t_name = request.getParameter("t_name");
		Tag t = TagService.selectTagById(t_id);

		ObjectMapper om = new ObjectMapper();
		try {
			if (t.getT_id() == t_id && t_name != null) {
				t.setT_id(t_id);
				t.setT_name(t_name);
				TagService.updateTag(t);

			} else {
				String message = " not found";
				String json = om.writeValueAsString(message);
				response.getWriter().append(json).close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insertTag(HttpServletRequest request, HttpServletResponse response) {
		int t_id = Integer.parseInt(request.getParameter("t_id"));
		String t_name = request.getParameter("t_name");
		Tag t = TagService.selectTagById(t_id);

		ObjectMapper om = new ObjectMapper();
		try {
			if (t.getT_id() == t_id && t_name.equals(t_name)) {
				String message = "Tag already exist";
				String json = om.writeValueAsString(message);
				response.getWriter().append(json).close();

			} else {
				t.setT_id(t_id);
				t.setT_name(t_name);
				TagService.insertTag(t);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
