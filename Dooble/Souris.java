import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Classe représentant une souris implémentant MouseListener et MouseMotionListener
 * Elle nous donnera sa position et son clicGauche
 * @author Camille
 *
 */
public class Souris implements MouseListener, MouseMotionListener{

	/* Attributs */
	/**
	 * Position en temps réel de la souris dans la fenêtre de jeu
	 */
	private Point position;

	private boolean clicGauche;
	/**
	 * Taille verticale de la souris
	 * Utile pour la position
	 */
	private int tailleY;
	
	/**
	 * Créer une souris en (-1,-1) avec une taille verticale
	 * @param taille int
	 * 		Taille verticale
	 */
	public Souris (int taille){
		clicGauche=false;
		position = new Point(-1,-1);
		tailleY=taille;
	}
	
	/**
	 * Retourne la valeur du clic gauche
	 * @return boolean
	 * 		valeur clicGauche
	 */
	public boolean getClicGauche(){
		boolean temp = clicGauche;
		clicGauche = false;
		return temp;
	}
	
	public Point getPosition(){
		return position;
	}
	
	/**
	 * Deteche le clic gauche et met clicGauche à true
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1){
			clicGauche = true;
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Change la position de la souris si elle bouge
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		position.setLocation(new Point(e.getX(),tailleY-e.getY()));
	}
	
	/**
	 * Retourne une phrase "La souris se trouve en postion (x,y), et a une taille de X";
	 */
	public String toString(){
		String temp = new String("");
		temp += "La souris se trouve en ("+(int)position.getX()+(int)position.getY()+"), et a une taille de "+tailleY;
		return temp;
	}

}
