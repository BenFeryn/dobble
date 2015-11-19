import java.awt.Image;
import java.awt.Point;

/**
 * Cette classe représente un symbole à afficher.
 * Elle sera la version graphique de la classe Symbole.
 * @see Symbole
 * 
 * @author Camille
 * @version 1.0
 */
public class SymboleG extends Element{

	/* Attributs */
	
	private Symbole symbole;

	private Image img;

	private int largeur;
	private int hauteur;
	
	private boolean selectionne;

	/* Constructeur */
	
	public SymboleG(Point o) {
		super(o);
		selectionne = false;
		//TODO Générer l'image
	}
	
	/* Accesseur */
	
	/* GET */
	
	public boolean getSelectionne(){
		return selectionne;
	}
	
	/* SET */
	
	public void setSelectionne(boolean b){
		selectionne = b;
	}
}
