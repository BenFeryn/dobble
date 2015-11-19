import java.awt.Graphics;
import java.awt.Point;

/**
 * Cette classe sera la version affichée d'une Carte
 * @see Carte
 * @author Camille
 * @version 1.0
 */
public class CarteG{

	/* Attributs */
	
	private Point centre;
	
	private int rayon;
	
	private SymboleG symboles[];
	
	/* Constructeurs */
	
	public CarteG(Point o, int r){
		centre = new Point(o);
		rayon = r;
	}
	
	/* Accesseurs */
	
	/* GET */
	
	public Point getCentre(){
		return centre;
	}
	
	public int getRayon(){
		return rayon;
	}
	
	/* SET */
	
	public void setCentre(Point o){
		centre = new Point(o);
	}
	
	public void setRayon(int r){
		rayon = r;
	}
	
	/* Méthodes */
	
	public void afficher(Graphics g) {
		g.drawOval((int)(this.getCentre().getX()-rayon), (int)(g.getClipBounds().getHeight()-this.getCentre().getY()-rayon ), (rayon*2), (rayon*2));
	}

}
