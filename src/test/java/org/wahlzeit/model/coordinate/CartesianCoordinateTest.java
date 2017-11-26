/*Author: Artur Mandybura, https://github.com/ArtyMandy/wahlzeit
 *
 * Class: CoordinateTest
 *
 *Version information: adap-cw04
 *
 * Date: 4. Nov. 2017
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.coordinate.CartesianCoordinate;

/**
 * Test class for {@link CartesianCoordinate}.
 */
public class CartesianCoordinateTest {
	
	public static final double DELTA = 0.00001;
	
	private CartesianCoordinate coo1;
	private CartesianCoordinate coo2;
	private CartesianCoordinate coo3;
	private CartesianCoordinate coo4;
	private CartesianCoordinate coo5;
	
	private Coordinate coo6;
	private Coordinate coo7;
	private Coordinate coo8;
	private Coordinate coo9;
	private Coordinate coo10;
	private Coordinate coo11;
	
	@Before 
	public void setUp() {
		coo1 = new CartesianCoordinate(0,0,0); // x: 0, y: 0, z: 0
		coo2 = new CartesianCoordinate(2,2,2); // x: 2, y: 2, z: 2 
		coo3 = new CartesianCoordinate(5,5,5); // x: 5, y: 5, z: 5
		coo4 = new CartesianCoordinate(5,5,5);
		coo5 = new CartesianCoordinate(0,0,0);
		//Moskau Latitude: 55.751244, Longtitude: 37.618423
		coo6 = new CartesianCoordinate(2188.598471, 3214.537412, 5046.427148);
		//London Latitude: 51.508530 Longtitude: -0.076132
		coo7 = new CartesianCoordinate(-5.268904832, -6.625945753, 6370.994376);
		coo8 = new SphericCoordinate(51.508530, -0.076132);
		coo9 = new CartesianCoordinate(10,10,10);
		coo10 = new CartesianCoordinate(10,10,10);
		coo11 = new CartesianCoordinate(20,20,20);
		
	}
	
	/* Coordinates: coo1, coo2
	 * Testcase test the secondCoord.getDistance() function to calculate the distance to firstCoord
	 * calculation by hand:
	 * distance^2 = (2-0)^2 +(2-0)^2 + (2-0)^2 = distance = sqrt(12) = 3.464101615
	 * correct value: 3.464101615 to pass the test
	 */
	@Test
	public void calculateDistanceFirstSecondCoords() {
		assertEquals(3.464101615, coo1.getDistance(coo2),0.000001);
	}
	
	/* Coordinates: coo2, coo3
	 * Testcase should test the thirdCoord.getDistance() function to calculate the distance to secondCoord
	 * calculation by hand:
	 * distance^2 = (5-2)^2 +(5-2)^2 + (5-2)^2 = distance = sqrt(27) = 5.196152423
	 * correct value: 5.196152423 to pass the test
	 */
	@Test
	public void calculateDistanceSecondThirdCoords() {
		assertEquals(5.196152423, coo3.getDistance(coo2), 0.000001);
	}
	
	@Test
	public void zeroDistance() {
		assertEquals(0, coo5.getDistance(coo1), 0.000001);
	}
	
	@Test
	public void coordsShouldMatch(){
		assertTrue(coo4.equals(coo3));
		assertTrue(coo1.equals(coo1));
		assertTrue(coo9.equals(coo10));
	}
	
	@Test
	public void coordsShouldNotMatch() {
		assertFalse(coo3.equals(coo2));
		assertFalse(coo5.equals(coo2));
		assertFalse(coo10.equals(coo11));
	}
	

	@Test
	public void convertCartesianToSpheric() {
		assertEquals(55.751244, coo6.asSphericCoordinate().getLat(), DELTA);
		assertEquals(37.618423, coo6.asSphericCoordinate().getLong(), DELTA);
		assertEquals(51.508530, coo7.asSphericCoordinate().getLat(), DELTA);
		assertEquals(0.076132, coo7.asSphericCoordinate().getLong(), DELTA);
	}
	
	@Test
	public void convertSphericToCartesian(){
		assertTrue(coo8.asCartesianCoordinate() instanceof CartesianCoordinate);
		assertEquals(coo7.asCartesianCoordinate().getX(),coo8.asCartesianCoordinate().getX(), DELTA);
		assertEquals(coo7.asCartesianCoordinate().getY(), coo8.asCartesianCoordinate().getY(), DELTA);
		assertEquals(coo7.asCartesianCoordinate().getZ(), coo8.asCartesianCoordinate().getZ(), DELTA);
	}
	
	
	
}
