package com.home.dr.test;

import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.home.dr.Document;
import com.home.dr.DocumentBuilder;

public class DigitalReasoningTest {
	
	Document doc;
	
	@Before
    public void init() throws Exception {
        
		ClassLoader classLoader = getClass().getClassLoader();

		String text = IOUtils.toString(classLoader.getResourceAsStream("testtext.txt"));
		List<String> entities = IOUtils.readLines(classLoader.getResourceAsStream("testner.txt"));
		
		doc = new DocumentBuilder().buildDocument(text, entities);
    }
	
	@Test
	public void testApp() {
		Assert.assertEquals(4, doc.getSentences().size());
		
		Assert.assertEquals(5, doc.getSentences().get(0).getWords().size());
		Assert.assertEquals(8, doc.getSentences().get(1).getWords().size());
		Assert.assertEquals(8, doc.getSentences().get(2).getWords().size());
		Assert.assertEquals(10, doc.getSentences().get(3).getWords().size());
		
		Assert.assertEquals("\"quotes,\" ", doc.getSentences().get(1).getWords().get(4).getFullText());
		Assert.assertEquals("quotes", doc.getSentences().get(1).getWords().get(4).getCharacterText());
		
		Assert.assertEquals("quotes.\"", doc.getSentences().get(1).getWords().get(7).getFullText());
		Assert.assertEquals("quotes", doc.getSentences().get(1).getWords().get(7).getCharacterText());

		Assert.assertEquals("EntOne", doc.getSentences().get(2).getWords().get(3).getStemText());
		Assert.assertEquals("EntOne's", doc.getSentences().get(2).getWords().get(3).getCharacterText());
		Assert.assertEquals("\"EntOne's,\" ", doc.getSentences().get(2).getWords().get(3).getFullText());
		
		Assert.assertEquals(5, doc.getSentences().get(2).getNamedEntities().size());
		Assert.assertEquals(1, doc.getSentences().get(3).getNamedEntities().size());
		
		Assert.assertEquals(6, doc.getNamedEntities().size());
	}
}
