import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Cette classe hérite de JPanel.
 * Elle représente le fond de la fenêtre.
 * Là où nous dessinerons les cartes
 * @see CarteG
 * 
 * @author Camille
 * @version 1.0
 */
public class Fond extends JPanel{
	
	/* Attributs */
	
	/**
	 * Liste des carte dans le "fond" de la fenêtre
	 * à chaque ajout ou suppression l'affichage se met à jour
	 */
	private ArrayList<CarteG> cartes;
	
	/* Constructeurs */
	
	/**
	 * Crée un nouvau fond sans carte
	 */
	public Fond(){
		cartes = new ArrayList<CarteG>();
	}
	
	
	/**
	 * Constructeur par copie d'un Fond
	 * @param c
	 * 		Fond à copier
	 */
	public Fond(ArrayList<CarteG> c){
		for(int i=0;i<c.size();i++){
			cartes.add(c.get(i));
		}
	}
	
	/* Accesseurs */
	
	/* GET */
	
	/**
	 * Retourne le point au centre de la carte
	 * @return Point
	 * 		Point au centre
	 */
	public Point getMilieu(){
		return new Point(this.getWidth()/2, this.getHeight()/2);
	}
	
	/**
	 * Retourne l'arraylist contenant toutes les cartes du fond
	 * @return ArrayList
	 * 		Liste des cartes
	 */
	public ArrayList<CarteG> getCartes(){
		return cartes;
	}
	
	/* SET */
	
	/**
	 * Changer les cartes avec une autre arraylist de Carte
	 * @param c ArrayList
	 */
	public void setCartes(ArrayList<CarteG> c){
		cartes = c;
	}
	
	/* Methode */
	
	/**
	 * Méthode appelée automatique pour afficher toutes contenues dans l'arraylist les cartes sur le fond
	 */
	public void paint(Graphics g){
		for(int i = 0; i < cartes.size();i++)
			cartes.get(i).afficher(g);
	}
	
	/**
	 * Méthode pour ajouter une carte dans l'arraylist et l'affiche
	 * @param c CarteG
	 * 		Carte à ajouter et afficher
	 */
	public void ajouter(CarteG c){
		cartes.add(c);
		repaint();
	}
	
	/**
	 * Supprimer un carte présente dans l'arraylist et l'enlève du fond
	 * @param c CarteG
	 * 		Carte à enlever
	 */
	public void supprimer(CarteG c) {
		cartes.remove(c);
		repaint();
	}
	
	/**
	 * Effacer toutes les cartes de l'arrylist et du fond
	 */
	public void effacer(){
		cartes.clear();
		repaint();
	}

}
