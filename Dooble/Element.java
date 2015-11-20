import java.awt.Graphics;
import java.awt.Point;

/**
 * Classe abstraite dont h�riteront les classe � afficher
 * @author Camille
 * @version 1.0
 */
public abstract class Element {

	/**
	 * Point centrale de l'�l�ment
	 * Il sera utils� pour dessiner les �l�ments � partir de leur centre
	 */
	private Point centre;
	
	/**
	 * Cr�er un �l�ment � partir d'un point centre donn�
	 * @param o Point
	 * 		Point au centre de l'�l�ment
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
	 * M�thode abstraite qui de �tre red�finie par toutes les classe qui h�riteront de la classe El�ment
	 * Elle dessinera l'�l�ment
	 * @param g Graphics
	 */
	public abstract void afficher(Graphics g);
}
