package daotest;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import dao.TagDAOImpl;
import model.Tag;
import service.TagService;


public class TagDAOTest {
	
	@Test(priority = 4)
	public void InsertTagDAO() {
		Tag t = new Tag("pasta");
		Assert.assertNotNull(TagService.insertTag(t));
	}
	
	@Test(priority = 1)
	public void selectTagByIdTagDAO() {
		Assert.assertNotNull(TagService.selectTagById(1600));
		//Assert.assertEquals(TagService.selectTagById(1600).getT_name(),"roti" , "pass");
	}
	
	@Test(priority = 3)
	public void selectAllTagDAO() {
		Assert.assertEquals(2, TagService.selectAllTags().size());
	}
	
	@Test(priority = 2)
	public void selectTagByName() {
		Assert.assertNotNull(TagService.selectTagByName("roti"));
	}
	
	@Test(priority = 5)
	public void deleteTagByName() {
		TagService.deleteTagByName("ratatouille");
		Assert.assertNull(TagService.selectTagByName("ratatouille"));
	}
	
	@Test(priority = 4)
	public void updateTag() {
		Tag t = TagService.selectTagByName("pasta");
		t.setT_name("ratatouille");
		TagService.updateTag(t);
		Assert.assertEquals("ratatouille", TagService.selectTagByName("ratatouille").getT_name());
	}
	
	
}
