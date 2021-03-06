/*Author: Artur Mandybura, https://github.com/ArtyMandy/wahlzeit
 *
 *Class: CartesianCoordinate
 *
 *Version information: adap-cw03  
 *
 * Date: 26. Oct. 2017
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
public class CartesianCoordinate extends AbstractCoordinate{
	
	private static HashMap<Integer, CartesianCoordinate> sharedCoordinates = new HashMap<>();
	
	private final double x;
	private final double y;
	private final double z;
	
	
	private CartesianCoordinate(double x, double y, double z) {
		Assertion.assertIsValidDouble(x);
		Assertion.assertIsValidDouble(y);
		Assertion.assertIsValidDouble(z);
		this.x = x;
		this.y = y;
		this.z = z;
		assertClassInvariants();
	}
	
	
	public static CartesianCoordinate getInstance(double x, double y, double z) {
		CartesianCoordinate result;
		synchronized(sharedCoordinates) {
			int hashKey = Objects.hash(x,y,z);
			
			if(sharedCoordinates.containsKey(hashKey)){
				result = sharedCoordinates.get(hashKey);
				return result;
			}
			else {
				result = new CartesianCoordinate(x,y,z);
				sharedCoordinates.put(hashKey, result);
				return result;
				}
			}
	}
	
	/**
	 * @methodtype get
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * @methodtype get
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * @methodtype get
	 */
	public double getZ() {
		return this.z;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
	}
	
	@Override
	public boolean equals(Object inputCoordinate) {
		assert inputCoordinate instanceof CartesianCoordinate;
		
		CartesianCoordinate coord = (CartesianCoordinate)inputCoordinate;
		
		return this.isEqual(coord);
	}
	
	@Override
	public boolean isEqual(Coordinate coordinate) {
		assertClassInvariants();
		CartesianCoordinate inputCoordinate = coordinate.asCartesianCoordinate();
		
		if(isDoubleEqual(inputCoordinate.x, this.x) &&
				isDoubleEqual(inputCoordinate.y, this.y) &&
				isDoubleEqual(inputCoordinate.z, this.z)) {
			return true;		
		}
		
		return false;
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() throws IllegalArgumentException{
		assertClassInvariants();
		return this;
	}
	
	@Override
	public SphericCoordinate asSphericCoordinate() throws IllegalArgumentException {
		assertClassInvariants();
		double longitude;
		double latitude;
		
		double squareX = Math.pow(this.x, 2);
		double squareY = Math.pow(this.y, 2);
		double squareZ = Math.pow(this.z, 2);

		latitude = Math.toDegrees(Math.atan(this.y / this.x));
		longitude = Math.toDegrees(Math.atan(Math.sqrt(squareX+squareY) / this.z));
		
		return SphericCoordinate.getInstance(latitude, longitude);
	}

	@Override
	protected void assertClassInvariants() {
		Assertion.assertIsNotNull(this);
		Assertion.assertIsValidDouble(this.getX());
		Assertion.assertIsValidDouble(this.getY());
		Assertion.assertIsValidDouble(this.getZ());
	}
}
