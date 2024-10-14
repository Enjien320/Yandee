/**
 * controleurJeu.java                 28 août 2024
 * iut de Rodez, pas de copyright
 */
package controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import vue.Main;

/**
 * Controleur de la fenêtre du jeu
 * @author Adrien Vigué
 */
public class ControleurJeu {	
	
	/** L'endroit où est affiché le pseudo du joueur */
	@FXML
	private Label pseudo;
	
	/** L'endroit où est affiché le résultat du premier dé */
	@FXML
	private Label de1;
	
	/** L'endroit où est affiché le résultat du second dé */
	@FXML
	private Label de2;
	
	/** L'endroit où est affiché le résultat du troisième dé */
	@FXML
	private Label de3;
	
	/** L'endroit où est affiché le résultat du quatrième dé */
	@FXML
	private Label de4;
	
	/** L'endroit où est affiché le résultat du cinquième dé */
	@FXML
	private Label de5;
	
	/**
	 * Permet de passer à la page fxml du menu
	 */
	@FXML
	private void retour() {
		Main.activerMenu();
	}
}
