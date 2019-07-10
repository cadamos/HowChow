package service;

import java.util.List;

import dao.TagDAOImpl;
import model.Tag;

public class TagService {
	static TagDAOImpl tg = new TagDAOImpl();
	
	public static int insertTag(Tag t) {
		return tg.insertTag(t);
	}
	
	public static List<Tag> selectAllTags(){
		return tg.selectAllTags();	
	}
	
	public static Tag selectTagById(int id) {
		return tg.selectTagById(id);
	}
	
	
	public static void updateTagr(Tag t) {
		tg.updateTagr(t);
	}
	
	public static void deleteTagById(int id) {
		tg.deleteTagById(id);
	}
	
	public static void deleteTagByName(String name) {
		tg.deleteTagByName(name);
	}
}
