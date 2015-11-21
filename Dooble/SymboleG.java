import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

/**
 * Cette classe reprï¿½sente un symbole ï¿½ afficher.
 * Elle sera la version graphique de la classe Symbole.
 * @see Symbole
 * 
 * @author Camille
 * @version 1.0
 */
public class SymboleG extends Element{

	/* Attributs */

	/**
	 * Symbole utilisé pour faire le SymboleG
	 */
	private Symbole symbole;

	/**
	 * Image déssinée, générée à l'aide du lien dans le symbole
	 * @see Symbole.LienImg
	 */
	private Image img;

	/**
	 * Dimmensiens
	 * Elles seront utilisées pour donner diverses tailles aux symboles
	 */
	private int largeur;
	private int hauteur;
	
	/**
	 * Point inférieur gauche et Point supérieur droite de l'image
	 * Ils seront déterminés grâce au point centrale et aux dimenssions de l'image
	 */
	private Point min;
	private Point max;
	
	/**
	 * Détermine si le symboleG est séléctionné ou pas
	 */
	private boolean selectionne;

	/* Constructeur */
	
	/**
	 * Initialise un SymboleG avec le lien de symbole, un point centrale, la taille et la sélection fausse
	 * @param o Point
	 * 		Point centrale
	 * @param s Symbole
	 * 		Symbole utilisé pour générer le SymboleG
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
		
		//TODO Gï¿½nï¿½rer l'image
		
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
	
	/**
	 * Permet de récupérer la seletion du symbole
	 * @return boolean
	 * 		@see selectionne
	 */
	public boolean getSelectionne(){
		return selectionne;
	}
	
	/**
	 * Permet de récupérer le symbole utilisé
	 * @return Symbole
	 * 		@see symbole
	 */
	public Symbole getSymbole(){
		return symbole;
	}
	
	/* SET */
	
	/**
	 * Permet de changer la séléction du SymboleG
	 * @param b boolean
	 * 		@see selectionne
	 */
	public void setSelectionne(boolean b){
		selectionne = b;
	}
	
	/* Mï¿½thode */
	
	/**
	 * Méthode héritée de Element qui permet de dessiner le SymboleG à l'écran avec ses dimmensions et sa position
	 * @see Element
	 */
	public void afficher(Graphics g){
		//Attente des images. On dessine des rectangles
		g.drawRect ( (int)min.getX(), (int)(g.getClipBounds().getHeight()-min.getY()-hauteur), largeur, hauteur );
		//g.drawImage (img, (int)min.getX(), (int)(g.getClipBounds().getHeight()-this.min.getY()-hauteur), largeur, hauteur, null);
	}
	
	/**
	 * Méthode qui compare deux SymboleG, elle fait appelle à la méthode comparer de Symbole
	 * @see Symbole
	 * @param s SymboleG
	 * 		SymboleG à comparer
	 * @return boolean
	 * 		vrai si egale sinon faux
	 */
	public boolean equals(SymboleG s){
		return s.getSymbole().equals(getSymbole());
	}
	
	/**
	 * Test l'intersection entre un Symbole et un Point (généralement la souris)
	 * @param p Point
	 * 		Point à tester
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
