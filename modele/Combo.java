/*
 * Combo.java                 28 août 2024
 * pas de copyright
 */
package modele;

import java.util.HashMap;

/**
 * Défini les différents combos et montants de points donnés par un
 * lancé de dés du joueur.
 * @author Adrien Vigué
 */
public class Combo {
	
	/* Les différentes annonces obtenues par le joueur */
	private String annonces;
	
	/* points obtenus grace aux diférentes annonces */
	private int pointsTotaux;
	
	/* points obtenus à chaques annonces */
	private HashMap<String, Integer> pointsParAnnonce = new HashMap<>();

	/**
	 * Classe les résultats du tirage puis détermine le ou les combo
	 * obtenu avec le lancé de dé puis calcul le nombre de points
	 * associés.
	 * @param tirage les resultats du tirage
	 * @throws IllegalArgumentException si tirage.length null ou > 10
	 */
	public Combo(int[] tirage) {
		if (tirage == null || tirage.length == 0) {
			throw new IllegalArgumentException("Le nombre de dé doit être <0");
		}
		if (tirage.length > 10) {
			throw new IllegalArgumentException("Le nombre maximum de dé pour"
					                           + " un combo est de 10 dés");
		}
		
		// points obtenu dans par une annonce
		int pointsAnnonce;
		
		// Définit la taille d'une suite
		int tailleSuite;
		
		// index pour naviguer dans les tableaux
		int i;
		int j;
		
		// tableau utilisé pour définir les points et les combos
		int[][] classementDe;
		
		// vrai si tout chiffres du tirage est présent 2 fois minimum 
		boolean full = true;
		
		boolean pair = true;
		boolean impair = true;
		
		classementDe = creationTableauClassement(tirage);
		
		/* on défini les combos obtenu */
		annonces = "[ ";
		pointsTotaux = 0;
		
		/* On regarde les annonces obtenus dans le tirage */
		for (i=0; i<classementDe.length && classementDe[i][0] != 0; i++) {
			switch(classementDe[i][1]) {
				case 3:
					annonces += "Brelan de " + classementDe[i][0]  + " | ";
					pointsAnnonce = 30*classementDe[i][0];
					pointsTotaux += pointsAnnonce;
					pointsParAnnonce.put("Brelan"+classementDe[i][0],
										 pointsAnnonce);
					break;
				case 4:
					annonces += "Carré de " + classementDe[i][0]  + " | ";
					pointsAnnonce = 40*classementDe[i][0];
					pointsTotaux += pointsAnnonce;
					pointsParAnnonce.put("Carré"+classementDe[i][0],
										 pointsAnnonce);
					break;
				case 5:
					annonces += "Yandee de " + classementDe[i][0]  + " | ";
					pointsAnnonce = 50*classementDe[i][0];
					pointsTotaux += pointsAnnonce;
					pointsParAnnonce.put("Yandee"+classementDe[i][0],
										 pointsAnnonce);
					break;
				case 6:
					annonces += "Double brelan de " + classementDe[i][0]  + " | ";
					pointsAnnonce = 2*30*classementDe[i][0];
					pointsTotaux += pointsAnnonce;
					pointsParAnnonce.put("Double brelan", pointsAnnonce);
					break;
				case 7:
					annonces += "Carré et brelan de " + classementDe[i][0]  + " | ";
					pointsAnnonce = (40+30)*classementDe[i][0];
					pointsTotaux += pointsAnnonce;
					pointsParAnnonce.put("Carré et brelan", pointsAnnonce);
					break;
				case 8:
					annonces += "Double carré de " + classementDe[i][0]  + " | ";
					pointsAnnonce = 2*40*classementDe[i][0];
					pointsTotaux += pointsAnnonce;
					pointsParAnnonce.put("Double carré", pointsAnnonce);
					break;
				case 9:
					annonces += "Triple brelan de " + classementDe[i][0] + " | ";
					pointsAnnonce = 30*3*classementDe[i][0];
					pointsTotaux += pointsAnnonce;
					pointsParAnnonce.put("Triple brelan", pointsAnnonce);
					break;
				case 10:
					annonces += "Double Yandee de " + classementDe[i][0]  + " | ";
					pointsAnnonce = 2*50*classementDe[i][0];
					pointsTotaux += pointsAnnonce;
					pointsParAnnonce.put("Double Yandee", pointsAnnonce);
					break;
			}
			tailleSuite = 0;
			/* vérifie que le nombre à analyser n'est pas dans une suite */
			if (i == 0 || classementDe[i-1][0]-1 != classementDe[i][0]) {
				/* Définit si le nombre est le début d'une nouvelle suite */
				for (j=0; j<classementDe.length;j++) {
					if (i+j < classementDe.length
						&& classementDe[i][0] == classementDe[i+j][0]+j
						&& classementDe[i+j][0] != 0) {
						tailleSuite++;
					}
				}
				if (tailleSuite == 10) {
					/* suite parfaite si 10 chiffres se suivent */
					annonces += "Suite parfaite de " + classementDe[i+9][0]  
							+ " à " + classementDe[i][0] + " | ";
					pointsAnnonce = 800+(classementDe[i][0]*tailleSuite);
					pointsTotaux += pointsAnnonce;
					pointsParAnnonce.put("Suite parfaite",pointsAnnonce);
				} else if (tailleSuite >= 8) {
					/* grande suite [8, 10[ chiffre */
					annonces += "Grande suite de " + classementDe[i+7][0]  
							+ " à " + classementDe[i][0] + " | ";
					pointsAnnonce = 400+(classementDe[i][0]*tailleSuite);
					pointsTotaux += pointsAnnonce;
					pointsParAnnonce.put("Grande suite",pointsAnnonce);
				} else if (tailleSuite >= 5) {
					/* suite classique [5, 8[ chiffres */
					annonces += "Suite de " + classementDe[i+4][0]  
							+ " à " + classementDe[i][0] + " | ";
					pointsAnnonce = 200+(classementDe[i][0]*tailleSuite);
					pointsTotaux += pointsAnnonce;
					pointsParAnnonce.put("Suite"+classementDe[i][0],
				 			 			 pointsAnnonce);
				} else if (tailleSuite >= 3) {
					/* petite suite [3, 5[ chiffres */
					annonces += "Petite suite de " + classementDe[i+2][0]  
							+ " à " + classementDe[i][0] + " | ";
					pointsAnnonce = 100+(classementDe[i][0]*tailleSuite);
					pointsTotaux += pointsAnnonce;
					pointsParAnnonce.put("Petite suite"+classementDe[i][0],
				 			 			 pointsAnnonce);
				}
			}
			full &= classementDe[i][1] >= 2;
			pair &= classementDe[i][0]%2 == 0;
			impair &= classementDe[i][0]%2 == 1;
		}
		if (full) {
			annonces += "Full | ";
			pointsAnnonce = tirage.length*50*i;
			pointsTotaux += pointsAnnonce;
			pointsParAnnonce.put("Full",
		 			 			 pointsAnnonce);
		}
		if (annonces == "[ ") {
			annonces += "Chance | ";
			pointsAnnonce = 0;
			for (i=0; i<classementDe.length; i++) {
				pointsAnnonce += classementDe[i][0]*classementDe[i][1];
			}
			pointsTotaux += pointsAnnonce;
			pointsParAnnonce.put("Chance",
		 			 			 pointsAnnonce);
		}
		if (pair || impair) {
			annonces += pair ? "Pair ]" : "Impair ]";
			pointsTotaux *= 2;
		} else {
			annonces += "]";
		}
	}
	
