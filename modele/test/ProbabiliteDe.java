/*
 * ProbabiliteDe.java                 24 août 2024
 * pas de copyright
 */
package modele.test;

import static java.lang.System.out;
import static java.lang.System.exit;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

import modele.ManchetteDe;

/**
 * Permet de vérifier si chaque face à la même chance de tomber
 * ( le dé est équilibré )
 * @author Adrien Vigué
 */
public class ProbabiliteDe {
	
	/** Le nombre maximal de tests pouvant être effectué */
	public static final int MAX_TEST = 100;
	
	/** La façon de renseigner les arguments */
	public static final String USAGE =
		"""
		Veuillez renseigner le nombre de tests à faire et de faces du dés
		Exemple :
		ProbabiliteDe.java <nombreDeTests> <nombreDeFaceDuDe>
		""";
	
	/** Message affiché si pas assez ou trop d'arguments */
	public static final String ERREUR_NOMBRE_ARGS =
		"""
		Vous n'avez pas rentré le bon nombre d'argument, vous devez en mettre 2
		""";
	
	/** Message affiché si il n'y a pas que des nombres dans les
	 * arguments
	 */
	public static final String ERREUR_TYPE_ARGS =
		"""
		Les arguments entrés doivent être sous forme numérique, ex : 1 2 3 4...
		""";
	
	/** Message affiché si trop de tests à effectuer */
	public static final String ERREUR_NOMBRE_TEST = 
		"Impossible de réaliser moins de 0 tests et plus de"
	    + MAX_TEST + "test";
	
	/**
	 * Lance un nombre de fois donné par l'utilisateur
	 * 10 dés au nombres de faces allant de 1 à 100
	 * @param args le nombre de tests demandés et nombre de faces du
	 *             dé
	 */
	public static void main(String[] args) {
		Scanner test;
		
		int nombreTest;
		int nombreFace;
		
		/* On vérifie qu'il y a bien 2 arguments, sinon, erreur */
		if (args.length != 2) {
			out.println(ERREUR_NOMBRE_ARGS);
			out.print(USAGE);
			exit(1);
		}
		
		/* On vérifie que les arguments sont du bon type, sinon, erreur */
		for (int i = 0; i < 2; i++) {
			test = new Scanner(args[i]);
			if (!test.hasNextInt()) {
				out.println(ERREUR_TYPE_ARGS);
				out.print(USAGE);
				exit(1);
			}
		}
		
		nombreTest = parseInt(args[0]);
		nombreFace = parseInt(args[1]);
		
		/* On vérifie que le nombre de test est valide, sinon, erreur */
		if (nombreTest  <= 0 || nombreTest > MAX_TEST) {
			out.println(ERREUR_NOMBRE_TEST);
			out.print(USAGE);
			exit(1);
		}
		
		/* On crée un tableau qui va compter le nombre d'apparition
		 * de chaques faces du dé
		 */
		int[][] nombreApparition = new int [nombreFace][2];
		int[] resultats = new int [10];
		
		for (int i = 0; i < nombreApparition.length; i++) {
			nombreApparition[i][0] = i+1;
			nombreApparition[i][1] = 0;
		}
		
		/* On note le nombre d'apparition de chaques façe */
		for (int compteur = 0; compteur < nombreTest; compteur++) {
			resultats = new ManchetteDe(10, nombreFace).getResultats();
			for (int i = 0; i < resultats.length; i++) {
				nombreApparition[resultats[i]-1][1]++;
			}
		}
		/* On converti en pourcentage d'apparition de chaques faces */
		for (int i = 0; i < nombreApparition.length; i++) {
			nombreApparition[i][1] = nombreApparition[i][1]*10/nombreTest;
		}
		
		/* On affiche le résultats du test */
		out.print("| ");
		for (int i = 0; i < nombreApparition.length; i++) {
			out.print(nombreApparition[i][0] + " " + nombreApparition[i][1] + "% | ");
		}
	}
}