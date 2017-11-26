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

import java.util.Objects;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class CartesianCoordinate extends AbstractCoordinate{
	
	private double x;
	private double y;
	private double z;
	
	
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
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
	
	/**
	 * @methodtype set
	 */
	public double setX(double x) {
		return this.x = x;
	}
	
	/**
	 * @methodtype set
	 */
	public double setY(double y) {
		return this.y = y;
	}
	
	/**
	 * @methodtype set
	 */
	public double setZ(double z) {
		return this.z = z;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
	}
	
	@Override
	public boolean equals(Object inputCoordinate) {
		if(!(inputCoordinate instanceof CartesianCoordinate)) {
			return false;
		}
		
		CartesianCoordinate coord = (CartesianCoordinate)inputCoordinate;
		
		return this.isEqual(coord);
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}
	
	@Override
	public SphericCoordinate asSphericCoordinate() {
		double longitude;
		double latitude;
		double radius;
		
		double squareX = Math.pow(this.x, 2);
		double squareY = Math.pow(this.y, 2);
		double squareZ = Math.pow(this.z, 2);

		latitude = Math.toDegrees(Math.atan(this.y / this.x));
		longitude = Math.toDegrees(Math.atan(Math.sqrt(squareX+squareY) / this.z));
		radius = Math.sqrt(squareX + squareY + squareZ);
		
		return new SphericCoordinate(latitude, longitude, radius);
	}
	
	@Override
	public boolean isEqual(Coordinate coordinate) {
		CartesianCoordinate inputCoordinate = coordinate.asCartesianCoordinate();
		
		if(inputCoordinate != null && 
				isDoubleEqual(inputCoordinate.x, this.x) &&
				isDoubleEqual(inputCoordinate.y, this.y) &&
				isDoubleEqual(inputCoordinate.z, this.z)) {
			return true;		
		}
		
		return false;
	}
}
