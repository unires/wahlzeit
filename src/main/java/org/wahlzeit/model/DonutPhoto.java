package org.wahlzeit.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Subclass;

/**
 * A DonutPhoto represents a user-provided (uploaded) photo in the domain of donuts.
 */
@Subclass
public class DonutPhoto extends Photo implements Serializable {
	
	private Donut donut;
	
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
     */
	public Donut getDonut() {
		return donut;
	}

	/**
     * @methodtype set
     */
	public void setDonut(Donut donut) {
		this.donut = donut;
		incWriteCount();
	}
}
