package org.wahlzeit.model.coordinate;

public interface Coordinate {

	/**
	 * @MethodType conversion
	 * @return CartesianCoordinate
	 */
	public CartesianCoordinate asCartesianCoordinate();
	
	public double getCartesianDistance(Coordinate coordinate);
	
	/**
	 * @MethodType conversion
	 * @return SphericCoordinate
	 */
	public SphericCoordinate asSphericCoordinate();
	
	public double getSphericDistance(Coordinate coordinate);
	
	public double getDistance(Coordinate coordinate);
	
	public boolean isEqual(Coordinate coordinate);
	
}
