package org.wahlzeit.model;

import java.io.Serializable;

public class Coordinate implements Serializable {
	
	private double latitude;
    private double longitude;
    
    /**
	 * @methodtype constructor
	 * @methodproperty regular
	 */
    public Coordinate(double latitude, double longitude) {
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
     * @methodproperty composed
     */
    public double getDistance(Coordinate other) {
    	if (other == null)
    		throw new IllegalArgumentException();
    	
    	final double R = 6371;
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
    public double getLatitudinalDistance(Coordinate other) {
    	if (other == null)
    		throw new IllegalArgumentException();
    	
        return Math.abs(latitude - other.getLatitude());
    }
    
    /**
     * @methodtype get
     * @methodproperty primitive
     */
	public double getLongitudinalDistance(Coordinate other) {
		if (other == null)
    		throw new IllegalArgumentException();
    	
	    return Math.abs(longitude - other.getLongitude());
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
	 * @methodtype helper
	 * @methodproperty primitive
	 */
	private boolean isEqual(Coordinate other) {
		if (latitude == other.getLatitude() && longitude == other.getLongitude())
			return true;
		
		return false;
	}

	/**
	 * @methodtype conversion
	 * @methodproperty primitive
	 */
	public String asString() {
		return latitude + ", " + longitude;
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
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
    
}
