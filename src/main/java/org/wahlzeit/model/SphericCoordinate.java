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
    	//precondition
    	assertIsValidInput(latitude, longitude, radius);
    	
        this.radius = radius;
    	this.latitude = latitude;
        this.longitude = longitude;
        
        //postcondition
        assertClassInvariants();
    }
    
    /**
     * @methodtype assertion
     */
    private void assertIsValidInput(double lat, double lon, double radius) {
    	assert Double.isFinite(lat);
    	assert lat >= -90;
    	assert lat <= 90;
		assert Double.isFinite(lon);
		assert lon >= -180;
    	assert lon <= 180;
		assert Double.isFinite(radius);
		assert radius >= 0;
	}
    
    /**
     * @methodtype assertion
     */
    private void assertClassInvariants() {
    	assert Double.isFinite(latitude);
    	assert latitude >= -90;
    	assert latitude <= 90;
		assert Double.isFinite(longitude);
		assert longitude >= -180;
    	assert longitude <= 180;
		assert Double.isFinite(radius);
		assert radius >= 0;
	}
    
    /**
     * @methodtype get
     * @methodproperty primitive
     */
    @Override
    public double getX() {
		double result = radius * Math.sin(latitude) * Math.cos(longitude);
		
		//postcondition
		assert Double.isFinite(result);
		
		return result;
	}
    
    /**
     * @methodtype get
     * @methodproperty primitive
     */
    @Override
	public double getY() {
    	double result = radius * Math.sin(latitude) * Math.sin(longitude);

		//postcondition
		assert Double.isFinite(result);
		
    	return result;
	}
	
	/**
     * @methodtype get
     * @methodproperty primitive
     */
    @Override
	public double getZ() {
    	double result = radius * Math.cos(latitude);

		//postcondition
		assert Double.isFinite(result);
		
    	return result;
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
		//precondition
		assert other != null;
		
    	double dLat = Math.toRadians(other.getLatitude() - latitude);
        double dLon = Math.toRadians(other.getLongitude() - longitude);
        double lat1 = Math.toRadians(latitude);
        double lat2 = Math.toRadians(other.getLatitude());
 
        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double result = radius * 2 * Math.asin(Math.sqrt(a));

		//postcondition
		assert Double.isFinite(result);
		assert result >= 0;
		
        return result;
    }
    
    /**
     * @methodtype query
     */
    public double getLatitudinalDistance(SphericCoordinate other) {
    	//precondition
    	assert other != null;
    	
        return Math.abs(latitude - other.getLatitude());
    }
    
    /**
     * @methodtype query
     */
	public double getLongitudinalDistance(SphericCoordinate other) {
		//precondition
		assert other != null;
    	
	    return Math.abs(longitude - other.getLongitude());
	}

	/**
	 * @methodtype conversion
	 */
	public String asSphericString() {
		return latitude + ", " + longitude;
	}   
}
