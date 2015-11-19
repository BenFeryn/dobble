import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Cette classe h�rite de JPanel.
 * Elle repr�sente le fond de la fen�tre.
 * L� o� nous dessinerons les cartes
 * @see CarteG
 * 
 * @author Camille
 * @version 1.0
 */
public class Fond extends JPanel{
	
	/* Attributs */
	
	/**
	 * Liste des carte dans le "fond" de la fen�tre
	 * � chaque ajout ou suppression l'affichage se met � jour
	 */
	private ArrayList<CarteG> cartes;
	
	/* Constructeurs */
	
	/**
	 * Cr�e un nouvau fond sans carte
	 */
	public Fond(){
		cartes = new ArrayList<CarteG>();
	}
	
	
	/**
	 * Constructeur par copie d'un Fond
	 * @param c
	 * 		Fond � copier
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
	 * M�thode appel�e automatique pour afficher toutes contenues dans l'arraylist les cartes sur le fond
	 */
	public void paint(Graphics g){
		for(int i = 0; i < cartes.size();i++)
			cartes.get(i).afficher(g);
	}
	
	/**
	 * M�thode pour ajouter une carte dans l'arraylist et l'affiche
	 * @param c CarteG
	 * 		Carte � ajouter et afficher
	 */
	public void ajouter(CarteG c){
		cartes.add(c);
		repaint();
	}
	
	/**
	 * Supprimer un carte pr�sente dans l'arraylist et l'enl�ve du fond
	 * @param c CarteG
	 * 		Carte � enlever
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
