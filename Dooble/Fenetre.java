import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;

/**
 * Cette classe sera la fenetre du jeu.
 * Les cartes seront dessinÃ©es sur cette fenÃªtre.
 * Aucune fonction mathÃ©matique ne se trouve dans classe.
 * 
 * @author ingouf.camille
 * @version 1.0
 */
public class Fenetre extends JFrame{
	
	/* Attributs */
	
	/**
	 * Fond à ajouter à la fenêtre
	 */
	Fond fond;
	
	/**
	 * Taille de la fenêtre
	 */
	int hauteur;
	int largeur;
	
	/* Constructeur */
	
	/**
	 * Inialise une nouvelle fenêtre avec un fond vide
	 * Applique la taille utile de l'écran
	 */
	public Fenetre(){
		fond = new Fond();
		setContentPane(fond);
		
		//Récupérer taille "utile" de l'écran et la stock dans un rectangle
		GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
		
		setSize((int)maximumWindowBounds.getWidth(), (int)maximumWindowBounds.getHeight());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	/* Accesseurs */
	
	/* GET */
	
	/**
	 * Retourne le fond de l'écran
	 * @return Fond
	 * 		fond de l'écran
	 */
	public Fond getFond(){
		return fond;
	}
	
	/**
	 * Retourne le milieu de l'écran
	 * Fait l'intermédiaire avec le fond
	 * @return Point
	 * 		Milieu de la fenêtre
	 */
	public Point getMilieu(){
		return fond.getMilieu();
	}
	
	/* SET */
	
	
	
	/* Méthodes */
	
	/**
	 * Efface le contenu de la fenêtre
	 * Fait l'intermédiaire avec le fond
	 */
	public void effacer(){
		fond.effacer();
	}
	
	/**
	 * Ajouter une nouvelle carte
	 * Fait l'intermédiaire avec le fond
	 * @param c CarteG
	 * 		Carte à ajouter
	 */
	public void ajouter(Element e){
		fond.ajouter(e);
	}
	
	/**
	 * Supprime une carte de l'écran
	 * Fait l'intermédiaire avec le fond
	 * @param c CarteG
	 * 		Carte à supprimer
	 */
	public void supprimer(CarteG c){
		fond.supprimer(c);
	}
}
