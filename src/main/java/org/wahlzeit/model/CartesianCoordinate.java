package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {
	
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
