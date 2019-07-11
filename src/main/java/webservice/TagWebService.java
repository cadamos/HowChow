package webservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Tag;
import service.TagService;

public class TagWebService {

	public static void getTagById(HttpServletRequest request, HttpServletResponse response) {
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

	public static void getTagByName(HttpServletRequest request, HttpServletResponse response) {
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

	public static void deleteTagById(HttpServletRequest request, HttpServletResponse response) {
		int t_id = Integer.parseInt(request.getParameter("t_id"));
		Tag t = TagService.selectTagById(t_id);

		ObjectMapper om = new ObjectMapper();
		try {
			if (t.getT_id() == t_id) {
				TagService.deleteTagById(t_id);
				String message = "Tag has been deleted";
				String json = om.writeValueAsString(message);
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

	public static void updateTag(HttpServletRequest request, HttpServletResponse response) {
		String t_name = request.getParameter("t_name");
		Tag t = TagService.selectTagByName(t_name);
		ObjectMapper om = new ObjectMapper();
		try {
			if (t != null) {
				String message = "Tag tag has been updated";
				TagService.updateTag(t);
				String json = om.writeValueAsString(message);
				response.getWriter().append(json).close();

			} else {
				String message = " not found";
				String json = om.writeValueAsString(message);
				response.getWriter().append(json).close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void insertTag(HttpServletRequest request, HttpServletResponse response) {
		String t_name = request.getParameter("t_name");
		Tag t = TagService.selectTagByName(t_name);

		ObjectMapper om = new ObjectMapper();
		try {
			if (t != null) {
				String message = "Tag already exist";
				String json = om.writeValueAsString(message);
				response.getWriter().append(json).close();

			} else {
				String message = "Taghas been inserted";
				TagService.insertTag(new Tag(t_name));
				String json = om.writeValueAsString(new Tag(message));
				response.getWriter().append(json).close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
