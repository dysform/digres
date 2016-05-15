package com.home.dr;

public class NamedEntity {
	
	Sentence sentence;
	int begin;
	int end;
	
	public NamedEntity(Sentence s, int left, int right) {
		this.sentence = s;
		this.begin = left;
		this.end = right;
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
