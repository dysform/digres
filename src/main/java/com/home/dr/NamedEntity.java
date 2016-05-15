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
