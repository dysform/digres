package com.home.dr;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * assume sentence does not start with white space
 * look for word boundaries with lookaround regex
 * within word characters find other important markers
 * such as commas and other punctuation
 * 
 * the begin->end is the whole word+following whitespace
 * 
 * @author Dmitriy Stolyarov
 *
 */
public class WordTokenizer {
	
	String regex = "(?<=\\S)(?=\\s)|(?<=\\s)(?=\\S)|$";
	
	Pattern pattern = Pattern.compile(regex);

	public List<Word> getWords(Sentence s) {
		Matcher m = pattern.matcher(s.getText());

		ArrayList<Word> retList = new ArrayList<Word>();
		
		int begin = 0;
		Word w = new Word(s);
		w.begin = begin;
		w.characterBegin = w.begin;

		while(m.find()) {
			w.characterEnd = m.start();
			
			m.find();
			w.end = m.start();
			
			retList.add(w);
			
			begin = w.end;
			
			w = new Word(s);
			w.begin = begin;
			w.characterBegin = w.begin;
		}
		
		for(Word word : retList) {
			setAllBoundaries(word);
		}

		return retList;
	}

	private void setAllBoundaries(Word word) {
		int i = 0;
		
		String text = word.getFullText();
		
		while(i < text.length() && isSymbol(text.charAt(i))) {
			i++;
		}
		
		if(i<text.length()) {
			word.characterBegin = word.begin + i;
		}
		
		i = text.length()-1;
		
		while(i >= 0 && Character.isWhitespace(text.charAt(i))) {
			i--;
		}
		
		if(i>= 0 && (text.charAt(i) == ',' || text.charAt(i)==';')) {
			word.hasComma = true;
		}
		
		while(i >= 0 && isSymbol(text.charAt(i))) {
			i--;
		}
		
		if(i >= 0) {
			word.characterEnd = word.begin + i + 1;
		}
	}
	
	public boolean isSymbol(Character c) {
		return !isWordCharacter(c);
	}

	public boolean isWordCharacter(Character c) {
		return Character.isLetterOrDigit(c);
	}
}
