package vue;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import modele.Joueur;
import javafx.scene.Parent;
import javafx.scene.Scene;

// FIXME ranger la classe à part de la vue
public class Main extends Application {

	/** Le profil de l'utilisateur */
	public static Joueur profilJoueur = new Joueur("");
	
	/** Scène principale de l'application, celle qui contient les 2 boutons */
	private static Scene menu;
	
	/** Scène permettant de gérer le menu du jeu */
	private static Scene menuJeu;
	
	/** Scène permettant de gérer le jeu */
	private static Scene jeu;
	
	/** Scène permettant de gérer l'entrainement */
	private static Scene entrainement;
	
	/** Fenêtre principale de l'application
	* La scène qui lui est associée sera modifiée en fonction
	* des clics de l'utilisateur
	*/
	private static Stage fenetrePrincipale;
	
	/**
	* Permet de modifier la scène de la fenêtre principale
	* pour qu'elle devienne la scène principale, celle qui
	* affiche les 2 boutons addition et soustraction
	*/
	public static void activerMenu() {
		fenetrePrincipale.setScene(menu);
	}
	
	/**
	* Permet de modifier la scène de la fenêtre principale
	* pour qu'elle devienne celle du menu du jeu
	*/
	public static void activerMenuJeu() {
		fenetrePrincipale.setScene(menuJeu);
	}
	
	/**
	* Permet de modifier la scène de la fenêtre principale
	* pour qu'elle devienne celle du jeu
	*/
	public static void activerJeu() {
		fenetrePrincipale.setScene(jeu);
	}
	
	/**
	* Permet de modifier la scène de la fenêtre principale
	* pour qu'elle devienne celle de l'entrainement
	*/
	public static void activerEntrainement() {
		fenetrePrincipale.setScene(entrainement);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			/* création d'un chargeur de code FXML
			 * et chargement de la vue de l'application
			 */
			FXMLLoader chargeurFXML = new FXMLLoader();
			chargeurFXML.setLocation(getClass().getResource("Menu.fxml"));
			Parent conteneur = chargeurFXML.load();
			
			/*
			* Création de la scène principale
			*/
			menu = new Scene(conteneur, 1000, 750);
			
			/*
			* Chargement de la vue du menu du jeu et
			* création de la scène associée à cette vue
			*/
			FXMLLoader chargeurFXMLMenuJeu = new FXMLLoader();
			chargeurFXMLMenuJeu.setLocation(getClass().getResource("MenuJeu.fxml"));
			conteneur = chargeurFXMLMenuJeu.load();
			menuJeu = new Scene(conteneur, 1000, 750);
			
			/*
			* Chargement de la vue du jeu et
			* création de la scène associée à cette vue
			*/
			FXMLLoader chargeurFXMLJeu = new FXMLLoader();
			chargeurFXMLJeu.setLocation(getClass().getResource("Jeu.fxml"));
			conteneur = chargeurFXMLJeu.load();
			jeu = new Scene(conteneur, 1000, 750);
			
			/*
			* Chargement de la vue de la soustraction et
			* création de la scène associée à cette vue
			*/
			FXMLLoader chargeurFXMLEntrainement = new FXMLLoader();
			chargeurFXMLEntrainement.setLocation(getClass().getResource("Entrainement.fxml"));
			conteneur = chargeurFXMLEntrainement.load();
			entrainement = new Scene(conteneur, 1000, 750);
			
			primaryStage.setTitle("Yandee");
			primaryStage.setHeight(750);
			primaryStage.setWidth(1000);
			primaryStage.setScene(menu);
			fenetrePrincipale = primaryStage;
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	* Programme principal
	* @param args argument non utilisé
	*/
	public static void main(String[] args) {
		launch(args);
	}
}
