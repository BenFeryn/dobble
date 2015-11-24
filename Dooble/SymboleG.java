import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;

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

	/**
	 * Symbole utilis� pour faire le SymboleG
	 */
	private Symbole symbole;

	/**
	 * Image d�ssin�e, g�n�r�e � l'aide du lien dans le symbole
	 * @see Symbole.LienImg
	 */
	private Image img;

	/**
	 * Dimmensiens
	 * Elles seront utilis�es pour donner diverses tailles aux symboles
	 */
	private int largeur;
	private int hauteur;
	
	/**
	 * Point inf�rieur gauche et Point sup�rieur droite de l'image
	 * Ils seront d�termin�s gr�ce au point centrale et aux dimenssions de l'image
	 */
	private Point min;
	private Point max;
	
	/**
	 * D�termine si le symboleG est s�l�ctionn� ou pas
	 */
	private boolean selectionne;

	/* Constructeur */
	
	/**
	 * Initialise un SymboleG avec le lien de symbole, un point centrale, la taille et la s�lection fausse
	 * @param o Point
	 * 		Point centrale
	 * @param s Symbole
	 * 		Symbole utilis� pour g�n�rer le SymboleG
	 * @param largeur int
	 * @param hauteur int
	 * 		Dimmenssions de l'image
	 */
	public SymboleG(Point o, Symbole s, int largeur, int hauteur) {
		super(o);
		selectionne = false;
		symbole = s;
		this.largeur = largeur;
		this.hauteur = hauteur;
		min = new Point((int)getCentre().getX()-largeur/2,(int)getCentre().getY()-hauteur/2);
		max = new Point((int)getCentre().getX()+largeur/2,(int)getCentre().getY()+hauteur/2);
		
		//TODO G�n�rer l'image
		
		try {
		    java.net.URL url = getClass().getClassLoader().getResource ("./img/smb/"+s.getLienImg()+".png");
		    //System.out.println(url.getPath());
		    img = ImageIO.read (url);
		}
		catch ( IOException e ) {		
		    System.out.println ("[!] Erreur : L'image est introuvable.\n" + e);
		}
	}
	
	/* Accesseur */
	
	/* GET */
	
	/**
	 * Permet de r�cup�rer la seletion du symbole
	 * @return boolean
	 * 		@see selectionne
	 */
	public boolean getSelectionne(){
		return selectionne;
	}
	
	/**
	 * Permet de r�cup�rer le symbole utilis�
	 * @return Symbole
	 * 		@see symbole
	 */
	public Symbole getSymbole(){
		return symbole;
	}
	
	/* SET */
	
	/**
	 * Permet de changer la s�l�ction du SymboleG
	 * @param b boolean
	 * 		@see selectionne
	 */
	public void setSelectionne(boolean b){
		selectionne = b;
	}
	
	/* M�thode */
	
	/**
	 * M�thode h�rit�e de Element qui permet de dessiner le SymboleG � l'�cran avec ses dimmensions et sa position
	 * @see Element
	 */
	public void afficher(Graphics g){
		//Attente des images. On dessine des rectangles
		//g.drawRect ( (int)min.getX(), (int)(g.getClipBounds().getHeight()-min.getY()-hauteur), largeur, hauteur );
		Graphics2D g2 = (Graphics2D)g;
		AffineTransform rotation = new AffineTransform();
		rotation.translate(min.getX(), (int)(g.getClipBounds().getHeight()-this.min.getY()-hauteur));
		rotation.scale(0.1, 0.1);
		rotation.rotate(Math.toRadians(45), largeur, hauteur);
		g2.drawImage(img, rotation, null);
		
		//g.drawImage (img,rotation, (int)min.getX(), (int)(g.getClipBounds().getHeight()-this.min.getY()-hauteur), largeur, hauteur, null);
	}
	
	/**
	 * M�thode qui compare deux SymboleG, elle fait appelle � la m�thode comparer de Symbole
	 * @see Symbole
	 * @param s SymboleG
	 * 		SymboleG � comparer
	 * @return boolean
	 * 		vrai si egale sinon faux
	 */
	public boolean equals(SymboleG s){
		return s.getSymbole().equals(getSymbole());
	}
	
	/**
	 * Test l'intersection entre un Symbole et un Point (g�n�ralement la souris)
	 * @param p Point
	 * 		Point � tester
	 * @return boolean
	 * 		vrai si intersection sinon faux
	 */
	public boolean intersection(Point p){
		boolean retour = true;
		if(p.getX() > max.getX() || p.getX() < min.getX() || p.getY() > max.getY() || p.getY() < min.getY())
			retour = false;
		return retour;
	}
	
	public String toString(){
		return new String("SymboleG : "+getSymbole().getValeurSymbole()+" "+getSelectionne());
	}
}
