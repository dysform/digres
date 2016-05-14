package com.home.dr;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordTokenizer {
	
	String regex = "\\s|$";
	
	Pattern pattern = Pattern.compile(regex);

	public List<Word> getWords(Sentence s) {
		
		String text = s.getFullText();

		Matcher m = pattern.matcher(s.getText());

		ArrayList<Word> retList = new ArrayList<Word>();
		
		int begin = 0;
		Word w = new Word(s);
		w.begin = begin;
		w.characterBegin = w.begin;

		while(m.find()) {
			w.characterEnd = m.start();
			w.end = w.characterEnd;
			
			while(w.end < s.getFullText().length() && Character.isWhitespace(text.charAt(w.end))) {
				w.end++;
			}
			
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
		if(word.getText().equals("... ")) {
			System.out.println("Fuck You");
		}
		
		int i = 0;
		
		String text = word.getText();
		
		while(i < text.length() && isSymbol(text.charAt(i))) {
			i++;
		}
		
		if(i<text.length()) {
			word.characterBegin = word.begin + i;
		}
		
		i = text.length()-1;
		
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
