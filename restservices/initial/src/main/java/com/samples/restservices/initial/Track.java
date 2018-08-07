/**
 * 
 */
package com.samples.restservices.initial;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author pavan
 *
 */
@XmlRootElement
public class Track {
	
	String title;
	
	String singer;
	
	public String getTitle() {
		return title;
	}
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}
	@XmlElement
	public void setSinger(String singer) {
		this.singer = singer;
	}

	@Override
	public String toString() {
		return "Track [title=" + title + ", singer=" + singer + "]";
	}

}
