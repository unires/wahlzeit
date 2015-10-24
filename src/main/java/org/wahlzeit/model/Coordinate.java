package org.wahlzeit.model;

import java.io.Serializable;

public class Coordinate implements Serializable {
	
	private double latitude;
    private double longitude;
    
    
    public Coordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    /**
     * @methodtype get
     */
    public double getLatitude() {
        return latitude;
    }
    
    /**
     * @methodtype get
     */
    public double getLongitude() {
        return longitude;
    }
    
    /**
     * @methodtype get
     */
    public Coordinate getDistance(Coordinate other) {
    	if (other == null)
    		throw new IllegalArgumentException();
    	
        return new Coordinate(getLatitudeDistance(other),getLongitudeDistance(other));
    }
    
    /**
     * @methodtype get
     */
    public double getLatitudeDistance(Coordinate other) {
    	if (other == null)
    		throw new IllegalArgumentException();
    	
        return Math.abs(latitude - other.getLatitude());
    }
    
    /**
     * @methodtype get
     */
	public double getLongitudeDistance(Coordinate other) {
		if (other == null)
    		throw new IllegalArgumentException();
    	
	    return Math.abs(longitude - other.getLongitude());
	}
	
	/**
	 * @methodtype boolean-query
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
	 * @methodtype boolean-query
	 */
	private boolean isEqual(Coordinate other) {
		if (latitude == other.getLatitude() && longitude == other.getLongitude())
			return true;
		
		return false;
	}

	/**
	 * @methodtype conversion
	 */
	public String asString() {
		return latitude + ", " + longitude;
	}
    
}
