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

package org.wahlzeit.model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for {@link Coordinate}.
 */
public class CoordinateTest {
	
	private Coordinate coo1;
	private Coordinate coo2;
	private Coordinate coo3;
	private Coordinate coo4;
	private Coordinate coo5;
	
	@Before 
	public void setUp() {
		coo1 = new Coordinate(0,0,0); // x: 0, y: 0, z: 0
		coo2 = new Coordinate(2,2,2); // x: 2, y: 2, z: 2 
		coo3 = new Coordinate(5,5,5); // x: 5, y: 5, z: 5
		coo4 = new Coordinate(5,5,5);
		coo5 = new Coordinate(0,0,0);
		
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
	}
	
	@Test
	public void coordsShouldNotMatch() {
		assertFalse(coo3.equals(coo2));
		assertFalse(coo5.equals(coo2));
	}
}
