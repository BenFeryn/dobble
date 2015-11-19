import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Cette classe hérite de JPanel.
 * Elle représente le fond de la fenêtre.
 * Là où nous dessinerons les cartes
 * @see Carte
 * @see CarteG
 * 
 * @author Camille
 * @version 1.0
 */
public class Fond extends JPanel{
	
	/* Attributs */
	
	private ArrayList<CarteG> cartes;
	
	/* Constructeurs */
	
	public Fond(){
		cartes = new ArrayList<CarteG>();
	}
	
	public Fond(ArrayList<CarteG> c){
		for(int i=0;i<c.size();i++){
			cartes.add(c.get(i));
		}
	}
	
	/* Accesseurs */
	
	/* GET */
	
	public Point getMilieu(){
		return new Point(this.getWidth()/2, this.getHeight()/2);
	}
	
	public ArrayList<CarteG> getCartes(){
		return cartes;
	}
	
	/* SET */
	
	public void setCartes(ArrayList<CarteG> c){
		cartes = c;
	}
	
	/* Methode */
	
	public void paint(Graphics g){
		for(int i = 0; i < cartes.size();i++)
			cartes.get(i).afficher(g);
	}
	
	public void ajouter(CarteG c){
		cartes.add(c);
		repaint();
	}
	
	public void supprimer(CarteG c) {
		cartes.remove(c);
		repaint();
	}
	
	public void effacer(){
		cartes.clear();
		repaint();
	}

}
