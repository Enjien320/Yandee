/**
 * TestDe.java                 23 août 2024
 * pas de copyright
 */
package modele.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modele.De;

/**
 * Véridie le bon fonctionnememnt des dés
 * @author Adrien Vigué
 */
class TestDe {

	/**
	 * Test method for {@link modele.De#De(int)}.
	 */
	@Test
	void testDe() {
		assertThrows(IllegalArgumentException.class, ()-> new De(1));
		assertThrows(IllegalArgumentException.class, ()-> new De(0));
		assertThrows(IllegalArgumentException.class, ()-> new De(120));
		assertThrows(IllegalArgumentException.class, ()-> new De(101));
		assertDoesNotThrow(()-> new De(2));
		assertDoesNotThrow(()-> new De(100));
		assertDoesNotThrow(()-> new De(28));
	}

	/**
	 * Test method for {@link modele.De#lancementDe()}.
	 */
	@Test
	void testLancementDe() {
		assertDoesNotThrow(()->new De(2).lancementDe());
		assertDoesNotThrow(()->new De(100).lancementDe());
		assertDoesNotThrow(()->new De(28).lancementDe());
	}
	
	/**
	 * Test method for {@link modele.De#lancementDe()}.
	 */
	@Test
	void testGetResultatDe() {
		assertDoesNotThrow(()->new De(2).getResultatDe());
		assertDoesNotThrow(()->new De(100).getResultatDe());
		assertDoesNotThrow(()->new De(28).getResultatDe());
	}

	/**
	 * Test method for {@link modele.De#getNombreFace()}.
	 */
	@Test
	void testGetNombreFace() {
		assertEquals(2, new De(2).getNombreFace());
		assertEquals(100, new De(100).getNombreFace());
		assertEquals(28, new De(28).getNombreFace());
	}

}
