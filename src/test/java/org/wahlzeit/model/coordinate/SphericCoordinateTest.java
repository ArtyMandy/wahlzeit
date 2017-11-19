package org.wahlzeit.model.coordinate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SphericCoordinateTest {

	public static final double DELTA = 0.00001;

	Coordinate coo1;
	Coordinate coo2;
	Coordinate coo3;
	Coordinate coo4;
	
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

}
