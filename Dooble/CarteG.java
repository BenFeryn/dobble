import java.awt.Graphics;
import java.awt.Point;

/**
 * Cette classe sera la version affichï¿½e d'une Carte
 * @see Carte
 * @author Camille
 * @version 1.0
 */
public class CarteG extends Element{

	/* Attributs */
	
	private int rayon;
	
	/**
	 * Symboles ï¿½ afficher de la carte
	 */
	private SymboleG symboles[];
	
	/**
	 * Carte qui sera utilï¿½e pour modiler la carte ï¿½ l'ï¿½cran
	 * @see Carte
	 */
	private Carte carte;
	
	private boolean selectionne;
	
	/* Constructeurs */
	
	/**
	 * Construit une carte ï¿½ afficher avec une carte, un point et une rayon
	 * Elle initialise les symboles dans la carte
	 * @param c Carte
	 * 		Carte utilisï¿½e
	 * @param o Point
	 * 		Point au centre de la carte ï¿½ afficher
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
	 * Retourne la carte utilisï¿½e pour modï¿½liser la carte ï¿½ afficher
	 * @return Carte
	 * 		Carte utilisï¿½e
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
	 * Changer la carte untilisï¿½e
	 * @param c Carte
	 * 		Carte utilisï¿½e
	 */
	public void setCarte(Carte c){
		carte = new Carte(c);
		//TODO gÃ©nÃ©rer nouvelle carteG
	}
	
	public void setSelectionne(boolean b){
		selectionne = b;
	}
	
	/* Mï¿½thodes */
	
	/**
	 * Mï¿½thode appelï¿½e automatiquement pour afficher la carte ï¿½ l'ï¿½cran
	 * @param g Graphics
	 */
	public void afficher(Graphics g) {
		g.drawOval((int)(getCentre().getX()-rayon), (int)(g.getClipBounds().getHeight()-getCentre().getY()-rayon ), (rayon*2), (rayon*2));
		ajoutSymboles(g);
	}
	
	/**
	 * Selectionne un symbole dans la carte
	 * @param i int
	 * 		index du symbole à sélectionner
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
			int x = (int)((Math.cos(i*Math.PI/4)*(rayon*0.75))+getCentre().getX());
			int y = (int)((Math.sin(i*Math.PI/4)*(rayon*0.75))+getCentre().getY());
			symboles[i] = new SymboleG(new Point(x, y), carte.getSymbole(i), 50, 50);
		}
	}

}
