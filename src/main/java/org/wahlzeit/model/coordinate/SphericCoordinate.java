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

import java.util.HashMap;
import java.util.Objects;

import org.wahlzeit.utils.Assertion;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class SphericCoordinate extends AbstractCoordinate {
	
	private static HashMap<Integer, SphericCoordinate> sharedCoordinates = new HashMap<>();
	
	private final double latitude;
	private final double longitude;
	// Earthradius default value
	private final double radius = 6371.0;
	
	/**
	 * ctor
	 * @param latitude
	 * @param longitude
	 */
	private SphericCoordinate(double latitude, double longitude) {
		Assertion.assertIsValidDouble(latitude);
		Assertion.assertIsValidDouble(longitude);
		
		this.latitude = latitude;
		this.longitude = longitude;
		
		assertClassInvariants();
	}
	
	public static SphericCoordinate getInstance(double latitude, double longitude) {
		SphericCoordinate result;
		synchronized(sharedCoordinates) {
			int hashKey = Objects.hash(latitude, longitude);
			
			if(sharedCoordinates.containsKey(hashKey)){
				result = sharedCoordinates.get(hashKey);
				return result;
			}
			else {
				result = new SphericCoordinate(latitude, longitude);
				sharedCoordinates.put(hashKey, result);
				return result;
				}
			}
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
	public int hashCode() {
		return Objects.hash(latitude, longitude);
	}
	
	@Override
	public boolean equals(Object inputCoordinate) {
		assert inputCoordinate instanceof SphericCoordinate;
		
		SphericCoordinate coord = (SphericCoordinate)inputCoordinate;
		
		return this.isEqual(coord);
	}
	
	@Override
	public boolean isEqual(Coordinate coordinate) {
		assertClassInvariants();
		
		SphericCoordinate input = coordinate.asSphericCoordinate();
		
		if(isDoubleEqual(input.latitude, this.latitude) &&
				isDoubleEqual(input.longitude, this.longitude)) {
			return true;		
		}
		return false;
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() throws IllegalArgumentException{
		assertClassInvariants();
		double radiansLat = Math.toRadians(latitude);
		double radiansLong = Math.toRadians(longitude);
		double x = radius * Math.cos(radiansLat) * Math.sin(radiansLong);
		double y = radius * Math.sin(radiansLat) * Math.sin(radiansLong);
		double z = radius * Math.cos(radiansLong);
		
		assertClassInvariants();
		return CartesianCoordinate.getInstance(x, y, z);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() throws IllegalArgumentException {
		assertClassInvariants();
		return this;
	}

	@Override
	protected void assertClassInvariants() {
		Assertion.assertIsNotNull(this);
		Assertion.assertIsValidDouble(this.getLat());
		Assertion.assertIsValidDouble(this.getLong());
		Assertion.assertIsValidDouble(this.getRadius());
	}
}
