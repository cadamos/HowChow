package dao;

import java.util.List;

import model.Tag;

public interface TagDAO {
	public int insertTag(Tag t);
	public List<Tag> selectAllTags();
	public Tag selectTagById(int id);
	public Tag selectTagByName(String name);
	public void updateTag(Tag t);
	public void deleteTagById(int id);
	public void deleteTagByName(String name);
}
