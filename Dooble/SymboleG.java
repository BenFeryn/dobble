import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

/**
 * Cette classe repr�sente un symbole � afficher.
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
		
		//TODO G�n�rer l'image
		
		/*try {
		    URL url = getClass().getClassLoader().getResource ("./img/smb/"+s.getLienImg()+".png");
		    //System.out.println(url.getPath());
		    img = ImageIO.read (url);
		}
		catch ( IOException e ) {		
		    System.out.println ("[!] Erreur : L'image est introuvable.\n" + e);
		}*/
	}
	
	/* Accesseur */
	
	/* GET */
	
	public boolean getSelectionne(){
		return selectionne;
	}
	
	public Symbole getSymbole(){
		return symbole;
	}
	
	/* SET */
	
	public void setSelectionne(boolean b){
		selectionne = b;
	}
	
	/* M�thode */
	
	public void afficher(Graphics g){
		//Attente des images
		g.drawRect ( (int)min.getX(), (int)(g.getClipBounds().getHeight()-min.getY()-hauteur), largeur, hauteur );
		//g.drawImage (img, (int)min.getX(), (int)(g.getClipBounds().getHeight()-this.min.getY()-hauteur), largeur, hauteur, null);
	}
	
	public boolean comparer(SymboleG s){
		return s.getSymbole().equals(getSymbole());
	}
	
	public boolean intersection(Point p){
		boolean retour = true;
		if(p.getX() > max.getX() || p.getX() < min.getX() || p.getY() > max.getY() || p.getY() < min.getY())
			retour = false;
		return retour;
	}
}
