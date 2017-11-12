/*Author: Artur Mandybura, https://github.com/ArtyMandy/wahlzeit
 *
 *Class: CigarettePhotoTest
 *
 *Version information: adap-cw05  
 *
 * Date: 8. Nov. 2017
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
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class CigarettePhotoTest {

	
	@ClassRule
	public static TestRule chain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());
	
	private CigarettePhoto p1;
	
	@Before
	public void setUp() {
		p1 = new CigarettePhoto();
		p1.setLocation(new Location(new Coordinate(1,1,1)));
		p1.setBrand("L&M");
		p1.setManufacturer("Philip Morris GmbH");
		
	}
	@Test
	public void createdPhotoShouldMatchCigarettePhoto() {
		assertTrue(p1 instanceof CigarettePhoto);
		assertEquals(p1.getClass(), CigarettePhoto.class);
		assertTrue(p1.location.equals(new Location(new Coordinate(1,1,1))));
		assertTrue(p1.getBrand().equals("L&M"));
	}
	
}
