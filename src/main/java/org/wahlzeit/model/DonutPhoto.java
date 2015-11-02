package org.wahlzeit.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;

/**
 * A DonutPhoto represents a user-provided (uploaded) photo in the domain of donuts.
 */
@Entity
public class DonutPhoto extends Photo implements Serializable {
	
	protected String flavor = "";
	protected String color = "";
	
	/**
	 * @methodtype constructor
	 * @methodproperty regular
	 */
	public DonutPhoto() {
		super();
	}
	
	/**
	 * @methodtype constructor
	 * @methodproperty regular
	 */
	public DonutPhoto(PhotoId myId) {
		super(myId);
	}
	
	/**
     * @methodtype get
     * @methodproperty primitive
     */
	public String getFlavor() {
		return flavor;
	}
	
	/**
     * @methodtype set
     * @methodproperty primitive
     */
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	/**
     * @methodtype get
     * @methodproperty primitive
     */
	public String getColor() {
		return color;
	}

	/**
     * @methodtype set
     * @methodproperty primitive
     */
	public void setColor(String color) {
		this.color = color;
	}
	
	

}
