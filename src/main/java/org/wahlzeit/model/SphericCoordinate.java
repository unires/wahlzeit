package org.wahlzeit.model;

import java.io.Serializable;

public class SphericCoordinate implements Coordinate, Serializable {
	
	public static final double R = 6371;
	
	private double latitude;
    private double longitude;
    
    /**
	 * @methodtype constructor
	 * @methodproperty regular
	 */
    public SphericCoordinate(double latitude, double longitude) {
    	if(latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180)
 			throw new IllegalArgumentException();
    	
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    /**
     * @methodtype get
     * @methodproperty primitive
     */
    public double getLatitude() {
        return latitude;
    }
    
    /**
     * @methodtype get
     * @methodproperty primitive
     */
    public double getLongitude() {
        return longitude;
    }
    
    /**
     * @methodtype get
     */
    public double getDistance(Coordinate other) {
    	if (other == null)
    		throw new IllegalArgumentException();
    	if (other instanceof SphericCoordinate)
    		return getDistance((SphericCoordinate) other);
    	if (other instanceof CartesianCoordinate)
    		return other.getDistance(this.asCartesian());
    	
    	throw new IllegalArgumentException();
    }
    
    /**
     * @methodtype get
     */
    private double getDistance(SphericCoordinate other) {
    	double dLat = Math.toRadians(other.getLatitude() - latitude);
        double dLon = Math.toRadians(other.getLongitude() - longitude);
        double lat1 = Math.toRadians(latitude);
        double lat2 = Math.toRadians(other.getLatitude());
 
        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }
    
    /**
     * @methodtype get
     * @methodproperty primitive
     */
    public double getLatitudinalDistance(SphericCoordinate other) {
    	if (other == null)
    		throw new IllegalArgumentException();
    	
        return Math.abs(latitude - other.getLatitude());
    }
    
    /**
     * @methodtype get
     * @methodproperty primitive
     */
	public double getLongitudinalDistance(SphericCoordinate other) {
		if (other == null)
    		throw new IllegalArgumentException();
    	
	    return Math.abs(longitude - other.getLongitude());
	}	

	public CartesianCoordinate asCartesian() {
		double x = R * Math.sin(latitude) * Math.cos(longitude);
		double y = R * Math.sin(latitude) * Math.sin(longitude);
		double z = R * Math.cos(latitude);
		return new CartesianCoordinate(x, y, z);
	}

	/**
	 * @methodtype conversion
	 * @methodproperty primitive
	 */
	public String asString() {
		return latitude + ", " + longitude;
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
		temp = Double.doubleToLongBits(R * Math.sin(latitude) * Math.cos(longitude));
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(R * Math.sin(latitude) * Math.sin(longitude));
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(R * Math.cos(latitude));
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
    
}
