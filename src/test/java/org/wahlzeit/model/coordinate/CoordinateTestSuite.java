/*Author: Artur Mandybura, https://github.com/ArtyMandy/wahlzeit
 *
 * Class: CoordinateTestSuite
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
