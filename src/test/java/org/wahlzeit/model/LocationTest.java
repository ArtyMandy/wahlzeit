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
