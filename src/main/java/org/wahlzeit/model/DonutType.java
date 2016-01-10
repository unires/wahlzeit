package org.wahlzeit.model;

import java.io.Serializable;

public class DonutType implements Serializable {
	
	private String name;
	private String flavor;
	private boolean hasIcing;
	
	/**
     * @methodtype constuctor
     */
	public DonutType(String name, String flavor, boolean hasIcing) {
		this.name = name;
		this.flavor = flavor;
		this.hasIcing = hasIcing;
	}

	/**
     * @methodtype get
     */
	public String getName() {
		return name;
	}

	/**
     * @methodtype set
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * @methodtype get
     */
	public String getFlavor() {
		return flavor;
	}

	/**
     * @methodtype set
     */
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	/**
     * @methodtype get
     */
	public boolean isHasIcing() {
		return hasIcing;
	}

	/**
     * @methodtype set
     */
	public void setHasIcing(boolean hasIcing) {
		this.hasIcing = hasIcing;
	}
}
