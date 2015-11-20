import java.awt.Graphics;
import java.awt.Point;

/**
 * Cette classe sera la version affich�e d'une Carte
 * @see Carte
 * @author Camille
 * @version 1.0
 */
public class CarteG extends Element{

	/* Attributs */
	
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
		super(o);
		rayon = r;
		
		symboles = new SymboleG[Csts.SYMBOLES_CARTE];
		carte = new Carte(c);
	}
	
	/* Accesseurs */
	
	/* GET */
	
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
		//TODO générer nouvelle carteG
	}
	
	/* M�thodes */
	
	/**
	 * M�thode appel�e automatiquement pour afficher la carte � l'�cran
	 * @param g Graphics
	 */
	public void afficher(Graphics g) {
		g.drawOval((int)(getCentre().getX()-rayon), (int)(g.getClipBounds().getHeight()-getCentre().getY()-rayon ), (rayon*2), (rayon*2));
	}

}
