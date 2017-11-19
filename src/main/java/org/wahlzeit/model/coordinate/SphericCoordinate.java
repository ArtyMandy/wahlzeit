package org.wahlzeit.model.coordinate;

import java.util.Objects;

public class SphericCoordinate implements Coordinate {

	private static final double DELTA = 0.0000001; 
	private double latitude;
	private double longitude;
	// Earthradius default value
	private double radius = 6371.0;
	
	/**
	 * ctor
	 * @param latitude
	 * @param longitude
	 */
	public SphericCoordinate(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/**
	 * ctor
	 * @param latitude
	 * @param longitude
	 * @param radius
	 */
	public SphericCoordinate(double latitude, double longitude, double radius) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}


	/**
	 * @methodtype get
	 */
	public double getLat() {
		return this.latitude;
	}
	
	/**
	 * @methodtype get
	 */
	public double getLong() {
		return this.longitude;
	}
	
	/**
	 * @methodtype get
	 */
	public double getRadius() {
		return this.radius;
	}
	
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double radiansLat = Math.toRadians(latitude);
		double radiansLong = Math.toRadians(longitude);
		double x = radius * Math.cos(radiansLat) * Math.sin(radiansLong);
		double y = radius * Math.sin(radiansLat) * Math.sin(radiansLong);
		double z = radius * Math.cos(radiansLong);
		
		CartesianCoordinate coordinate = new CartesianCoordinate(x, y, z);
		
		return coordinate;
	}

	@Override
	public double getCartesianDistance(Coordinate coordinate) {
		return this.asCartesianCoordinate().getDistance(coordinate);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	@Override
	public double getSphericDistance(Coordinate coordinate) {
		return this.getDistance(coordinate);
	}

	@Override
	public double getDistance(Coordinate coordinate) {
		SphericCoordinate inputCoordinate = coordinate.asSphericCoordinate();
		double diffLatitude = Math.toRadians(this.latitude) - Math.toRadians(inputCoordinate.latitude);
		double diffLongitude = Math.toRadians(this.longitude) - Math.toRadians(inputCoordinate.longitude);
		
		double sum = Math.sin(diffLatitude / 2) * Math.sin(diffLatitude / 2) +
							Math.cos(Math.toRadians(this.latitude) ) * Math.cos(Math.toRadians(inputCoordinate.latitude) ) * 
							(Math.sin(diffLongitude / 2) * Math.sin(diffLongitude /2));
		
		double distance = 2 * Math.asin(Math.sqrt(sum)) * radius ;
		
		return distance;
	}

	@Override
	public boolean isEqual(Coordinate coordinate) {
		SphericCoordinate input = coordinate.asSphericCoordinate();
		
		if(input != null
				&& Math.abs(input.latitude - this.latitude) <= DELTA 
				&& Math.abs(input.longitude - this.longitude) <= DELTA
				&& Math.abs(input.radius - this.radius) <= DELTA) {
			return true;		
		}
		return false;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(latitude, longitude, radius);
	}
	
	@Override
	public boolean equals(Object inputCoordinate) {
		if(!(inputCoordinate instanceof SphericCoordinate)) {
			return false;
		}
		
		SphericCoordinate coord = (SphericCoordinate)inputCoordinate;
		
		return this.isEqual(coord);
	}

}
