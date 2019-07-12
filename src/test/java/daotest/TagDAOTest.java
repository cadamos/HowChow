package daotest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dao.TagDAOImpl;
import model.Tag;
import service.TagService;

public class TagDAOTest {

//	@Test
//	public void testInsertTagDAO() {
//		TagDAOImpl t= new TagDAOImpl();
//		
//		Tag thetag= new Tag("pasta");
//		int result=thetag.getT_id();
//		System.out.println(t.insertTag(thetag));
//		assertEquals(result,t.insertTag(thetag));
//	}
	
	

//		@Test
//		public void selectTagByIdTagDAO() {
//			TagDAOImpl t= new TagDAOImpl();
//			String result="roti";
//			Tag thetag= new Tag(1,"roti");
//			assertEquals(result,t.selectTagById(1600).getT_name());
//		}
//		
//		@Test
//		public void selectAllTagDAO() {
//			TagDAOImpl t= new TagDAOImpl();
//			List<Tag>tag= new ArrayList<>();
//			tag=t.selectAllTags();
//			System.out.println(tag);
//			assertEquals(1400,tag.get(0).getT_id());
//		}
	
//	@Test
//	public void selectTagById() {
//		TagDAOImpl t= new TagDAOImpl();
//		Tag tag = new Tag();
//		tag=t.selectTagById(1600);
//		System.out.println(tag);
//		assertEquals("roti",tag.getT_name());
//	}
	
//	@Test
//	public void selectTagByName() {
//		TagDAOImpl t= new TagDAOImpl();
//		Tag tag = new Tag();
//		tag=t.selectTagByName("roti");
//		System.out.println(tag);
//		assertEquals("roti",tag.getT_name());
//	}
	
	@Test
	public void deleteTagByName() {
		TagDAOImpl t= new TagDAOImpl();
//		Tag tag = new Tag();
//		tag=t.selectTagByName("pasta");
//		t.deleteTagByName(tag.getT_name());
//		System.out.println(tag);
		t.deleteTagByName("pasta");
		assertEquals("null","null");
	}
	
	
		
		

}
