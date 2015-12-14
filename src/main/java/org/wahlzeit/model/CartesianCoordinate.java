package org.wahlzeit.model;

import java.util.HashMap;
import java.util.Map;

public class CartesianCoordinate extends AbstractCoordinate {
	
	private final double x;
    private final double y;
    private final double z;
    
    private static Map<String, CartesianCoordinate> instances = new HashMap<>();
    
    public static CartesianCoordinate getCartesianCoordinate(double x, double y, double z) {
    	String key = asKeyString(x, y, z);
    	CartesianCoordinate result = instances.get(key);
    	if (result == null) {
    		synchronized(CartesianCoordinate.class) {
    			result = instances.get(key);
    			if (result == null) {
    	    		result = new CartesianCoordinate(x, y, z);
    	    		instances.put(key, result);
    	    	}
    		}
    	}
    	return result;
    }
    
    private static String asKeyString(double x, double y, double z) {
    	return x + ", " + y + ", " + z;
    }
    
    
    /**
	 * @methodtype constructor
	 * @methodproperty regular
	 */
    private CartesianCoordinate(double x, double y, double z) {
    	//precondition
    	assertIsValidInput(x, y, z);
    	
    	this.x = x;
    	this.y = y;
    	this.z = z;
    	
    	//postcondition
    	assertClassInvariants();
    }
    
    /**
     * @methodtype assertion
     */
    private void assertIsValidInput(double x, double y, double z) {
    	assert Double.isFinite(x);
		assert Double.isFinite(y);
		assert Double.isFinite(z);
	}
    
    /**
     * @methodtype assertion
     */
    private void assertClassInvariants() {
    	assert Double.isFinite(x);
		assert Double.isFinite(y);
		assert Double.isFinite(z);
	}

	/**
     * @methodtype get
     * @methodproperty primitive
     */
    @Override
    public double getX() {
		return x;
	}
    
    /**
     * @methodtype get
     * @methodproperty primitive
     */
    @Override
	public double getY() {
		return y;
	}
	
	/**
     * @methodtype get
     * @methodproperty primitive
     */
    @Override
	public double getZ() {
		return z;
	}
}
