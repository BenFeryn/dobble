import java.awt.Graphics;
import java.awt.Point;

/**
 * Cette classe sera la version affich�e d'une Carte
 * @see Carte
 * @author Camille
 * @version 1.0
 */
public class CarteG{

	/* Attributs */
	
	/**
	 * Point correspondant au centre de la carte 
	 */
	private Point centre;
	
	private int rayon;
	
	/**
	 * Symboles � afficher de la carte
	 */
	private SymboleG symboles[];
	
	/**
	 * Carte qui sera util�e pour modiler la carte � l'�cran
	 * @see Carte
	 */
	private Carte carte;
	
	/* Constructeurs */
	
	/**
	 * Construit une carte � afficher avec une carte, un point et une rayon
	 * Elle initialise les symboles dans la carte
	 * @param c Carte
	 * 		Carte utilis�e
	 * @param o Point
	 * 		Point au centre de la carte � afficher
	 * @param r int
	 * 		Rayon de la carte
	 */
	public CarteG(Carte c,Point o, int r){
		centre = new Point(o);
		rayon = r;
		
		symboles = new SymboleG[Csts.SYMBOLES_CARTE];
		carte = new Carte(c);
	}
	
	/* Accesseurs */
	
	/* GET */
	
	/**
	 * Retourne le Point du centre de la carte
	 * @return Point
	 * 		Centre de la carte
	 */
	public Point getCentre(){
		return centre;
	}
	
	/**
	 * Retourn le rayon de la carte
	 * @return int
	 * 		rayon de la carte
	 */
	public int getRayon(){
		return rayon;
	}
	
	/**
	 * Retourne la carte utilis�e pour mod�liser la carte � afficher
	 * @return Carte
	 * 		Carte utilis�e
	 */
	public Carte getCarte(){
		return carte;
	}
	
	/* SET */
	
	/**
	 * Changer le centre de la carte
	 * @param o Point
	 * 		Nouveau centre
	 */
	public void setCentre(Point o){
		centre = new Point(o);
	}
	
	/**
	 * Changer le rayon de la carte
	 * @param r int
	 * 		Nouveau rayon
	 */
	public void setRayon(int r){
		rayon = r;
	}
	
	/**
	 * Changer la carte untilis�e
	 * @param c Carte
	 * 		Carte utilis�e
	 */
	public void setCarte(Carte c){
		carte = new Carte(c);
	}
	
	/* M�thodes */
	
	/**
	 * M�thode appel�e automatiquement pour afficher la carte � l'�cran
	 * @param g Graphics
	 */
	public void afficher(Graphics g) {
		g.drawOval((int)(this.getCentre().getX()-rayon), (int)(g.getClipBounds().getHeight()-this.getCentre().getY()-rayon ), (rayon*2), (rayon*2));
	}

}
