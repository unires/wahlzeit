package org.wahlzeit.model;

import java.io.Serializable;

public class Location implements Serializable{
	
	private String name;
	private Coordinate coordinate;
	
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
		return new Coordinate(coordinate.getLatitude(), coordinate.getLongitude());
	}

}
