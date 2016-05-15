package com.home.dr;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * very simple implementation
 * 
 * put all named entities in a set
 * 
 * find islands of capitalized words (alos of, de) in the sentence
 * in each island, for each continuous variation of the island, construct
 * entity name without punctuation and check if it exists in
 * the set
 * 
 * @author diman
 *
 */
public class NamedEntityExtractor {

	public Set<String> entities = new TreeSet<String>();

	public NamedEntityExtractor(List<String> entities) {
		this.entities.addAll(entities);
		this.entities.remove("");
	}

	public List<NamedEntity> getNamedEntities(Sentence s) {
		
		List<NamedEntity> retList = new ArrayList<NamedEntity>();
		
		int left = 0; int right = 0;
		boolean state = true;

		for(int i = 0;i<s.words.size();i++) {
			String text = s.words.get(i).getStemText();
			
			if(isCap(text)) {
				right++;
				
				if(s.words.get(i).hasComma) {
					retList.addAll(findEntities(s, left, right));

					left = i+1;
					right = i+1;
					
					state = false;
					
				} else {
					state = true;
				}
			}

			if(!isCap(text) && !state) {
				left++;
				right++;
			}
		
			if(!isCap(text) && state) {
				retList.addAll(findEntities(s, left, right));

				left = i+1;
				right = i+1;
				
				state = false;
			}
		}
		
		return retList;
	}
	
	private List<NamedEntity> findEntities(Sentence s, int left, int right) {
		int n = right - left;
		
		List<NamedEntity> retList = new ArrayList<NamedEntity>();
		
		for(int i=0;i<n;i++) {
			NamedEntity ne = new NamedEntity(s,left+i,0);
			
			for(int j=i+1;j<n+1;j++) {
				ne.end = left+j;
				
				if(entities.contains(ne.toString())) {
					retList.add(new NamedEntity(s, ne.begin, ne.end));
				}
			}
		}
		
		return retList;
	}

	boolean isCap(String s) {
		if(Character.isUpperCase(s.charAt(0)))
			return true;
		
		if(s.equals("of") || s.equals("de")) 
			return true;
		
		return false;
	}
}

