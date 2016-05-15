package com.home.dr.test;

import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import com.home.dr.Document;
import com.home.dr.DocumentBuilder;
import com.home.dr.DocumentXML;

public class DigitalReasoningTest {
	
	Document doc;
	
	@Before
    public void init() throws Exception {
        
		ClassLoader classLoader = getClass().getClassLoader();

		String text = IOUtils.toString(classLoader.getResourceAsStream("testtext.txt"));
		List<String> entities = IOUtils.readLines(classLoader.getResourceAsStream("testner.txt"));
		
		doc = new DocumentBuilder().buildDocument(text, entities);
		
		DocumentXML.printDocument(doc, null);
    }
	
	@Test
	public void testSentenceTokenizer() {	
		
	}
}
