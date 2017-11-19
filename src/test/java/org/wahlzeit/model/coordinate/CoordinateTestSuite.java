package org.wahlzeit.model.coordinate;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	org.wahlzeit.model.coordinate.CartesianCoordinateTest.class,
	org.wahlzeit.model.coordinate.SphericCoordinateTest.class
})

public class CoordinateTestSuite {
	
	public CoordinateTestSuite() {
		// do nothing
	}

}
