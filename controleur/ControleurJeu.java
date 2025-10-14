/**
 * ControleurJeu.java                 28 août 2024
 * pas de copyright
 */
package controleur;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.paint.Paint;
import modele.Combo;
import modele.Joueur;
import modele.ManchetteDe;
import vue.Main;

/**
 * Controleur de la fenêtre du jeu
 * @author Adrien Vigué
 */
public class ControleurJeu {	
	
	/** L'endroit où est affiché le résultat du premier dé */
	@FXML
	private Button de1;
	
	/** L'endroit où est affiché le résultat du second dé */
	@FXML
	private Button de2;
	
	/** L'endroit où est affiché le résultat du troisième dé */
	@FXML
	private Button de3;
	
	/** L'endroit où est affiché le résultat du quatrième dé */
	@FXML
	private Button de4;
	
	/** L'endroit où est affiché le résultat du cinquième dé */
	@FXML
	private Button de5;
	
	/** La case permettant de valider un Yandee */
	@FXML
	private CheckBox yandee;
	
	/** La case permettant de valider un carré */
	@FXML
	private CheckBox carre;
	
	/** La case permettant de valider un brelan */
	@FXML
	private CheckBox brelan;
	
	/** La case permettant de valider une suite */
	@FXML
	private CheckBox suite;
	
	/** La case permettant de valider un petite suite */
	@FXML
	private CheckBox petiteSuite;
	
	/** La case permettant de valider un full */
	@FXML
	private CheckBox full;
	
	/** La case permettant de valider une chance */
	@FXML
	private CheckBox chance;
	
	/** L'endroit où sont affichés les différents combos diponnibles */
	@FXML
	private Label comboDispo;
	
	/** L'endroit où est affiché le pseudo du joueur */
	@FXML
	private Label pseudo;
	
	/** L'endroit où sont affichés les lancés restant */
	@FXML
	private Label lances;
	
	/** Défini le nombre de lancés restants */
	private int lancesRestants;
	
	/** Conserve les résultats du tirage actuel */
	private int[] resultatsTirage;
	
	/** Définit si la valeur d'un dès est a conserver */
	private boolean[] aConserver = {false, false, false, false, false};
	
	/**
	 * Permet d'afficher le pseudo choisi par le joueur
	 */
	@FXML
	public void initialize() {
		lancesRestants = 3;
		lances.setText(Integer.toString(lancesRestants));
		
		//FIXME le pseudo ne s'actualise pas
		Joueur profilJoueur = Main.profilJoueur;
		if(profilJoueur != null) {
			pseudo.setText(profilJoueur.getPseudo());
		}
		/* On cache les checkbox tant qu'elles ne sont pas utiles */
		yandee.setVisible(false);
		carre.setVisible(false);
		brelan.setVisible(false);
		suite.setVisible(false);
		petiteSuite.setVisible(false);
		full.setVisible(false);
		chance.setVisible(false);
	}
	
	/**
	 * Permet de lancer les dès
	 */
	@FXML
	private void lancementDes() {
		int desALancer;
		int[] resultatsLance;
		
		if (resultatsTirage == null) {
			resultatsTirage = new int[5];
		}
		
		/* On défini le nombre de dès à lancer */
		desALancer = 0;
		for (int i=0; i<aConserver.length; i++) {
			if (!aConserver[i]) {
				desALancer++;
			}
		}
		/* S'il y a des dés à lancer, on remplace les valeurs des dès */
		if (desALancer != 0 && lancesRestants > 0) {
			lancesRestants--;
			lances.setText(Integer.toString(lancesRestants));
			/* On lance autant de dès qu'il y en a a changer */
			resultatsLance = new ManchetteDe(desALancer, 6).getResultats();
			
			/* On change les valeurs à supprimer par les nouvelles 
			   valeurs */
			for (int i=0, j=0; i<resultatsTirage.length 
					           && j < resultatsLance.length; i++) {
				if (!aConserver[i]) {
					resultatsTirage[i] = resultatsLance[j];
					j++;
				}
			}
		} else if (lancesRestants >= 0) {
			/* S'il n'y a pas de lancés restants, on valide le résultat */
			validerLance();
		}
		
		/* On affiche le résultat du lancé */
		de1.setText(Integer.toString(resultatsTirage[0]));
		de2.setText(Integer.toString(resultatsTirage[1]));
		de3.setText(Integer.toString(resultatsTirage[2]));
		de4.setText(Integer.toString(resultatsTirage[3]));
		de5.setText(Integer.toString(resultatsTirage[4]));
	}
	
