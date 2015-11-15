package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {
	
	private double radius;
	private double latitude;
    private double longitude;
    
    /**
	 * @methodtype constructor
	 * @methodproperty convenience
	 */
    public SphericCoordinate(double latitude, double longitude) {
    	this(latitude, longitude, 6371.0);
    }
    
    /**
	 * @methodtype constructor
	 * @methodproperty regular
	 */
    public SphericCoordinate(double latitude, double longitude, double radius) {
    	if(radius <= 0 || latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180)
 			throw new IllegalArgumentException();
    	
        this.radius = radius;
    	this.latitude = latitude;
        this.longitude = longitude;
    }
    
    /**
     * @methodtype get
     * @methodproperty primitive
     */
    @Override
    public double getX() {
		return radius * Math.sin(latitude) * Math.cos(longitude);
	}
    
    /**
     * @methodtype get
     * @methodproperty primitive
     */
    @Override
	public double getY() {
		return radius * Math.sin(latitude) * Math.sin(longitude);
	}
	
	/**
     * @methodtype get
     * @methodproperty primitive
     */
    @Override
	public double getZ() {
		return radius * Math.cos(latitude);
	}
    
    /**
     * @methodtype get
     * @methodproperty primitive
     */
    public double getRadius() {
        return radius;
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
     * @methodtype query
     */
    public double getSphericDistance(SphericCoordinate other) {
    	double dLat = Math.toRadians(other.getLatitude() - latitude);
        double dLon = Math.toRadians(other.getLongitude() - longitude);
        double lat1 = Math.toRadians(latitude);
        double lat2 = Math.toRadians(other.getLatitude());
 
        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return radius * c;
    }
    
    /**
     * @methodtype query
     */
    public double getLatitudinalDistance(SphericCoordinate other) {
    	if (other == null)
    		throw new IllegalArgumentException();
    	
        return Math.abs(latitude - other.getLatitude());
    }
    
    /**
     * @methodtype query
     */
	public double getLongitudinalDistance(SphericCoordinate other) {
		if (other == null)
    		throw new IllegalArgumentException();
    	
	    return Math.abs(longitude - other.getLongitude());
	}

	/**
	 * @methodtype conversion
	 */
	public String asSphericString() {
		return latitude + ", " + longitude;
	}   
}
