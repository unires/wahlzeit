package org.wahlzeit.model;

import java.io.Serializable;

public class CartesianCoordinate implements Coordinate, Serializable {
	
	private double x;
    private double y;
    private double z;
    
    /**
	 * @methodtype constructor
	 * @methodproperty regular
	 */
    public CartesianCoordinate(double x, double y, double z) {
    	this.x = x;
    	this.y = y;
    	this.z = z;
    }
    
    /**
     * @methodtype get
     * @methodproperty primitive
     */
    public double getX() {
		return x;
	}
    
    /**
     * @methodtype get
     * @methodproperty primitive
     */
	public double getY() {
		return y;
	}
	
	/**
     * @methodtype get
     * @methodproperty primitive
     */
	public double getZ() {
		return z;
	}
    
    /**
     * @methodtype get
     */
	@Override
    public double getDistance(Coordinate other) {
    	if (other == null)
    		throw new IllegalArgumentException();
    	if (other instanceof CartesianCoordinate)
    		return getDistance((CartesianCoordinate) other);
    	if (other instanceof SphericCoordinate)
    		return getDistance(((SphericCoordinate) other).asCartesian());
    	
    	throw new IllegalArgumentException();
    }
	
	/**
     * @methodtype get
     */
	private double getDistance(CartesianCoordinate other) {
    	if (other == null)
    		throw new IllegalArgumentException();
    	
    	return Math.sqrt(Math.pow((x - other.getX()), 2) + Math.pow((y - other.getY()), 2) + Math.pow((z - other.getZ()), 2));
    }
	
	/**
	 * @methodtype conversion
	 * @methodproperty primitive
	 */
	public String asString() {
		return x + ", " + y + ", " + z;
	}
	
	/**
	 * @methodtype comparison
	 * @methodproperty composed
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Coordinate))
			return false;

		Coordinate other = (Coordinate) obj;
		return isEqual(other);
	}
	
	/**
	 * @methodtype comparison
	 * @methodproperty primitive
	 */
	@Override
	public boolean isEqual(Coordinate other) {
		if (this.getDistance(other) == 0)
			return true;
		
		return false;
	}
	
	/**
	 * @methodtype get
	 * @methodproperty primitive
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

}
