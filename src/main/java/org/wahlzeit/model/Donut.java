package org.wahlzeit.model;

import java.io.Serializable;
import java.util.Date;

public class Donut implements Serializable {
	
	private DonutType type;
	
	private String manufacturer;
	private Date timeOfManufacturing;
	private String color;

	/**
     * @methodtype constructor
     */
	public Donut(DonutType type) {
		this.type = type;
	}

	/**
     * @methodtype constructor
     * @methodproperty convenience
     */
	public Donut(DonutType type, String manufacturer, Date timeOfManufacturing, String color) {
		this.type = type;
		this.manufacturer = manufacturer;
		this.timeOfManufacturing = timeOfManufacturing;
		this.color = color;
	}

	/**
     * @methodtype get
     */
	public DonutType getType() {
		return type;
	}

	/**
     * @methodtype set
     */
	public void setType(DonutType type) {
		this.type = type;
	}

	/**
     * @methodtype get
     */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
     * @methodtype set
     */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
     * @methodtype get
     */
	public Date getTimeOfManufacturing() {
		return timeOfManufacturing;
	}

	/**
     * @methodtype set
     */
	public void setTimeOfManufacturing(Date timeOfManufacturing) {
		this.timeOfManufacturing = timeOfManufacturing;
	}

	/**
     * @methodtype get
     */
	public String getColor() {
		return color;
	}

	/**
     * @methodtype set
     */
	public void setColor(String color) {
		this.color = color;
	}
}
