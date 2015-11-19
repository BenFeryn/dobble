import java.awt.Point;

/**
 * Classe abstraite dont h�riteront les classe � afficher
 * @author Camille
 * @version 1.0
 */
public abstract class Element {

	private Point centre;
	
	public Element(Point o){
		centre = new Point(o);
	}
	
	public Point getCentre(){
		return centre;
	}
	
	public void setCentre(Point p){
		centre = new Point(p);
	}
}
