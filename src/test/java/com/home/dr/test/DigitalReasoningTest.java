package com.home.dr.test;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import com.home.dr.Document;

public class DigitalReasoningTest {
	
	Document doc;
	
	@Before
    public void init() throws Exception {
        
		ClassLoader classLoader = getClass().getClassLoader();

		String text = IOUtils.toString(classLoader.getResourceAsStream("test-text.txt"));
		
		doc = new Document(text);

    }
	
	@Test
	public void testSentenceTokenizer() {	
		
	}
}
