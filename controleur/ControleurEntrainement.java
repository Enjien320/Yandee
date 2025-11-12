/*
 * ControleurEntrainement.java                 25 août 2024
 * pas de copyright
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
	
	/** champ de saisie du nombre de dés */
	@FXML
	private TextField nombreDes;
	
	/** champ de saisie du nombre de faces */
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

		/* On vérifie que le nombre de dé soit bien un nombre */
		analyseur = new Scanner(nombreDes.getText());
		if (!analyseur.hasNextInt()) {
			boiteAlerte = new Alert(Alert.AlertType.ERROR,
					"Veuillez rentrer un nombre de dés entier.");
			boiteAlerte.setTitle("Erreur de Frappe");
			boiteAlerte.setHeaderText("Attention");
			boiteAlerte.showAndWait();
		} else {
			/* On vérifie que le nombre de face soit bien un nombre */
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
				/* On récupère le nombre de face du dés */
				faceDuDes = analyseur.nextInt();
				try {
					resultat = new ManchetteDe(desALancer, faceDuDes)
							                   .getResultats();
					/* On récupère le nombre de dé */
					// FIXME simplifier et raccourcir
					compteur = 0;
					resultatDe = Integer.toString(resultat[compteur]);
					/* on associe une valeur au dé */
					de1.setText(resultatDe);
					compteur++;
					/* S'il est utilisé, on associe une valeur au dé */
					if (compteur <= desALancer) {
						resultatDe = Integer.toString(resultat[compteur]);
						de2.setText(resultatDe);
						compteur++;
					}
					if (compteur <= desALancer) {
						resultatDe = Integer.toString(resultat[compteur]);
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
						resultatDe = Integer.toString(resultat[compteur]);
						de5.setText(resultatDe);
						compteur++;
					}
					if (compteur <= desALancer) {
						resultatDe = Integer.toString(resultat[compteur]);
						de6.setText(resultatDe);
						compteur++;
					}
					if (compteur <= desALancer) {
						resultatDe = Integer.toString(resultat[compteur]);
						de7.setText(resultatDe);
						compteur++;
					}
					if (compteur <= desALancer) {
						resultatDe = Integer.toString(resultat[compteur]);
						de8.setText(resultatDe);
						compteur++;
					}
					if (compteur <= desALancer) {
						resultatDe = Integer.toString(resultat[compteur]);
						de9.setText(resultatDe);
						compteur++;
					}
					if (compteur <= desALancer) {
						resultatDe = Integer.toString(resultat[compteur]);
						de10.setText(resultatDe);
						compteur++;
					}				
				} catch (IllegalArgumentException e) {
					/* s'il y a trop de dés ou de faces du dé,
					 * on renvoi une erreur
					 */
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
