/**
 * controleurMenu.java                 24 août 2024
 * pas de copyright
 */
package controleur;

import javafx.fxml.FXML;
import vue.Main;

/**
 * Controle les bouttons du menu principal
 * @author Adrien Vigué
 */
public class ControleurMenu {
	
	/**
	 * Permet de passer à la page fxml de jeu
	 */
	@FXML
	private void jeu() {
		Main.activerMenuJeu();
	}
	
	/**
	 * Permet de passer à la page FXML de l'entrainement
	 */
	@FXML
	private void lancerDes() {
		Main.activerEntrainement();
	}
}
