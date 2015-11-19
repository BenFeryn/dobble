import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

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
	
	private Point min;
	private Point max;
	
	private boolean selectionne;

	/* Constructeur */
	
	public SymboleG(Point o, Symbole s, int largeur, int hauteur) {
		super(o);
		selectionne = false;
		symbole = s;
		this.largeur = largeur;
		this.hauteur = hauteur;
		min = new Point((int)o.getX()-largeur/2,(int)o.getY()-hauteur/2);
		max = new Point((int)o.getX()+largeur/2,(int)o.getY()+hauteur/2);
		
		//TODO Générer l'image
		
		try {
		    URL url = getClass().getClassLoader().getResource ("./img/"+s.getLienImg());
		    img = ImageIO.read (url);
		}
		catch ( IOException e ) {		
		    System.out.println ("[!] Erreur : L'image est introuvable.\n" + e);
		}
		
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
	
	/* Méthode */
	
	public void afficher(Graphics g){
		g.drawImage (img, (int)min.getX(), (int)(g.getClipBounds().getHeight()-this.min.getY()-hauteur), largeur, hauteur, null);
	}
}
