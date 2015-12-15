import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
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
	 * Initialise une nouvelle fen�tre avec un fond vide
	 * Applique la taille utile de l'�cran
	 */
	public Fenetre(){
		fond = new Fond();
		setContentPane(fond);
		
		//R�cup�rer taille "utile" de l'�cran et la stock dans un rectangle
		GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
		
		//hauteur = (int)maximumWindowBounds.getHeight();
		//largeur = (int)maximumWindowBounds.getWidth();
		
		hauteur = 600;
		largeur = 800;
		
		setSize(largeur, hauteur);
		setTitle("Kappa");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		//Icone de la fen�tre
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
	
	public int getHauteur(){
		return hauteur;
	}
	
	public int getLargeur(){
		return largeur;
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
	 * Ajouter un nouvel �l�ment
	 * Fait l'interm�diaire avec le fond
	 * @param  e Element
	 * 		El�ment � ajouter
	 */
	public void ajouter(Element e){
		fond.ajouter(e);
	}
	
	/**
	 * Supprime un �l�ment de l'�cran
	 * Fait l'interm�diaire avec le fond
	 * @param e Element
	 * 		El�ment � supprimer
	 */
	public void supprimer(Element e){
		fond.supprimer(e);
	}
}
