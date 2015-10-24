package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the Coordinate class.
 */
public class CoordinateTest {
	
	private static final double DELTA = 0.0001;
	
	Coordinate a;
	Coordinate b;
	Coordinate nullCoord;
	
	
	@Before
	public void setUp() throws Exception {
		a = new Coordinate(42.0, 43.0);
		b = new Coordinate(52.0, 44.0);
		nullCoord = null;
	}

	@Test
	public void testDistances() {
		assertEquals("should be 10", 10.0, a.getLatitudeDistance(b), DELTA);
		assertEquals("should be 1", 1.0, a.getLongitudeDistance(b), DELTA);
		assertEquals("should be 10", 10.0, a.getDistance(b).getLatitude(), DELTA);
		assertEquals("should be 1", 1.0, a.getDistance(b).getLongitude(), DELTA);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullLatitudeDistance() {
		a.getLatitudeDistance(nullCoord);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullLongitudeDistance() {
		a.getLongitudeDistance(nullCoord);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullDistance() {
		a.getDistance(nullCoord);
	}
	
	@Test
	public void testEquals() {
		assertTrue(a.equals(a));
		assertTrue(a.equals(new Coordinate(a.getLatitude(), a.getLongitude())));
		assertFalse(a.equals(b));
		assertFalse(a.equals(nullCoord));
	}
	
	@Test
	public void testAsString() {
		assertTrue(a.asString().equals("42.0, 43.0"));
	}
	
}
