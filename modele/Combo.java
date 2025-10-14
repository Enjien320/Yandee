/**
 * Combo.java                 28 août 2024
 * pas de copyright
 */
package modele;

/**
 * Défini les différents combos et montants de points donnés par un
 * lancé de dés du joueur.
 * @author Adrien Vigué
 */
public class Combo {

	private String annonces;
	
	private int points;
	private int tailleSuite;
	
	/* vrai si tout chiffres du tirage est présent 2 fois minimum */
	private boolean full = true;
	private boolean pair = true;
	private boolean impair = true;

	/**
	 * Classe les résultats du tirage puis détermine le ou les combo
	 * obtenu avec le lancé de dé puis calcul le nombre de points
	 * associés.
	 * @param tirage les resultats du tirage
	 * @throws IllegalArgumentException si tirage.length > 10
	 */
	public Combo(int[] tirage) {
		if (tirage.length > 10) {
			throw new IllegalArgumentException("Le nombre maximum de dé pour"
					                           + " un combo est de 10 dés");
		}
		
		// index pour naviguer dans les tableaux
		int i;
		int j;
		
		// variable pour l'algorythme de tri
		int[] tampon;
		
		// tableau utilisé pour définir les points et les combos
		int[][] classementDe = new int [tirage.length][2];
		
		/** 
		 * on défini le nombre d'appartion de chaques nombres du 
		 * tirage et on les range dans l'ordre de leurs première 
		 * apparition
		 */		
		for (i=0; i < classementDe.length; i++) {
			if (classementDe[0][0] == 0) {
				classementDe[0][0] = tirage[i];
				classementDe[0][1] = 1;
			} else if (classementDe[0][0] == tirage[i]) {
				classementDe[0][1]++;
			}
			for (j=1; j < classementDe.length
					  && classementDe[j-1][0] != tirage[i]; j++) {
				if (classementDe[j][0] == 0) {
					classementDe[j][0] = tirage[i];
					classementDe[j][1] = 1;
				} else if (classementDe[j][0] == tirage[i]) {
					classementDe[j][1]++;
				}
			}
		}
		
		/* on trie le tableau dans l'ordre décroissant des faces 
		 * obtenues
		 */
		for (i=0; i < classementDe.length; i++) {
			for (j=i; j < classementDe.length; j++) {
				if (classementDe[i][0] < classementDe[j][0]) {
					tampon = classementDe[i];
					classementDe[i] = classementDe[j];
					classementDe[j] = tampon;
				}
			}
		}
		
		/* on défini les combos obtenu */
		annonces = "[ ";
		points = 0;
		
		for (i=0; i<classementDe.length && classementDe[i][0] != 0; i++) {
			if (classementDe[i][1] == 3) {
				annonces += "brelan de " + classementDe[i][0]  + " | ";
				points += 30*classementDe[i][0];
			}
			if (classementDe[i][1] == 4) {
				annonces += "carré de " + classementDe[i][0]  + " | ";
				points += 40*classementDe[i][0];
			}
			if (classementDe[i][1] == 5) {
				annonces += "Yandee de " + classementDe[i][0]  + " | ";
				points += 50*classementDe[i][0];
			}
			if (classementDe[i][1] == 6) {
				annonces += "double brelan de " + classementDe[i][0]  + " | ";
				points += 2*30*classementDe[i][0];
			}
			if (classementDe[i][1] == 7) {
				annonces += "carré et brelan de " + classementDe[i][0]  + " | ";
				points += (40+30)*classementDe[i][0];
			}
			if (classementDe[i][1] == 8) {
				annonces += "double carré de " + classementDe[i][0]  + " | ";
				points += 2*40*classementDe[i][0];
			}
			if (classementDe[i][1] == 9) {
				annonces += "Triple brelan de " + classementDe[i][0] + " | ";
				points += (50+40)*classementDe[i][0];
			}
			if (classementDe[i][1] == 10) {
				annonces += "double Yandee de " + classementDe[i][0]  + " | ";
				points += 2*50*classementDe[i][0];
			}
			tailleSuite = 0;
			/* vérifie que le nombre à analyser n'est pas dans une suite */
			if (i == 0 || classementDe[i-1][0]-1 != classementDe[i][0]) {
				for (j=0; j<classementDe.length;j++) {
					if (i+j < classementDe.length
						&& classementDe[i][0] == classementDe[i+j][0]+j
						&&classementDe[i+j][0] != 0) {
						tailleSuite++;
					}
				}
				if (tailleSuite == 10) {
					/* suite parfaite si 10 chiffres se suivent */
					annonces += "suite parfaite de " + classementDe[i+9][0]  
							+ " à " + classementDe[i][0] + " | ";
					points += 700;
				} else if (tailleSuite >= 8) {
					/* grande suite [8, 10[ chiffre */
					annonces += "grande suite de " + classementDe[i+7][0]  
							+ " à " + classementDe[i][0] + " | ";
					points += 500;
				} else if (tailleSuite >= 5) {
					/* suite classique [5, 8[ chiffres */
					annonces += "suite de " + classementDe[i+4][0]  
							+ " à " + classementDe[i][0] + " | ";
					points += 350;
				} else if (tailleSuite >= 3) {
					/* petite suite [3, 5[ chiffres */
					annonces += "petite suite de " + classementDe[i+2][0]  
							+ " à " + classementDe[i][0] + " | ";
					points += 200;
				}
				
			}
			full &= classementDe[i][1] >= 2;
			pair &= classementDe[i][0]%2 == 0;
			impair &= classementDe[i][0]%2 == 1;
		}
		if (full) {
			annonces += "full | ";
			points += tirage.length*10*i;
		}
		if (annonces == "[ ") {
			annonces += "chance | ";
			for (i=0; i<classementDe.length; i++) {
				points += classementDe[i][0]*classementDe[i][1];
			}
		}
		if (pair || impair) {
			annonces += pair ? "pair ]" : "impair ]";
			points *= 2;
		} else {
			annonces += "]";
		}
	}

	/**
	 * @return the annonce
	 */
	public String getAnnonces() {
		return annonces;
	}

	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}
	
	
}