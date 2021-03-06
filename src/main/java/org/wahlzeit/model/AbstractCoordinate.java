package org.wahlzeit.model;

import java.io.Serializable;

public abstract class AbstractCoordinate implements Coordinate, Serializable {

	public abstract double getX();
	public abstract double getY();
	public abstract double getZ();
	
	/**
     * @methodtype query
     */
	@Override
	public double getDistance(Coordinate coordinate) {
		//precondition
		assert coordinate != null;
		
		double result;
		if (coordinate instanceof AbstractCoordinate) {
			AbstractCoordinate other = (AbstractCoordinate) coordinate;
			//precondition
			assertIsValidCoordinate(other);
			
			result = Math.sqrt(Math.pow((getX() - other.getX()), 2) + Math.pow((getY() - other.getY()), 2) + Math.pow((getZ() - other.getZ()), 2));
		} else {
			result = coordinate.getDistance(this);
		}
		
		//postcondition
		assert Double.isFinite(result);
		assert result >=0;
		
		return result;
	}
	
	/**
     * @methodtype assertion
     */
	protected void assertIsValidCoordinate(AbstractCoordinate coordinate) {
		assert Double.isFinite(coordinate.getX());
		assert Double.isFinite(coordinate.getY());
		assert Double.isFinite(coordinate.getZ());
	}
	
	/**
	 * @methodtype comparison
	 */
	@Override
	public boolean isEqual(Coordinate coordinate) {
		//precondition
		assert coordinate != null;
		if (coordinate instanceof AbstractCoordinate) {
			AbstractCoordinate other = (AbstractCoordinate) coordinate;
			//precondition
			assertIsValidCoordinate(other);
			
			return getX() == other.getX() && getY() == other.getY() && getZ() == other.getZ();
		}
		return coordinate.isEqual(this);
	}
	
	/**
	 * @methodtype conversion
	 */
	public String asString() {
		return getX() + ", " + getY() + ", " + getZ();
	}
	
	/**
	 * @methodtype comparison
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
	 * @methodtype get
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(getX());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(getY());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(getZ());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}
