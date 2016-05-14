package com.home.dr;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Assumptions
 * 
 * End of sentence is a
 * 
 * . or ! or ?
 * followed by 1 or more whitespaces   or " plus one or more whitespaces
 * followed by a capital letter
 * 
 * this simple parser does not parse broken sentences
 * 
 * 
 * @author Dmitriy Stolyarov
 *
 */
public class SentenceTokenizer {
	
	String regex = "(?<=[\\.!?]\"?+)(?=\\s*[A-Z$])";
	
	public List<Sentence> getSentences(Document doc) {
		int i=0;
		
		while(i<doc.text.length() && Character.isWhitespace(doc.text.charAt(i))) {
			i++;
		}

		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(doc.text);
		
		Sentence s = new Sentence(doc);
		s.begin = i;
		
		ArrayList<Sentence> retList = new ArrayList<Sentence>();

		while(m.find()) {
			i = m.start();
			s.characterEnd = i;
			
			while(i < doc.text.length() && Character.isWhitespace(doc.text.charAt(i))) {
				i++;
			}
			
			s.end = i;
			retList.add(s);
			
			s = new Sentence(doc);
			s.begin = i;
		}
		
		if(i < doc.text.length()) {
			i = doc.text.length();
			s.end = doc.text.length();
			while(Character.isWhitespace(doc.text.charAt(i-1))) {
				i--;
			}
			s.characterEnd = i;
			retList.add(s);
		}

		return retList;
	}
	
	public int getTrueBeginning(String sentence) {
		Pattern pat = Pattern.compile("[A-Z0-9]");
		Matcher m = pat.matcher(sentence);
		m.find();
		return m.start();
	}
}
