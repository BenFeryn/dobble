import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Cette classe h�rite de JPanel.
 * Elle repr�sente le fond de la fen�tre.
 * L� o� nous dessinerons les �l�ments
 * @see Element
 * 
 * @author Camille
 * @version 1.1
 */
public class Fond extends JPanel{
	
	/* Attributs */
	
	/**
	 * Liste des elements dans le "fond" de la fen�tre
	 * � chaque ajout ou suppression l'affichage se met � jour
	 * @since 1.1
	 */
	private ArrayList<Element> elements;
	
	/* Constructeurs */
	
	/**
	 * Cr�e un nouvau fond sans �l�ments
	 * @since 1.1
	 */
	public Fond(){
		elements = new ArrayList<Element>();
	}
	
	
	/**
	 * Constructeur par copie d'un Fond
	 * @param c
	 * 		Fond � copier
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
	 * Retourne l'arraylist contenant tous les �l�ments du fond
	 * @return ArrayList
	 * 		Liste des �l�ments
	 * @since 1.1
	 */
	public ArrayList<Element> getCartes(){
		return elements;
	}
	
	/* SET */
	
	/**
	 * Changer les �l�ments avec une autre arraylist d'�l�ments
	 * @param c ArrayList
	 * @since 1.1
	 */
	public void setElements(ArrayList<Element> c){
		elements = c;
	}
	
	/* Methode */
	
	/**
	 * M�thode appel�e automatique pour afficher tous les �l�ments contenus dans l'arraylist sur le fond
	 * @since 1.1
	 */
	public void paint(Graphics g){
		for(int i = 0; i < elements.size();i++)
			elements.get(i).afficher(g);
	}
	
	/**
	 * M�thode pour ajouter un �l�ments dans l'arraylist et l'affiche
	 * @param e Element
	 * 		El�ment � ajouter et afficher
	 * @since 1.1
	 */
	public void ajouter(Element e){
		elements.add(e);
		repaint();
	}
	
	/**
	 * Supprimer un �l�ments pr�sent dans l'arraylist et l'enl�ver du fond
	 * @param e Element
	 * 		El�ment � enlever
	 * @since 1.1
	 */
	public void supprimer(Element c) {
		elements.remove(c);
		repaint();
	}
	
	/**
	 * Effacer tous les �l�ments de l'arrylist et du fond
	 */
	public void effacer(){
		elements.clear();
		repaint();
	}

}
