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
	
	Fond fond;
	
	int hauteur;
	int largeur;
	
	/* Constructeur */
	
	public Fenetre(){
		fond = new Fond();
		
		//get local graphics environment
		GraphicsEnvironment graphicsEnvironment=GraphicsEnvironment.getLocalGraphicsEnvironment();
		//get maximum window bounds
		Rectangle maximumWindowBounds=graphicsEnvironment.getMaximumWindowBounds();
		
		setSize((int)maximumWindowBounds.getWidth(), (int)maximumWindowBounds.getHeight());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	/* Accesseurs */
	
	/* GET */
	
	public Fond getFond(){
		return fond;
	}
	
	public Point getMilieu(){
		return fond.getMilieu();
	}
	
	/* SET */
	
	/* M�thodes */
	
	public void effacer(){
		fond.effacer();
	}
	
	public void ajouter(CarteG c){
		fond.ajouter(c);
	}
	
	public void supprimer(CarteG c){
		fond.supprimer(c);
	}
}
