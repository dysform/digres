package com.home.dr;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NamedEntity {
	
	Sentence sentence;
	int begin;
	int end;
	
	public NamedEntity() {}
	
	public NamedEntity(Sentence s, int left, int right) {
		this.sentence = s;
		this.begin = left;
		this.end = right;
	}
	
	@XmlElement
	public String getEntityString() {
		String s = "";
		
		for(int i=begin;i<end;i++) {
			s+= sentence.getWords().get(i).getStemText();
			if(i<end-1) {
				s+=" ";
			}
		}
		
		return s;
	}
	
	@XmlElement
	public int getBegin() {
		return begin;
	}

	@XmlElement
	public int getEnd() {
		return end;
	}
	
	@XmlElement 
	public int getAbsoluteBegin() {
		return sentence.begin + sentence.words.get(begin).begin;
	}
	
	@XmlElement 
	public int getAbsoluteEnd() {
		return sentence.begin + sentence.words.get(end-1).characterEnd;
	}
	
	@XmlElement
	public String getAbsoluteText() {
		return sentence.doc.text.substring(getAbsoluteBegin(), getAbsoluteEnd());
	}

	public String toString() {
		String out = new String();
		
		for(int i=begin;i<end;i++) {
			out += sentence.words.get(i).getStemText();
			if(i<end-1) {
				out+= " ";
			}
		}
		
		return out;
	}
}