	/**
	 * Permet de valider le résultat du lancé
	 */
	@FXML
	private void validerLance() {
		String resultat;
		
		lancesRestants = 3;
		lances.setText(Integer.toString(lancesRestants));
		
		/* on récupère les résultats du tirage */
		if (resultatsTirage != null) {
			resultat = new Combo(resultatsTirage).getAnnonces();
			comboDispo.setText(resultat);
			/* on identifie les combos possibles */
			if (resultat.contains("Yandee")) {
				/* si combo possible, on affiche la checkbox */
				yandee.setVisible(true);
			}
			if (resultat.contains("carré")) {
				carre.setVisible(true);
			}
			if (resultat.contains("brelan")) {
				brelan.setVisible(true);
			}
			if (resultat.startsWith("suite")) {
				suite.setVisible(true);
			}
			if (resultat.contains("petite suite")) {
				petiteSuite.setVisible(true);
			}
			if (resultat.contains("full")) {
				full.setVisible(true);
			}
			chance.setVisible(true);
		}
		
		/* On dé-selectionne chaque dés */
		for (int i=0; i<aConserver.length; i++) {
			aConserver[i] = false;
		}
		de1.setBorder(null);
		de2.setBorder(null);
		de3.setBorder(null);
		de4.setBorder(null);
		de5.setBorder(null);
	}
	
	/**
	 * Conserve le résultat du premier dé
	 */
	@FXML
	private void conserverTirageDe1() {
		if (lancesRestants != 3) {
			if (aConserver[0]) {
				aConserver[0] = false;
				de1.setBorder(null);
			} else {
				aConserver[0] = true;
				de1.setBorder(Border.stroke(Paint.valueOf("Blue")));
			}
		}
	}
	
	/**
	 * Conserve le résultat du second dé
	 */
	@FXML
	private void conserverTirageDe2() {
		if (lancesRestants != 3) {
			if (aConserver[1]) {
				aConserver[1] = false;
				de2.setBorder(null);
			} else {
				aConserver[1] = true;
				de2.setBorder(Border.stroke(Paint.valueOf("Blue")));
			}
		}
	}
	
	/**
	 * Conserve le résultat du troisième dé
	 */
	@FXML
	private void conserverTirageDe3() {
		if (lancesRestants != 3) {
			if (aConserver[2]) {
				aConserver[2] = false;
				de3.setBorder(null);
			} else {
				aConserver[2] = true;
				de3.setBorder(Border.stroke(Paint.valueOf("Blue")));
			}
		}
	}
	
	/**
	 * Conserve le résultat du quatrième dé
	 */
	@FXML
	private void conserverTirageDe4() {
		if (lancesRestants != 3) {
			if (aConserver[3]) {
				aConserver[3] = false;
				de4.setBorder(null);
			} else {
				aConserver[3] = true;
				de4.setBorder(Border.stroke(Paint.valueOf("Blue")));
			}
		}
	}
	
	/**
	 * Conserve le résultat du cinquième dé
	 */
	@FXML
	private void conserverTirageDe5() {
		if (lancesRestants != 3) {
			if (aConserver[4]) {
				aConserver[4] = false;
				de5.setBorder(null);
			} else {
				aConserver[4] = true;
				de5.setBorder(Border.stroke(Paint.valueOf("Blue")));
			}
		}
	}
	
	/**
	 * Permet de passer à la page fxml du menu
	 */
	@FXML
	private void retour() {
		Main.activerMenu();
	}
}
