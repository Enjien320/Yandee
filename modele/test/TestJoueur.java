/*
 * TestJoueur.java                 14 oct. 2025
 * pas de copyright
 */
package modele.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modele.Joueur;

/**
 * Décrire l'utilité de la classe
 * @author Adrien Vigué
 */
class TestJoueur {

	/**
	 * Test method for {@link modele.Joueur#Joueur(java.lang.String)}.
	 */
	@Test
	void testJoueur() {
		assertDoesNotThrow(()-> new Joueur(null));
		assertDoesNotThrow(()-> new Joueur(""));
		assertDoesNotThrow(()-> new Joueur("      "));
		assertDoesNotThrow(()-> new Joueur("\n"));
		assertDoesNotThrow(()-> new Joueur("Enjien"));
		assertDoesNotThrow(()-> new Joueur("Le mec trop fort du 32"));
	}

	/**
	 * Test method for {@link modele.Joueur#getPseudo()}.
	 */
	@Test
	void testGetPseudo() {
		assertEquals("Joueur", new Joueur(null).getPseudo());
		assertEquals("Joueur", new Joueur("").getPseudo());
		assertEquals("Joueur", new Joueur("    ").getPseudo());
		assertEquals("Joueur", new Joueur("\n").getPseudo());
		assertEquals("Enjien", new Joueur("Enjien").getPseudo());
		assertEquals("Le mec trop fort du 32", 
				     new Joueur("Le mec trop fort du 32").getPseudo());
	}

	/**
	 * Test method for {@link modele.Joueur#setPseudo(java.lang.String)}.
	 */
	@Test
	void testSetPseudo() {
		Joueur joueur;
		
		assertDoesNotThrow(()-> new Joueur(null).setPseudo("Enjien"));
		assertDoesNotThrow(()-> new Joueur("").setPseudo("Enjien"));
		assertDoesNotThrow(()-> new Joueur("  ").setPseudo("Enjien"));
		assertDoesNotThrow(()-> new Joueur("\n").setPseudo("Enjien"));
		assertDoesNotThrow(()-> new Joueur("Enjien").setPseudo(null));
		assertDoesNotThrow(()-> new Joueur("Enjien").setPseudo("  "));
		assertDoesNotThrow(()-> new Joueur("Enjien").setPseudo(""));
		assertDoesNotThrow(()-> new Joueur("Enjien").setPseudo("\n"));
		
		joueur = new Joueur(null);
		joueur.setPseudo("Enjien");
		assertEquals("Enjien", joueur.getPseudo());
		joueur.setPseudo(null);
		assertEquals("Joueur", joueur.getPseudo());
		joueur.setPseudo("");
		assertEquals("Joueur", joueur.getPseudo());
		joueur.setPseudo("  ");
		assertEquals("Joueur", joueur.getPseudo());
		joueur.setPseudo("\n");
		assertEquals("Joueur", joueur.getPseudo());
	}

	/**
	 * Test method for {@link modele.Joueur#getScore()}.
	 */
	@Test
	void testGetScore() {
		Joueur joueur;
		joueur = new Joueur(null);
		assertEquals(0, joueur.getScore());
		joueur.setScore(50);
		assertEquals(50, joueur.getScore());
	}

	/**
	 * Test method for {@link modele.Joueur#setScore(int)}.
	 */
	@Test
	void testSetScore() {
		assertDoesNotThrow(()-> new Joueur(null).setScore(50));
		assertDoesNotThrow(()-> new Joueur(null).setScore(1));
		assertDoesNotThrow(()-> new Joueur(null).setScore(0));
		assertThrows(IllegalArgumentException.class,
				     ()-> new Joueur(null).setScore(-1));
		assertThrows(IllegalArgumentException.class,
				     ()-> new Joueur(null).setScore(-50));
	}

}
