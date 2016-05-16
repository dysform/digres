package com.home.dr;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Documents {
	
	List<Document> docs;
	
	public Documents() {}
	
	public Documents(List<Document> results) {
		this.docs = results;
	}

	@XmlElement
	public List<Document> getDocuments() {
		return docs;
	}
	
	@XmlElement
	public List<NamedEntity> getNamedEntities() {
		List<NamedEntity> retList = new ArrayList<NamedEntity>();
		
		for(Document doc : docs) {
			retList.addAll(doc.getNamedEntities());
		}
		
		return retList;
	}
}
