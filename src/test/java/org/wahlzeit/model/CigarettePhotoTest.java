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
import org.wahlzeit.model.coordinate.CartesianCoordinate;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class CigarettePhotoTest {

	
	@ClassRule
	public static TestRule chain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());
	
	private CigarettePhoto p1;
	private CigarettePhoto p2;
	private CigaretteObjectManager manager;
	
	@Before
	public void setUp() {
		p1 = new CigarettePhoto();
		p2 = new CigarettePhoto();
		manager = CigaretteObjectManager.getInstance();
		p1.setLocation(new Location(CartesianCoordinate.getInstance(1,1,1)));
		manager.createCigaretteType("L&M RedLabel", "Red Label", "Phillip Morris GmbH");
		manager.createCigaretteType("L&M BlueLabel", "Blue Label", "Philip Morris GmbH");
		manager.createCigaretteType("Gauloises Blend Red", "Blend Red", "British American Tabacco");
		
		Cigarette cigLmRed= manager.createCigarette("L&M RedLabel");
		Cigarette cigGauloisesRed = manager.createCigarette("Gauloises Blend Red");
		p1.setCigarette(cigLmRed);
		p2.setCigarette(cigGauloisesRed);
	}
	@Test
	public void createdPhotoShouldMatchCigarettePhoto() {
		assertTrue(p1 instanceof CigarettePhoto);
		assertEquals(p1.getClass(), CigarettePhoto.class);
		assertTrue(p1.location.equals(new Location(CartesianCoordinate.getInstance(1,1,1))));
		assertEquals(manager.getCigaretteType("L&M RedLabel"), p1.getCigarette().getType());
		assertEquals(manager.getCigaretteType("Gauloises Blend Red"), p2.getCigarette().getType());
	}
	
}
