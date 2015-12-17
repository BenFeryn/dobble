import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JLabel;

public class Texte extends Element{

	private String texte;
	
	private int police;
	
	
	public Texte(String t, Point p, int police) {
		super(p);
		texte =t;
		this.police = police;
	}
	
	public void setTexte(String t){
		texte = t;
	}
	
	public String getTexte(){
		return texte;
	}

	@Override
	public void afficher(Graphics g) {
		Font font = new Font("Courier", Font.BOLD, police);
		g.setFont(font);
		g.drawString(texte, (int)getCentre().getX(), (int)getCentre().getY());
	}

}
