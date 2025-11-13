/*
 * ManchetteDe.java                 23 août 2024
 * pas de copyright
 */
package modele;

/**
 * La manchette est l'objet utilisé pour lancer plusieurs dés d'un
 * coup. Cette classe permet donc de lancer un nombre donné de dés
 * avec un nombre de faces donné.
 * @author Adrien Vigué
 */
public class ManchetteDe {

	/** Nombre minimum de dés à lancer simultanément */
	public static final int DE_MIN = 1;
	
	/** Nombre maximum de dés à lancer simultanément */
	public static final int DE_MAX = 10;
	
	private int[] resultats;
	
	private int nombreDe;
	
	/**
	 * Récupère un nombre de dés donnés et un nombre de faces donnés
	 * pour les lancer puis enregesitre le résultat de chacun des
	 * lancés effectués.
	 * @param nombreDe Le nombre de dés à lancer
	 * @param nombreFace Le nombre de face des dés
	 * @throws IllegalArgumentException si le nombre de dés n'est pas
	 *         entier ou non compris entre 1 et 10 
	 *         si le nombre de faces n'est pas entier ou est 
	 *         inférieur à 2 ou supérieur à 100
	 */
	public ManchetteDe(int nombreDe, int nombreFace) {
		if (nombreDe < DE_MIN || nombreDe > DE_MAX) {
			throw new IllegalArgumentException("Le nombre de dés est invalide, "
					                           + "il doit être entier et"
					                           + " compris entre " + DE_MIN + 
					                           " et " + DE_MAX + ".");
		}
		this.nombreDe = nombreDe;
		this.resultats = new int [nombreDe];
		for (int i = 0; i < nombreDe; i++) {
			resultats[i] = new De(nombreFace).lancementDe();
		}
	}

	/**
	 * @return le resultat de chaques dés dans la manchette
	 */
	public int[] getResultats() {
		return resultats;
	}

	/**
	 * @return le nombre de dés dans la manchette
	 */
	public int getNombreDe() {
		return nombreDe;
	}
}