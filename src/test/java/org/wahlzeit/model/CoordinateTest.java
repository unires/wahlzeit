package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the Coordinate class.
 */
public class CoordinateTest {
	
	private static final double DELTA = 0.0001;
	
	SphericCoordinate a;
	SphericCoordinate b;
	SphericCoordinate nullCoord;
	
	
	@Before
	public void setUp() throws Exception {
		a = new SphericCoordinate(42.0, 43.0);
		b = new SphericCoordinate(52.0, 44.0);
		nullCoord = null;
	}

	@Test
	public void testDistances() {
		assertEquals("should be 10", 10.0, a.getLatitudinalDistance(b), DELTA);
		assertEquals("should be 1", 1.0, a.getLongitudinalDistance(b), DELTA);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullLatitudeDistance() {
		a.getLatitudinalDistance(nullCoord);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullLongitudeDistance() {
		a.getLongitudinalDistance(nullCoord);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullDistance() {
		a.getDistance(nullCoord);
	}
	
	@Test
	public void testEquals() {
		assertTrue(a.equals(a));
		assertTrue(a.equals(new SphericCoordinate(a.getLatitude(), a.getLongitude())));
		assertFalse(a.equals(b));
		assertFalse(a.equals(nullCoord));
	}
	
	@Test
	public void testHashCode() {
		assertTrue(a.hashCode() == a.hashCode());
		assertTrue(a.hashCode() == new SphericCoordinate(a.getLatitude(), a.getLongitude()).hashCode());
		assertFalse(a.hashCode() == b.hashCode());
	}
	
	@Test
	public void testAsString() {
		assertTrue(a.asString().equals("42.0, 43.0"));
	}
	
}
