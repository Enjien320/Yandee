/**
 * De.java                 23 août 2024
 * iut de Rodez, pas de copyright
 */
package modele;

/**
 * Permet à l'utilisateur de lancer un dé pour obtenir un résultat
 * aléatoire grace à un nombre donné de faces
 * @author Adrien Vigué
 */
public class De {

	/** Nombre minimum de faces du dé */
	public static final int MIN_FACES = 2;
	
	/** Nombre maximum de faces du dé */
	public static final int MAX_FACES = 100;
	
	private int nombreFace;
	private int ResultatDe;

	/**
	 * Décrire la fonction du constructeur
	 * @param nombreFaceDe le nombre de faces du dé à créer
	 * @throws IllegalArgumentException si le nombre de faces n'est
	 *         pas entier ou est inférieur à MINFACES ou supérieur 
	 *         à MAXFACES
	 */
	public De(int nombreFaceDe) {
		if (nombreFaceDe < MIN_FACES || nombreFaceDe > MAX_FACES) {
			throw new IllegalArgumentException("Le nombre de faces est "
					                           + "invalide, il doit être "
					                           + "entier et compris entre " 
					                           + MIN_FACES + " et " + MAX_FACES
					                           + ".");
		}
		this.nombreFace = nombreFaceDe;
	}

	/**
	 * Pour définir sur quel nombre on tombe, on divise 1 par le 
	 * nombre de faces du dé, on génère ensuite un chiffre aléatoire
	 * puis on obtient le résultat en ajoutant le premier nombre a 0
	 * jusqu'à obtenir un nombre supérieur au chiffre généré
	 * aléatoirement  
	 * @return le résultat obtenu par le lancé
	 */
	public int lancementDe() {
		double zoneResultat;
		double resultat;
		
		this.ResultatDe = 0;
		zoneResultat = 0.0;
		resultat = Math.random();
		do {
			ResultatDe++;
			zoneResultat += 1.0/(double)getNombreFace();
		} while (zoneResultat < resultat);
		
		return ResultatDe;
	}

	/**
	 * @return le résultat donné par le dé
	 */
	public int getResultatDe() {
		return ResultatDe;
	}
	
	/**
	 * @return le nombre de faces du dé
	 */
	public int getNombreFace() {
		return nombreFace;
	}

}