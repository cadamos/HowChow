package daotest;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.TagDAOImpl;
import model.Tag;

public class TagDAOTest {

	@Test
	public void testInsertTagDAO() {
		TagDAOImpl t= new TagDAOImpl();
		int result=1;
		Tag thetag= new Tag(1,"roti");
		assertEquals(result,t.insertTag(thetag));
	}

}
