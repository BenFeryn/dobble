import java.awt.Point;


public class Main {

	public static void main(String[] args) {
		Paquet p =new Paquet();
		CarteG c = new CarteG(p.getCarte(0), new Point(50,150), 10);
		CarteG c2 = new CarteG(p.getCarte(1), new Point(150,150), 150);
		Fenetre f = new Fenetre();
		f.ajouter(c);
		f.ajouter(c2);
	}

}
