package org.wahlzeit.model;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.wahlzeit.testEnvironmentProvider.LocalDatastoreServiceTestConfigProvider;

public class PhotoFactoryTest {

	@ClassRule
	public static TestRule chain = RuleChain.outerRule(new LocalDatastoreServiceTestConfigProvider());
	
	private CigaretteFactory fact;
	private CigarettePhoto firstPhoto;
	@Before
	public void setUp() {
		fact = CigaretteFactory.getInstance();
		firstPhoto = fact.createPhoto();
		firstPhoto.setLocation(new Location(new Coordinate(1,1,1)));
		
	}
	@Test
	public void createFactory() {
		assertTrue(fact instanceof CigaretteFactory);
		assertTrue(firstPhoto instanceof CigarettePhoto);
		assertTrue(firstPhoto.location.equals(new Location(new Coordinate(1,1,1))));
		
	}

}
