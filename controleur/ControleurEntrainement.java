/**
 * ControleurEntrainement.java                 25 août 2024
 * iut de Rodez, pas de copyright
 */
package controleur;


import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modele.ManchetteDe;
import vue.Main;

/**
 * Controle le fonctionnement de la page d'entrainement
 * @author Adrien Vigué
 */
public class ControleurEntrainement {

	

	/** Boite ouverte s'il y a une erreur */
	@FXML
	private Alert boiteAlerte;
	
	/** champ de saisie de la chaîne de caractères à analyser */
	@FXML
	private TextField nombreDes;
	
	/** champ de saisie de la chaîne de caractères à analyser */
	@FXML
	private TextField nombreFaces;
	
	/** Le premier dé */
	@FXML
	private Label de1;
	
	/** Le deuxième dé */
	@FXML
	private Label de2;
	
	/** Le troisième dé */
	@FXML
	private Label de3;
	
	/** Le quatrième dé*/
	@FXML
	private Label de4;
	
	/** Le cinquième dé */
	@FXML
	private Label de5;
	
	/** Le sixième dé */
	@FXML
	private Label de6;
	
	/** Le septième dé */
	@FXML
	private Label de7;
	
	/** Le huitième dé */
	@FXML
	private Label de8;
	
	/** Le neuvième dé */
	@FXML
	private Label de9;
	
	/** le dixième dé */
	@FXML
	private Label de10;
	
	/**
	 * Permet de controler le lancement des dés et d'afficher le 
	 * résultat à partir du nombre de dés et de face donnés par
	 * l'utilisateur.
	 */
	@FXML
	private void lancerDes() {

		String resultatDe;
		int desALancer;
		int faceDuDes;
		int compteur;

		int[] resultat;

		Scanner analyseur;

		analyseur = new Scanner(nombreDes.getText());
		if (!analyseur.hasNextInt()) {
			boiteAlerte = new Alert(Alert.AlertType.ERROR,
					"Veuillez rentrer un nombre de dés entier.");
			boiteAlerte.setTitle("Erreur de Frappe");
			boiteAlerte.setHeaderText("Attention");
			boiteAlerte.showAndWait();
		} else {
			desALancer = analyseur.nextInt();
			analyseur = new Scanner(nombreFaces.getText());
			if (!analyseur.hasNextInt()) {
				boiteAlerte = new Alert(Alert.AlertType.ERROR,
						"Veuillez rentrer un nombre de faces"
								+ " entier.");
				boiteAlerte.setTitle("Erreur de Frappe");
				boiteAlerte.setHeaderText("Attention");
				boiteAlerte.showAndWait();
			} else {
				// FIXME simplifier et raccourcir
				faceDuDes = analyseur.nextInt();
				de1.setText("");
				de2.setText("");
				de3.setText("");
				de4.setText("");
				de5.setText("");
				de6.setText("");
				de7.setText("");
				de8.setText("");
				de9.setText("");
				de10.setText("");
			try {
				resultat = new ManchetteDe(desALancer, faceDuDes)
						.getResultats();
				
				/** compte le nombre de dés utilisés */
				compteur = 0;
				resultatDe = "";
				resultatDe += resultat[compteur];
				de1.setText(resultatDe);
				compteur++;
				if (compteur <= desALancer) {
					resultatDe = "";
					resultatDe += resultat[compteur];
					de2.setText(resultatDe);
					compteur++;
				}
				if (compteur <= desALancer) {
					resultatDe = "";
					resultatDe += resultat[compteur];
					de3.setText(resultatDe);
					compteur++;
				}
				if (compteur <= desALancer) {
					resultatDe = "";
					resultatDe += resultat[compteur];
					de4.setText(resultatDe);
					compteur++;
				}
				if (compteur <= desALancer) {
					resultatDe = "";
					resultatDe += resultat[compteur];
					de5.setText(resultatDe);
					compteur++;
				}
				if (compteur <= desALancer) {
					resultatDe = "";
					resultatDe += resultat[compteur];
					de6.setText(resultatDe);
					compteur++;
				}
				if (compteur <= desALancer) {
					resultatDe = "";
					resultatDe += resultat[compteur];
					de7.setText(resultatDe);
					compteur++;
				}
				if (compteur <= desALancer) {
					resultatDe = "";
					resultatDe += resultat[compteur];
					de8.setText(resultatDe);
					compteur++;
				}
				if (compteur <= desALancer) {
					resultatDe = "";
					resultatDe += resultat[compteur];
					de9.setText(resultatDe);
					compteur++;
				}
				if (compteur <= desALancer) {
					resultatDe = "";
					resultatDe += resultat[compteur];
					de10.setText(resultatDe);
					compteur++;
				}				
			} catch (IllegalArgumentException e) {
				boiteAlerte = new Alert(Alert.AlertType.ERROR,
						e.getMessage());
				boiteAlerte.setTitle("Erreur de Frappe");
				boiteAlerte.setHeaderText("Attention");
				boiteAlerte.showAndWait();
			}
		}
		}
	}
	
	/**
	 * Permet de retourner au menu de l'application.
	 */
	@FXML
	private void retour() {
		Main.activerMenu();
	}
}
