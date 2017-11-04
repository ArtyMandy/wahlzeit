/*Author: Artur Mandybura, https://github.com/ArtyMandy/wahlzeit
 *
 *Class: Coordinate
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
package org.wahlzeit.model;

public class Coordinate {
	
	private double x;
	private double y;
	private double z;
	
	public Coordinate(double x, double y, double z) {
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
	public double getDistance(Coordinate inputCoordinate) {
		double distance;	
		distance = Math.pow((inputCoordinate.x - x), 2) + Math.pow((inputCoordinate.y - y), 2) + Math.pow((inputCoordinate.z - z), 2);
		return Math.sqrt(distance);
	}
	
	private boolean isEqual(Coordinate inputCoordinate) {
		if(this.x == inputCoordinate.x && this.x == inputCoordinate.y && this.z == inputCoordinate.z) {
			return true;
		}
		else
			return false;
	}
	
	@Override
	public boolean equals(Object inputCoordinate) {
		if(inputCoordinate == null) {
			return false;
		}
		if(!(inputCoordinate instanceof Coordinate)) {
			return false;
		}
		Coordinate coord = (Coordinate)inputCoordinate;
		return this.isEqual(coord);
	}
}
