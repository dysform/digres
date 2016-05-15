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
	
}
