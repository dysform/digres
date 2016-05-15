package com.home.dr;

import java.util.ArrayList;
import java.util.List;

public class NamedEntityExtractor {
	public List<NamedEntity> getNamedEntities(Sentence s) {
		
		List<NamedEntity> retList = new ArrayList<NamedEntity>();
		
		int left = 0; int right = 0;
		boolean state = false;

		for(int i = 1;i<s.words.size();i++) {

			String text = s.words.get(i).getCharacterText();
			
			if(isCap(text) && !state) {
					state = true;
					left = i;
					right = i;
			}
			
			if(isCap(text) && (state || i==1)) {
					right++;
			}
			
			if(isCap(text) && state) {
				state = false;
				left = i;
			}
			
			if(!isCap(text) && !state) {
				left++;
			}
		
			if(!isCap(text) && state) {
				NamedEntity ne = new NamedEntity(s, left, right);
				retList.add(ne);
			}
		}
		
		return null;
	}
	
	boolean isCap(String s) {
		if(Character.isUpperCase(s.charAt(0)))
			return true;
		
		if(s.equals("of")) 
			return true;
		
		return false;
	}
}

