/*Author: Artur Mandybura, https://github.com/ArtyMandy/wahlzeit
 *
 * Class: LocationTest
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


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test; 


/**
 * Test class for {@link Location}.
 */
public class LocationTest {

	private Location l1;
	private Location l2;
	private Location l3;
	private Location l4;
	private Location l5;
	
	
	@Before
	public void setUp() {
		l1 = new Location(new Coordinate(1,1,1));
		l2 = new Location(new Coordinate(1,1,2));
		l3 = new Location(new Coordinate(1,3,1));
		l4 = new Location(new Coordinate(4,1,1));
		l5 = new Location(new Coordinate(1,1,1));
	}
	
	@Test
	public void locationsShouldNotMatch() {
		assertFalse(l1.equals(l2));
		assertFalse(l1.equals(l2));
		assertFalse(l1.equals(l3));
		assertFalse(l1.equals(l4));
	}
	@Test
	public void locationsShouldMatch() {
		assertTrue(l1.equals(l5));
		assertTrue(l1.equals(l1));
		
	}
}
