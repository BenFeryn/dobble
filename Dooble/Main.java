import java.awt.Point;


public class Main {

	public static void main(String[] args) {
		//test affichage carte
		Paquet p =new Paquet();
		CarteG c = new CarteG(p.getCarte(0), new Point(50,150), 10);
		CarteG c2 = new CarteG(p.getCarte(1), new Point(150,150), 150);
		Fenetre f = new Fenetre();
		f.ajouter(c);
		f.ajouter(c2);
		
		//test affichage symbole image
		Symbole s = new Symbole(0);
		SymboleG sg = new SymboleG(new Point(200,200), s, 50, 50);
		f.ajouter(sg);
	}

}
