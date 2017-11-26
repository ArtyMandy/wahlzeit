/*Author: Artur Mandybura, https://github.com/ArtyMandy/wahlzeit
 *
 *Class: AbstractCoordinate
 *
 *Version information: adap-cw07
 *
 * Date: 26. Nov. 2017
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

public abstract class AbstractCoordinate implements Coordinate{

	public static final double DELTA = 0.0000001;  
	
	@Override
	public abstract CartesianCoordinate asCartesianCoordinate();

	@Override
	public double getCartesianDistance(Coordinate coordinate) {
		assertIsNotNull(coordinate);
		CartesianCoordinate actual = this.asCartesianCoordinate();
		CartesianCoordinate inputCoordinate = coordinate.asCartesianCoordinate();
		double distance;	
		
		distance = Math.pow((inputCoordinate.getX() - actual.getX()), 2) 
					+ Math.pow((inputCoordinate.getY() - actual.getY()), 2)
					+ Math.pow((inputCoordinate.getZ() - actual.getZ()), 2);
		
		return Math.sqrt(distance);	
	}

	@Override
	public abstract SphericCoordinate asSphericCoordinate();

	@Override
	public double getSphericDistance(Coordinate coordinate) {
		assertIsNotNull(coordinate);
		SphericCoordinate actual = this.asSphericCoordinate();
		SphericCoordinate inputCoordinate = coordinate.asSphericCoordinate();
		double diffLatitude = Math.toRadians(actual.getLat()) - Math.toRadians(inputCoordinate.getLat());
		double diffLongitude = Math.toRadians(actual.getLong()) - Math.toRadians(inputCoordinate.getLong());
		
		double sum = Math.sin(diffLatitude / 2) * Math.sin(diffLatitude / 2) +
							Math.cos(Math.toRadians(actual.getLat()) ) * Math.cos(Math.toRadians(inputCoordinate.getLat()) ) * 
							(Math.sin(diffLongitude / 2) * Math.sin(diffLongitude /2));
		
		double distance = 2 * Math.asin(Math.sqrt(sum)) * actual.getRadius() ;
		
		return distance;
	}
	
	/**
	 * Calculate always the CartesianDistance for the given coordinate
	 */
	@Override
	public double getDistance(Coordinate coordinate) {
		assertIsNotNull(coordinate);
		return getCartesianDistance(coordinate);
		
	}

	@Override
	public abstract boolean isEqual(Coordinate coordinate);

	
	protected boolean isDoubleEqual(double a, double b) {
		return Math.abs(a - b) <= DELTA;
	}
	
	protected void assertIsNotNull(Coordinate coordinate) {
		if(coordinate == null) {
			throw new IllegalArgumentException("Coordinate is null");
		}
	}
}
