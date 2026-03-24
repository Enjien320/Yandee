/*
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
		                         {null, {},
		                          {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
		                          {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}};
		
	private static final String[] RESULTAT_COMBO =
		{"[ Suite parfaite de 1 à 10 | ]", "[ Suite de 2 à 6 | ]",
	     "[ Full | Pair ]", "[ Brelan de 3 | Petite suite de 1 à 3 | ]",
	     "[ Full | Impair ]", "[ Carré de 4 | Pair ]", "[ Yandee de 5 | Impair ]",
	     "[ Double brelan de 6 | ]", "[ Carré et brelan de 6 | ]",
	     "[ Double carré de 6 | ]", "[ Triple brelan de 6 | ]",
	     "[ Double Yandee de 6 | Full | Pair ]",
	     "[ Grande suite de 22 à 29 | ]", "[ Chance | Impair ]"};
	
	public static final int[] SCORE_COMBO = {900, 230, 200, 199, 200, 320,
			                                 500, 360, 420, 480, 540, 
			                                 2200, 632, 26};
	public static final String[] SCORE_ANNONCE =
		{"{Suite parfaite=900}", "{Suite6=230}", "{Full=100}",
		 "{Petite suite3=109, Brelan3=90}", "{Full=100}", "{Carré4=160}",
		 "{Yandee5=250}", "{Double brelan=360}", "{Carré et brelan=420}",
		 "{Double carré=480}", "{Triple brelan=540}",
		 "{Double Yandee=600, Full=500}", "{Grande suite=632}", "{Chance=13}"};

	/**
	 * Test method for {@link modele.Combo#Combo(int[])}.
	 */
	@Test
	void testCombo() {
		assertThrows(IllegalArgumentException.class,
				()-> new Combo(JEU_ERRONNE[0]));
		assertThrows(IllegalArgumentException.class,
				()-> new Combo(JEU_ERRONNE[1]));
		assertThrows(IllegalArgumentException.class,
				()-> new Combo(JEU_ERRONNE[2]));
		assertThrows(IllegalArgumentException.class,
				()-> new Combo(JEU_ERRONNE[3]));
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
	 * Test method for {@link modele.Combo#getPointsTotaux()}.
	 */
	@Test
	void testGetPointsTotaux() {
		assertEquals(SCORE_COMBO[0], new Combo(JEU_DE_TEST[0]).getPointsTotaux());
		assertEquals(SCORE_COMBO[1], new Combo(JEU_DE_TEST[1]).getPointsTotaux());
		assertEquals(SCORE_COMBO[2], new Combo(JEU_DE_TEST[2]).getPointsTotaux());
		assertEquals(SCORE_COMBO[3], new Combo(JEU_DE_TEST[3]).getPointsTotaux());
		assertEquals(SCORE_COMBO[4], new Combo(JEU_DE_TEST[4]).getPointsTotaux());
		assertEquals(SCORE_COMBO[5], new Combo(JEU_DE_TEST[5]).getPointsTotaux());
		assertEquals(SCORE_COMBO[6], new Combo(JEU_DE_TEST[6]).getPointsTotaux());
		assertEquals(SCORE_COMBO[7], new Combo(JEU_DE_TEST[7]).getPointsTotaux());
		assertEquals(SCORE_COMBO[8], new Combo(JEU_DE_TEST[8]).getPointsTotaux());
		assertEquals(SCORE_COMBO[9], new Combo(JEU_DE_TEST[9]).getPointsTotaux());
		assertEquals(SCORE_COMBO[10], new Combo(JEU_DE_TEST[10]).getPointsTotaux());
		assertEquals(SCORE_COMBO[11], new Combo(JEU_DE_TEST[11]).getPointsTotaux());
		assertEquals(SCORE_COMBO[12], new Combo(JEU_DE_TEST[12]).getPointsTotaux());
		assertEquals(SCORE_COMBO[13], new Combo(JEU_DE_TEST[13]).getPointsTotaux());
	}
	
	/**
	 * Test method for {@link modele.Combo#getPointsParAnnonce()}.
	 */
	@Test
	void testGetPointsParAnnonce() {
		assertEquals(SCORE_ANNONCE[0], new Combo(JEU_DE_TEST[0]).getPointsParAnnonce().toString());
		assertEquals(SCORE_ANNONCE[1], new Combo(JEU_DE_TEST[1]).getPointsParAnnonce().toString());
		assertEquals(SCORE_ANNONCE[2], new Combo(JEU_DE_TEST[2]).getPointsParAnnonce().toString());
		assertEquals(SCORE_ANNONCE[3], new Combo(JEU_DE_TEST[3]).getPointsParAnnonce().toString());
		assertEquals(SCORE_ANNONCE[4], new Combo(JEU_DE_TEST[4]).getPointsParAnnonce().toString());
		assertEquals(SCORE_ANNONCE[5], new Combo(JEU_DE_TEST[5]).getPointsParAnnonce().toString());
		assertEquals(SCORE_ANNONCE[6], new Combo(JEU_DE_TEST[6]).getPointsParAnnonce().toString());
		assertEquals(SCORE_ANNONCE[7], new Combo(JEU_DE_TEST[7]).getPointsParAnnonce().toString());
		assertEquals(SCORE_ANNONCE[8], new Combo(JEU_DE_TEST[8]).getPointsParAnnonce().toString());
		assertEquals(SCORE_ANNONCE[9], new Combo(JEU_DE_TEST[9]).getPointsParAnnonce().toString());
		assertEquals(SCORE_ANNONCE[10], new Combo(JEU_DE_TEST[10]).getPointsParAnnonce().toString());
		assertEquals(SCORE_ANNONCE[11], new Combo(JEU_DE_TEST[11]).getPointsParAnnonce().toString());
		assertEquals(SCORE_ANNONCE[12], new Combo(JEU_DE_TEST[12]).getPointsParAnnonce().toString());
		assertEquals(SCORE_ANNONCE[13], new Combo(JEU_DE_TEST[13]).getPointsParAnnonce().toString());
	}

}
