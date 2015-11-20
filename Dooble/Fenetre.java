import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JFrame;

/**
 * Cette classe sera la fenetre du jeu.
 * Les cartes seront dessinées sur cette fenêtre.
 * Aucune fonction mathématique ne se trouve dans classe.
 * 
 * @author ingouf.camille
 * @version 1.0
 */
public class Fenetre extends JFrame{
	
	/* Attributs */
	
	/**
	 * Fond � ajouter � la fen�tre
	 */
	Fond fond;
	
	/**
	 * Taille de la fen�tre
	 */
	int hauteur;
	int largeur;
	
	/* Constructeur */
	
	/**
	 * Inialise une nouvelle fen�tre avec un fond vide
	 * Applique la taille utile de l'�cran
	 */
	public Fenetre(){
		fond = new Fond();
		setContentPane(fond);
		
		//R�cup�rer taille "utile" de l'�cran et la stock dans un rectangle
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
	 * Retourne le fond de l'�cran
	 * @return Fond
	 * 		fond de l'�cran
	 */
	public Fond getFond(){
		return fond;
	}
	
	/**
	 * Retourne le milieu de l'�cran
	 * Fait l'interm�diaire avec le fond
	 * @return Point
	 * 		Milieu de la fen�tre
	 */
	public Point getMilieu(){
		return fond.getMilieu();
	}
	
	/* SET */
	
	
	
	/* M�thodes */
	
	/**
	 * Efface le contenu de la fen�tre
	 * Fait l'interm�diaire avec le fond
	 */
	public void effacer(){
		fond.effacer();
	}
	
	/**
	 * Ajouter une nouvelle carte
	 * Fait l'interm�diaire avec le fond
	 * @param c CarteG
	 * 		Carte � ajouter
	 */
	public void ajouter(Element e){
		fond.ajouter(e);
	}
	
	/**
	 * Supprime une carte de l'�cran
	 * Fait l'interm�diaire avec le fond
	 * @param c CarteG
	 * 		Carte � supprimer
	 */
	public void supprimer(CarteG c){
		fond.supprimer(c);
	}
}
