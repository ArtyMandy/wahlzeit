/*Author: Artur Mandybura, https://github.com/ArtyMandy/wahlzeit
 *
 *Class: CigaretteFactoryTest
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

import org.junit.*;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class CigaretteFactoryTest {

	@ClassRule
	public static TestRule chain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());
	
	private CigaretteFactory fact;
	private CigarettePhoto firstPhoto;
	
	@Before
	public void setUp() {
		fact = CigaretteFactory.getInstance();
		firstPhoto = fact.createPhoto();
	}
	
	@Test
	public void createFactory() {
		assertTrue(fact instanceof CigaretteFactory);
		assertEquals(fact.getClass(), CigaretteFactory.class);
	}
	
	@Test(expected = IllegalStateException.class)
	public void initializeShouldThrowException() {
		CigaretteFactory.setInstance(fact);
	}
	
	@Test
	public void checkPhotoWithLocation() {
		firstPhoto.setLocation(new Location(new Coordinate(1,1,1)));
		Coordinate co = new Coordinate(1,1,1);
		assertEquals(co,firstPhoto.getLocation());
	}

}
