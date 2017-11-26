/*Author: Artur Mandybura, https://github.com/ArtyMandy/wahlzeit
 *
 * Class: SphericCoordinateTest
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SphericCoordinateTest {

	public static final double DELTA = 0.00001;

	Coordinate coo1;
	Coordinate coo2;
	Coordinate coo3;
	Coordinate coo4;
	Coordinate coo5;
	Coordinate coo6;
	Coordinate coo7;
	
	@Before
	public void setUp() {
		//Nuremberg - Munich SphericDistance: 151.9448210895663
		//Nuremberg - Berlin SphericDistance: 377.56829689841425
		//Munich - Berlin SphericDistance: 504.300829009964
		//Nuremberg
        coo1 = new SphericCoordinate(49.460983, 11.061859);
		//Munich
		coo2 = new SphericCoordinate(48.137154, 11.576124);
		//Berlin
		coo3 = new SphericCoordinate(52.520008, 13.404954);
		//Berlin Cartesian Coordinate
		coo4 = new CartesianCoordinate(898.7324481, 1172.098186, 6197.427436);
		
		coo5 = new SphericCoordinate(10.0, 10.0);
		coo6 = new SphericCoordinate(10.0, 10.0);
		coo7 = new SphericCoordinate(20.0, 10.0);
		
		
	}
	

	@Test
	public void convertToSphericCoordinate() {
		assertTrue(coo1.asSphericCoordinate() instanceof SphericCoordinate);
		assertTrue(coo4.asSphericCoordinate() instanceof SphericCoordinate);
		
	}
	
	@Test
	public void berlinCoordinateShouldMatchToCartesian() {
		assertEquals(coo4.asSphericCoordinate().getLat(), coo3.asSphericCoordinate().getLat(), DELTA);
		assertEquals(coo4.asSphericCoordinate().getLong(), coo3.asSphericCoordinate().getLong(), DELTA);
	}
	
	@Test
	public void distanceShouldMatch(){
		assertEquals(0, coo4.asSphericCoordinate().getSphericDistance(coo3), DELTA);
		assertEquals(151.9448210895663, coo1.asSphericCoordinate().getSphericDistance(coo2), DELTA);
		assertEquals(377.56829689841425, coo1.asSphericCoordinate().getSphericDistance(coo3), DELTA);
		assertEquals(504.300829009964, coo2.asSphericCoordinate().getSphericDistance(coo3), DELTA);
	}

	@Test
	public void equalsFunctionCheck() {
		assertTrue(coo5.equals(coo6));
		assertFalse(coo6.equals(coo7));
	}

}
