/**
 * ControleurVictoire.java                 3 nov. 2025
 * pas de copyright
 */
package controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import vue.Main;

/**
 * Controle les boutons de l'ecran de victoire
 * @author Adrien Vigué
 */
public class ControleurVictoire {
	
	/** affiche le texte de felicitation */
	@FXML
	private Label texte;
	
	/** affiche le score obtenu */
	@FXML
	private Label score;
	
	/**
	 * Permet d'afficher le texte de victoire
	 */
	@FXML
	public void initialize() {
		texte.setText("Félicitation "+ Main.profilJoueur.getPseudo() 
		              + ", vous avez gagné !");
		score.setText("Score : " + Main.profilJoueur.getScore());
	}
	
	/**
	 * Permet de passer à la page fxml du menu
	 */
	@FXML
	private void retour() {
		Main.activerMenu();
	}
}