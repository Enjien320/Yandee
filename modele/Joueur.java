/*
 * Pseudo.java                 27 sept. 2024
 * pas de copyright
 */
package modele;

/**
 * Sauvegarde les données relatives à un joueur lors de sa partie et
 * les enregistrent.
 * @author Adrien Vigué
 */
public class Joueur {
	
	/** Le pseudo par défaut attribué à un joueur */
	public static final String PSEUDO_DEFAUT = "Joueur";
	
	/** Le pseudo du joueur */
	private String pseudo;
	
	/** Le score atteint par le joueur durant la partie */
	private int score;

	/**
	 * Crée un joueur avec un pseudo définit et un score (par défaut
	 *                                                    à 0)
	 * @param nomJoueur le pseudo donné par le joueur si le pseudo
	 *        est vide ou nul, alors on lui met le pseudo par défaut
	 */
	public Joueur(String nomJoueur) {
		if (nomJoueur == null || nomJoueur.isBlank()) {
			pseudo = PSEUDO_DEFAUT;
		} else {
			pseudo = nomJoueur;
		}
		score = 0;
	}

	/**
	 * @return le pseudo du joueur
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param nomJoueur le nouveau pseudo du joueur
	 */
	public void setPseudo(String nomJoueur) {
		if (nomJoueur == null || nomJoueur.isBlank()) {
			pseudo = PSEUDO_DEFAUT;
		} else {
			pseudo = nomJoueur;
		}
	}

	/**
	 * @return le score du joueur
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param totalScore le score atteint par le joueur durant sa
	 *        partie
	 * @throws IllegalArgumentException levée si totalScore est < 0
	 */
	public void setScore(int totalScore) {
		if (totalScore<0) {
			throw new IllegalArgumentException("Le score ne peut pas être "
					                           + "négatif");
		}
		score = totalScore;
	}
}