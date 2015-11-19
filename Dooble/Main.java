import java.awt.Point;


public class Main {

	public static void main(String[] args) {
		Paquet p =new Paquet();
		CarteG c = new CarteG(p.getCarte(0), new Point(150,150), 50);
		CarteG c2 = new CarteG(p.getCarte(1), new Point(550,550), 50);
		Fenetre f = new Fenetre();
		f.ajouter(c);
		f.ajouter(c2);
	}

}
