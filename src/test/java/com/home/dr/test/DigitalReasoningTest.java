package com.home.dr.test;

import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import com.home.dr.Document;
import com.home.dr.DocumentBuilder;

public class DigitalReasoningTest {
	
	Document doc;
	
	@Before
    public void init() throws Exception {
        
		ClassLoader classLoader = getClass().getClassLoader();

		String text = IOUtils.toString(classLoader.getResourceAsStream("test-text.txt"));
		List<String> entities = IOUtils.readLines(classLoader.getResourceAsStream("test-text.txt"));
		
		doc = new DocumentBuilder().buildDocument(text, entities);
    }
	
	@Test
	public void testSentenceTokenizer() {	
		
	}
}
