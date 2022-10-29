package com.jiaying.loader;

import static org.junit.Assert.*;

//import java.lang.reflect.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PythonLoaderTest {
	PythonLoader sut = new PythonLoader();
	
	@Test 
	void testLoad(){
		assertNotNull(sut.load("spotLoader.py"));
	}
	
	@Test
	void testResolvePythonScriptPath() {
//		try 
//		{
//			Class<?> c = Class.forName("PythonLoader");
//			Method method = c.getDeclaredMethod("resolvePythonScriptPath", String.class);
//			method.setAccessible(true);
//			String res = (String) method.invoke(sut, "filename.txt");
//			System.out.println(res);
//			assertEquals("/Users/jiayinghuang/git/uom-coursework-scheduler/uom_coursework_scheduler/src/main/resources/filename.txt", res);
//		}
//		catch (Throwable e)
//		{
//			System.err.print(e);
//		}
		String res = sut.resolvePythonScriptPath("filename.txt");
		assertEquals("/Users/jiayinghuang/git/uom-coursework-scheduler/uom_coursework_scheduler/src/main/resources/python/filename.txt", res);
	}
}
