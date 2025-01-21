/**
 * TestCombo.java                 7 sept. 2024
 * pas de copyright
 */
package modele.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modele.Combo;

/**
 * Vérifie le bon fonctionnement des combos
 * @author Adrien Vigué
 */
class TestCombo {
	
	private static final int[][] JEU_DE_TEST = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
			                                    {6, 2, 4, 3, 5}, {100, 100}, 
			                                    {1, 1, 2, 3, 3, 3}, {1, 1},
			                                    {4, 4, 4, 4, 8},
			                                    {5, 5, 5, 5, 5, 9},
			                                    {6, 6, 6, 6, 6, 6, 9},
			                                    {6, 6, 6, 6, 6, 6, 6, 9},
			                                    {6, 6, 6, 6, 6, 6, 6, 6, 9},
			                                    {6, 6, 6, 6, 6, 6, 6, 6, 6, 9},
			                                    {6, 6, 6, 6, 6, 6, 6, 6, 6, 6},
			                                    {28, 29, 27, 26, 24, 25, 23, 22}, 
			                                    {1, 3, 9}};
	
	private static final int[][] JEU_ERRONNE = 
		                         {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
		                          {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}};
		
	private static final String[] RESULTAT_COMBO =
		{"[ suite parfaite de 1 à 10 | ]", "[ suite de 2 à 6 | ]",
	     "[ full | pair ]", "[ brelan de 3 | petite suite de 1 à 3 | ]",
	     "[ full | impair ]", "[ carré de 4 | pair ]", "[ Yandee de 5 | impair ]",
	     "[ double brelan de 6 | ]", "[ carré et brelan de 6 | ]",
	     "[ double carré de 6 | ]", "[ Yandee et carré de 6 | ]",
	     "[ double Yandee de 6 | full | pair ]",
	     "[ grande suite de 22 à 29 | ]", "[ chance | impair ]"};
	
	public static final int[] SCORE_COMBO = {700, 350, 40, 290, 40, 320,
			                                 500, 360, 420, 480, 540, 
			                                 1400, 500, 26};

	/**
	 * Test method for {@link modele.Combo#Combo(int[])}.
	 */
	@Test
	void testCombo() {
		assertThrows(IllegalArgumentException.class,
				()-> new Combo(JEU_ERRONNE[0]));
		assertThrows(IllegalArgumentException.class,
				()-> new Combo(JEU_ERRONNE[1]));
		assertDoesNotThrow(()-> new Combo(JEU_DE_TEST[0]));
		assertDoesNotThrow(()-> new Combo(JEU_DE_TEST[1]));
		assertDoesNotThrow(()-> new Combo(JEU_DE_TEST[2]));
		assertDoesNotThrow(()-> new Combo(JEU_DE_TEST[3]));
		assertDoesNotThrow(()-> new Combo(JEU_DE_TEST[4]));
		assertDoesNotThrow(()-> new Combo(JEU_DE_TEST[5]));
		assertDoesNotThrow(()-> new Combo(JEU_DE_TEST[6]));
		assertDoesNotThrow(()-> new Combo(JEU_DE_TEST[7]));
		assertDoesNotThrow(()-> new Combo(JEU_DE_TEST[8]));
		assertDoesNotThrow(()-> new Combo(JEU_DE_TEST[9]));
		assertDoesNotThrow(()-> new Combo(JEU_DE_TEST[10]));
		assertDoesNotThrow(()-> new Combo(JEU_DE_TEST[11]));
		assertDoesNotThrow(()-> new Combo(JEU_DE_TEST[12]));
		assertDoesNotThrow(()-> new Combo(JEU_DE_TEST[13]));
	}

	/**
	 * Test method for {@link modele.Combo#getAnnonces()}.
	 */
	@Test
	void testGetAnnonces() {
		assertEquals(RESULTAT_COMBO[0], new Combo(JEU_DE_TEST[0]).getAnnonces());
		assertEquals(RESULTAT_COMBO[1], new Combo(JEU_DE_TEST[1]).getAnnonces());
		assertEquals(RESULTAT_COMBO[2], new Combo(JEU_DE_TEST[2]).getAnnonces());
		assertEquals(RESULTAT_COMBO[3], new Combo(JEU_DE_TEST[3]).getAnnonces());
		assertEquals(RESULTAT_COMBO[4], new Combo(JEU_DE_TEST[4]).getAnnonces());
		assertEquals(RESULTAT_COMBO[5], new Combo(JEU_DE_TEST[5]).getAnnonces());
		assertEquals(RESULTAT_COMBO[6], new Combo(JEU_DE_TEST[6]).getAnnonces());
		assertEquals(RESULTAT_COMBO[7], new Combo(JEU_DE_TEST[7]).getAnnonces());
		assertEquals(RESULTAT_COMBO[8], new Combo(JEU_DE_TEST[8]).getAnnonces());
		assertEquals(RESULTAT_COMBO[9], new Combo(JEU_DE_TEST[9]).getAnnonces());
		assertEquals(RESULTAT_COMBO[10], new Combo(JEU_DE_TEST[10]).getAnnonces());
		assertEquals(RESULTAT_COMBO[11], new Combo(JEU_DE_TEST[11]).getAnnonces());
		assertEquals(RESULTAT_COMBO[12], new Combo(JEU_DE_TEST[12]).getAnnonces());
		assertEquals(RESULTAT_COMBO[13], new Combo(JEU_DE_TEST[13]).getAnnonces());
	}

	/**
	 * Test method for {@link modele.Combo#getPoints()}.
	 */
	@Test
	void testGetPoints() {
		assertEquals(SCORE_COMBO[0], new Combo(JEU_DE_TEST[0]).getPoints());
		assertEquals(SCORE_COMBO[1], new Combo(JEU_DE_TEST[1]).getPoints());
		assertEquals(SCORE_COMBO[2], new Combo(JEU_DE_TEST[2]).getPoints());
		assertEquals(SCORE_COMBO[3], new Combo(JEU_DE_TEST[3]).getPoints());
		assertEquals(SCORE_COMBO[4], new Combo(JEU_DE_TEST[4]).getPoints());
		assertEquals(SCORE_COMBO[5], new Combo(JEU_DE_TEST[5]).getPoints());
		assertEquals(SCORE_COMBO[6], new Combo(JEU_DE_TEST[6]).getPoints());
		assertEquals(SCORE_COMBO[7], new Combo(JEU_DE_TEST[7]).getPoints());
		assertEquals(SCORE_COMBO[8], new Combo(JEU_DE_TEST[8]).getPoints());
		assertEquals(SCORE_COMBO[9], new Combo(JEU_DE_TEST[9]).getPoints());
		assertEquals(SCORE_COMBO[10], new Combo(JEU_DE_TEST[10]).getPoints());
		assertEquals(SCORE_COMBO[11], new Combo(JEU_DE_TEST[11]).getPoints());
		assertEquals(SCORE_COMBO[12], new Combo(JEU_DE_TEST[12]).getPoints());
		assertEquals(SCORE_COMBO[13], new Combo(JEU_DE_TEST[13]).getPoints());
	}

}
