package com.home.dr;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Word {
	
	Sentence sentence;
	
	boolean hasComma;
	
	public Word(){}
	
	public Word(Sentence s) {
		this.sentence = s;
	}

	public Word(Sentence s, int begin, int end) {
		this.sentence = s;
	}
	
	int begin;
	int characterBegin;
	int stemEnd;
	int characterEnd;
	int end;
	
	public String toString() {
		return getFullText();
	}
	
	public String getFullText() {
		return sentence.getFullText().substring(begin, end);
	}
	
	@XmlElement
	public String getCharacterText() {
		return sentence.getFullText().substring(characterBegin, characterEnd);
	}

	@XmlElement
	public int getBegin() {
		return begin;
	}

	@XmlElement
	public int getCharacterBegin() {
		return characterBegin;
	}

	@XmlElement
	public int getCharacterEnd() {
		return characterEnd;
	}

	@XmlElement
	public int getEnd() {
		return end;
	}
	
	public String getStemText() {
		String c = getCharacterText();

		if(c.length() > 2 && !Character.isAlphabetic(c.charAt(c.length()-2))) {
			return c.substring(0, c.length()-2);
		}
		
		return c;
	}
}
