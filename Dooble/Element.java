import java.awt.Graphics;
import java.awt.Point;

/**
 * Classe abstraite dont hériteront les classe à afficher
 * @author Camille
 * @version 1.0
 */
public abstract class Element {

	/**
	 * Point centrale de l'élèment
	 * Il sera utilsé pour dessiner les élèments à partir de leur centre
	 */
	private Point centre;
	
	/**
	 * Créer un élèment à partir d'un point centre donné
	 * @param o Point
	 * 		Point au centre de l'élèment
	 */
	public Element(Point o){
		centre = new Point(o);
	}
	
	/**
	 * Retoune le point centrale
	 * @return Point
	 * 		Point centrale
	 */
	public Point getCentre(){
		return centre;
	}
	
	/**
	 * Change le point centrale
	 * @param p Point
	 * 		Nouveau point centrale
	 */
	public void setCentre(Point p){
		centre = new Point(p);
	}
	
	/**
	 * Méthode abstraite qui de être redéfinie par toutes les classe qui hériteront de la classe Elèment
	 * Elle dessinera l'élèment
	 * @param g Graphics
	 */
	public abstract void afficher(Graphics g);
}
