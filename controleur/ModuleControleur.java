/*
 * ModuleControleur.java                 13 nov. 2025
 * pas de copyright
 */
package controleur;

import java.util.Optional;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
	
	/**
	 * Affiche une boite de dialogue "Erreur"
	 * @param titre de la boite de dialogue
	 * @param message le message à affiché à l'utilisateur
	 */
	public static void erreur(String entete, String message) {
		Platform.runLater(() -> {
			Alert boiteAlerte = new Alert(Alert.AlertType.ERROR, entete);
			boiteAlerte.setTitle("Attention");
			boiteAlerte.setHeaderText(message);
			boiteAlerte.showAndWait();
		});
	}
	
	/**
	 * Affiche une boite de dialogue "Confirmation"
	 * @return le choix de l'utilisateur
	 */
	public static Optional<ButtonType> confirmation(String entete, String titre, String message) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION, entete);
        alert.setTitle(titre);
        alert.setHeaderText(message);
        alert.setContentText("Choisissez une option :");
        
        ButtonType buttonYes = new ButtonType("Oui");
        ButtonType buttonNo = new ButtonType("Non");
        
        alert.getButtonTypes().setAll(buttonYes, buttonNo);
        return alert.showAndWait();
	}
}
