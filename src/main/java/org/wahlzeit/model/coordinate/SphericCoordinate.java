/*Author: Artur Mandybura, https://github.com/ArtyMandy/wahlzeit
 *
 * Class: SphericCoordinate
 *
 *Version information: adap-cw06
 *
 * Date: 19. Nov. 2017
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
package org.wahlzeit.model.coordinate;

import java.util.Objects;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class SphericCoordinate extends AbstractCoordinate {

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
	public boolean isEqual(Coordinate coordinate) {
		SphericCoordinate input = coordinate.asSphericCoordinate();
		
		if(input != null 
				&& isDoubleEqual(input.latitude, this.latitude) 
				&& isDoubleEqual(input.longitude, this.longitude) 
				&& isDoubleEqual(input.radius, this.radius)) {
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
