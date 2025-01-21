/**
 * ControleurMenuJeu.java                 23 sept. 2024
 * pas de copyright
 */
package controleur;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import modele.Joueur;
import vue.Main;

/**
 * Décrire l'utilitée de la classe
 * @author Adrien Vigué
 */
public class ControleurMenuJeu {
	
	/** Le TextField grace auquel l'utilisateur entre son pseudo */
	@FXML
	private TextField pseudo;
	
	/** Enregistre le pseudo et lance la partie */
	@FXML
	public void jouer() {
		String pseudoDonne;
		
		pseudoDonne = pseudo.getText();
		/* on crée un nouveau profil pour l'utilisateur */
		Main.profilJoueur = new Joueur(pseudoDonne);
		
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
