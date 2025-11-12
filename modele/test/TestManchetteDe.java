/*
 * TestManchetteDe.java                 24 août 2024
 * pas de copyright
 */
package modele.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modele.ManchetteDe;

/**
 * Test de la classe ManchetteDe
 * @author Adrien Vigué
 */
class TestManchetteDe {

	/**
	 * Test method for {@link modele.ManchetteDe#ManchetteDe(int, int)}.
	 */
	@Test
	void testManchetteDe() {
		assertThrows(IllegalArgumentException.class, ()-> new ManchetteDe(0, 6));
		assertThrows(IllegalArgumentException.class, ()-> new ManchetteDe(11, 6));
		assertThrows(IllegalArgumentException.class, ()-> new ManchetteDe(-55, 6));
		assertThrows(IllegalArgumentException.class, ()-> new ManchetteDe(84, 6));
		assertThrows(IllegalArgumentException.class, ()-> new ManchetteDe(0, 1));
		assertThrows(IllegalArgumentException.class, ()-> new ManchetteDe(4, 0));
		assertThrows(IllegalArgumentException.class, ()-> new ManchetteDe(5, 101));
		assertThrows(IllegalArgumentException.class, ()-> new ManchetteDe(2, 120));
		assertDoesNotThrow(()-> new ManchetteDe(5, 6));
		assertDoesNotThrow(()-> new ManchetteDe(1, 6));
		assertDoesNotThrow(()-> new ManchetteDe(10, 6));
	}

	/**
	 * Test method for {@link modele.ManchetteDe#getResultats()}.
	 */
	@Test
	void testGetResultats() {
		assertDoesNotThrow(()-> new ManchetteDe(5, 6).getResultats());
		assertDoesNotThrow(()-> new ManchetteDe(1, 6).getResultats());
		assertDoesNotThrow(()-> new ManchetteDe(10, 6).getResultats());
	}

	/**
	 * Test method for {@link modele.ManchetteDe#getNombreDe()}.
	 */
	@Test
	void testGetNombreDe() {
		assertEquals(5, new ManchetteDe(5, 6).getNombreDe());
		assertEquals(1, new ManchetteDe(1, 6).getNombreDe());
		assertEquals(10, new ManchetteDe(10, 6).getNombreDe());
	}

}
