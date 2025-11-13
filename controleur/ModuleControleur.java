/*
 * ModuleControleur.java                 13 nov. 2025
 * pas de copyright
 */
package controleur;

import vue.Main;

/**
 * Rassemble les fonctions utilies à tout les controleurs
 * @author Adrien Vigué
 */
public class ModuleControleur {

	/* Instance de main */
	private static Main main;

	/**
	 * @return le/la main
	 */
	public static Main getMain() {
		if (main == null) {
			main = new Main();
		}
		return main;
	}
}
