import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
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
	 * Initialise une nouvelle fenêtre avec un fond vide
	 * Applique la taille utile de l'écran
	 */
	public Fenetre(){
		fond = new Fond();
		setContentPane(fond);
		
		//Récupérer taille "utile" de l'écran et la stock dans un rectangle
		GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
		
		hauteur = (int)maximumWindowBounds.getHeight();
		largeur = (int)maximumWindowBounds.getWidth();
		
		setSize(largeur, hauteur);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		//Icone de la fenêtre
		try {
		    URL url = getClass().getClassLoader().getResource ("./img/ico/icone.png");
		    Image icone = ImageIO.read (url);
		    setIconImage(icone);
		}
		catch ( IOException e ) {		
		    System.out.println ("[!] Erreur : L'image est introuvable.\n" + e);
		}
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
	
	public int getHauteur(){
		return hauteur;
	}
	
	public int getLargeur(){
		return largeur;
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
	 * Ajouter un nouvel élèment
	 * Fait l'intermédiaire avec le fond
	 * @param  e Element
	 * 		Elèment à ajouter
	 */
	public void ajouter(Element e){
		fond.ajouter(e);
	}
	
	/**
	 * Supprime un élèment de l'écran
	 * Fait l'intermédiaire avec le fond
	 * @param e Element
	 * 		Elèment à supprimer
	 */
	public void supprimer(Element e){
		fond.supprimer(e);
	}
}
