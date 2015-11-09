package org.wahlzeit.model;

import java.io.Serializable;

import com.googlecode.objectify.annotation.Container;

public class Location implements Serializable{
	
	private String name;
	@Container private Coordinate coordinate;
	
	/**
	 * @methodtype constructor
	 * @methodproperty regular
	 */
	public Location(String name, Coordinate coordinate) {
		this.name = name;
		this.coordinate = coordinate;
	}
	
	/**
     * @methodtype get
     * @methodproperty primitive
     */
	public String getName() {
		return name;
	}
	
	/**
     * @methodtype get
     * @methodproperty primitive
     */
	public Coordinate getCoordinate() {
		return coordinate;
	}

}
