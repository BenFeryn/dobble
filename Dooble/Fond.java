import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Cette classe hérite de JPanel.
 * Elle représente le fond de la fenêtre.
 * Là où nous dessinerons les élèments
 * @see Element
 * 
 * @author Camille
 * @version 1.1
 */
public class Fond extends JPanel{
	
	/* Attributs */
	
	/**
	 * Liste des elements dans le "fond" de la fenêtre
	 * à chaque ajout ou suppression l'affichage se met à jour
	 * @since 1.1
	 */
	private ArrayList<Element> elements;
	
	/* Constructeurs */
	
	/**
	 * Crée un nouvau fond sans élèments
	 * @since 1.1
	 */
	public Fond(){
		elements = new ArrayList<Element>();
	}
	
	
	/**
	 * Constructeur par copie d'un Fond
	 * @param c
	 * 		Fond à copier
	 */
	public Fond(ArrayList<Element> c){
		for(int i=0;i<c.size();i++){
			elements.add(c.get(i));
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
	 * Retourne l'arraylist contenant tous les élèments du fond
	 * @return ArrayList
	 * 		Liste des élèments
	 * @since 1.1
	 */
	public ArrayList<Element> getCartes(){
		return elements;
	}
	
	/* SET */
	
	/**
	 * Changer les élèments avec une autre arraylist d'élèments
	 * @param c ArrayList
	 * @since 1.1
	 */
	public void setElements(ArrayList<Element> c){
		elements = c;
	}
	
	/* Methode */
	
	/**
	 * Méthode appelée automatique pour afficher tous les élèments contenus dans l'arraylist sur le fond
	 * @since 1.1
	 */
	public void paint(Graphics g){
		for(int i = 0; i < elements.size();i++)
			elements.get(i).afficher(g);
	}
	
	/**
	 * Méthode pour ajouter un élèments dans l'arraylist et l'affiche
	 * @param e Element
	 * 		Elèment à ajouter et afficher
	 * @since 1.1
	 */
	public void ajouter(Element e){
		elements.add(e);
		repaint();
	}
	
	/**
	 * Supprimer un élèments présent dans l'arraylist et l'enlèver du fond
	 * @param e Element
	 * 		Elèment à enlever
	 * @since 1.1
	 */
	public void supprimer(Element c) {
		elements.remove(c);
		repaint();
	}
	
	/**
	 * Effacer tous les élèments de l'arrylist et du fond
	 */
	public void effacer(){
		elements.clear();
		repaint();
	}

}
