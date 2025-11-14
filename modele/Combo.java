/*
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

	/** Points obtenus grâce à une suite parfaite */
	public static final int PTS_SSUITE = 800;
	
	/** Points obtenus grâce à une grande suite */
	public static final int PTS_GSUITE = 400;
	
	/** Points obtenus grâce à une suite */
	public static final int PTS_SUITE = 200;
	
	/** Points obtenus grâce à une petite suite */
	public static final int PTS_PSUITE = 100;
	
	/* Les différentes annonces obtenues par le joueur */
	private String annonces;
	
	/* points obtenus grace aux diférentes annonces */
	private int points;

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
		
		// Définit la taille d'une suite
		int tailleSuite;
		
		// index pour naviguer dans les tableaux
		int i;
		int j;
		
		// variable pour l'algorythme de tri
		int[] tampon;
		
		// tableau utilisé pour définir les points et les combos
		int[][] classementDe = new int [tirage.length][2];
		
		// vrai si tout chiffres du tirage est présent 2 fois minimum 
		boolean full = true;
		boolean pair = true;
		boolean impair = true;
		
		/*
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
		
		/* 
		 * on trie le tableau dans l'ordre décroissant des faces 
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
		
		/* On regarde les annonces obtenus dans le tirage */
		for (i=0; i<classementDe.length && classementDe[i][0] != 0; i++) {
			switch(classementDe[i][1]) {
				case 3:
					annonces += "brelan de " + classementDe[i][0]  + " | ";
					points += 30*classementDe[i][0];
					break;
				case 4:
					annonces += "carré de " + classementDe[i][0]  + " | ";
					points += 40*classementDe[i][0];
					break;
				case 5:
					annonces += "Yandee de " + classementDe[i][0]  + " | ";
					points += 50*classementDe[i][0];
					break;
				case 6:
					annonces += "double brelan de " + classementDe[i][0]  + " | ";
					points += 2*30*classementDe[i][0];
					break;
				case 7:
					annonces += "carré et brelan de " + classementDe[i][0]  + " | ";
					points += (40+30)*classementDe[i][0];
					break;
				case 8:
					annonces += "double carré de " + classementDe[i][0]  + " | ";
					points += 2*40*classementDe[i][0];
					break;
				case 9:
					annonces += "Triple brelan de " + classementDe[i][0] + " | ";
					points += 30*3*classementDe[i][0];
					break;
				case 10:
					annonces += "double Yandee de " + classementDe[i][0]  + " | ";
					points += 2*50*classementDe[i][0];
					break;
			}
			tailleSuite = 0;
			/* vérifie que le nombre à analyser n'est pas dans une suite */
			if (i == 0 || classementDe[i-1][0]-1 != classementDe[i][0]) {
				for (j=0; j<classementDe.length;j++) {
					if (i+j < classementDe.length
						&& classementDe[i][0] == classementDe[i+j][0]+j
						&& classementDe[i+j][0] != 0) {
						tailleSuite++;
					}
				}
				if (tailleSuite == 10) {
					/* suite parfaite si 10 chiffres se suivent */
					annonces += "suite parfaite de " + classementDe[i+9][0]  
							+ " à " + classementDe[i][0] + " | ";
					points += PTS_SSUITE;
				} else if (tailleSuite >= 8) {
					/* grande suite [8, 10[ chiffre */
					annonces += "grande suite de " + classementDe[i+7][0]  
							+ " à " + classementDe[i][0] + " | ";
					points += PTS_GSUITE;
				} else if (tailleSuite >= 5) {
					/* suite classique [5, 8[ chiffres */
					annonces += "suite de " + classementDe[i+4][0]  
							+ " à " + classementDe[i][0] + " | ";
					points += PTS_SUITE;
				} else if (tailleSuite >= 3) {
					/* petite suite [3, 5[ chiffres */
					annonces += "petite suite de " + classementDe[i+2][0]  
							+ " à " + classementDe[i][0] + " | ";
					points += PTS_PSUITE;
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
	 * @return les annonces
	 */
	public String getAnnonces() {
		return annonces;
	}

	/**
	 * @return les points
	 */
	public int getPoints() {
		return points;
	}
	
	
}