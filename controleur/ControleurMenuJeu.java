/**
 * ControleurMenuJeu.java                 23 sept. 2024
 * iut de Rodez, pas de copyright
 */
package controleur;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import vue.Main;

/**
 * Décrire l'utilitée de la classe
 * @author Adrien Vigué
 */
public class ControleurMenuJeu {
	
	@FXML
	private TextField pseudo;
	
	/** Enregistre le pseudo et lance la partie */
	@FXML
	public void jouer() {
		String pseudoDonne;
		
		pseudoDonne = pseudo.getText();
		Main.activerJeu();
	}
	
	/**
	 * Permet de retourner au menu de l'application.
	 */
	@FXML
	private void retour() {
		Main.activerMenu();
	}
}
