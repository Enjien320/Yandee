/**
 * controleurJeu.java                 28 août 2024
 * iut de Rodez, pas de copyright
 */
package controleur;

import javafx.fxml.FXML;
import vue.Main;

/**
 * Controleur de la fenêtre du jeu
 * @author Adrien Vigué
 */
public class ControleurJeu {
	
	/**
	 * Permet de passer à la page fxml du menu
	 */
	@FXML
	private void retour() {
		Main.activerMenu();
	}
}
