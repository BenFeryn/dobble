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
	private static double pos[] = {0,0.6,0.75,0.4,0.7};
	
	/**
	 * Symboles � afficher de la carte
	 */
	private SymboleG symboles[];
	
	/**
	 * Carte qui sera util�e pour modiler la carte � l'�cran
	 * @see Carte
	 */
	private Carte carte;
	
	private boolean selectionne;
	
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
		selectionne = false;
		
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
	
	public SymboleG getSymboleG(int i){
		return symboles[i];
	}
	
	public boolean getSelectionne(){
		return selectionne;
	}
	
	public SymboleG getSymboleSelectionne(){
		SymboleG temp = null;
		int i = 0;
		while(i < Csts.SYMBOLES_CARTE && temp == null){
			if(symboles[i].getSelectionne())
				temp = symboles[i];
			i++;
		}
		return temp;
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
	
	public void setSelectionne(boolean b){
		selectionne = b;
	}
	
	/* M�thodes */
	
	/**
	 * M�thode appel�e automatiquement pour afficher la carte � l'�cran
	 * @param g Graphics
	 */
	public void afficher(Graphics g) {
		g.drawOval((int)(getCentre().getX()-rayon), (int)(g.getClipBounds().getHeight()-getCentre().getY()-rayon ), (rayon*2), (rayon*2));
		ajoutSymboles(g);
	}
	
	/**
	 * Selectionne un symbole dans la carte
	 * @param i int
	 * 		index du symbole � s�lectionner
	 */
	public void selectionne(int i){
		selectionne = true;
		for(int j=0;j<Csts.SYMBOLES_CARTE;j++){
			if(j==i)
				symboles[j].setSelectionne(true);
			else
				symboles[j].setSelectionne(false);	
		}
	}
	
	private void ajoutSymboles(Graphics g){
		placerSymbole();
		for(int i=0;i<Csts.SYMBOLES_CARTE;i++){
			symboles[i].afficher(g);
		}
		
	}
	
	private void placerSymbole(){
		for(int i=0;i<Csts.SYMBOLES_CARTE;i++){
			int x,y=0;
			int temp = 0;
			if(i < 5){
				temp = i;
				if(i == 0)
					temp = 0;
			}else{
				temp = i-4; 
			}

			x = (int)((Math.cos(i*Math.PI/3.5)*(rayon*pos[temp]))+getCentre().getX());
			y = (int)((Math.sin(i*Math.PI/3.5)*(rayon*pos[temp]))+getCentre().getY());
			symboles[i] = new SymboleG(new Point(x, y), carte.getSymbole(i), 50, 50);
			
		}
	}
	
	public boolean hasSymbole(int i){
		boolean temp = false;
		for(int j=0;j<Csts.SYMBOLES_CARTE;j++){
			if(symboles[j].getSymbole().getValeurSymbole() == i){
				temp = true;
				break;
			}
		}
		return temp;
	}

}