	/**
	 * Créer un tableau permettant de classer les différentes faces
	 * obtenues par ordre décroissant avec leurs nombre d'apparition
	 * sur le tirage
	 * @param tirage les résultats du tirage
	 * @return le tableau trié avec le nombre d'apparition de chaques
	 * 		   faces
	 */
	private int[][] creationTableauClassement(int[] tirage) {
		
		// variable pour l'algorythme de tri
		int[] tampon;
		
		int[][] aRenvoyer = new int[tirage.length][2];
		
		/*
		 * on défini le nombre d'appartion de chaques nombres du 
		 * tirage et on les range dans l'ordre de leurs première 
		 * apparition
		 */		
		for (int i=0; i < aRenvoyer.length; i++) {
			if (aRenvoyer[0][0] == 0) {
				aRenvoyer[0][0] = tirage[i];
				aRenvoyer[0][1] = 1;
			} else if (aRenvoyer[0][0] == tirage[i]) {
				aRenvoyer[0][1]++;
			}
			for (int j=1; j < aRenvoyer.length
					  && aRenvoyer[j-1][0] != tirage[i]; j++) {
				if (aRenvoyer[j][0] == 0) {
					aRenvoyer[j][0] = tirage[i];
					aRenvoyer[j][1] = 1;
				} else if (aRenvoyer[j][0] == tirage[i]) {
					aRenvoyer[j][1]++;
				}
			}
		}
		
		/* 
		 * on trie le tableau dans l'ordre décroissant des faces 
		 * obtenues
		 */
		for (int i=0; i < aRenvoyer.length; i++) {
			for (int j=i; j < aRenvoyer.length; j++) {
				if (aRenvoyer[i][0] < aRenvoyer[j][0]) {
					tampon = aRenvoyer[i];
					aRenvoyer[i] = aRenvoyer[j];
					aRenvoyer[j] = tampon;
				}
			}
		}
		return aRenvoyer;
	}

	/**
	 * @return les annonces
	 */
	public String getAnnonces() {
		return annonces;
	}

	/**
	 * @return les points totaux
	 */
	public int getPointsTotaux() {
		return pointsTotaux;
	}

	/**
	 * @return le nombre de points pour chaque annonce pointsParAnnonce
	 */
	public HashMap<String, Integer> getPointsParAnnonce() {
		return pointsParAnnonce;
	}
	
}