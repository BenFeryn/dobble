import java.awt.Point;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Jeu {

	private static Fenetre  f;
	private static Paquet p;
	private static Souris souris;
	
	private CarteG cartes[];
	private int indexCartes[];
	private Point positionCartes[];
	private int index;
	
	public Jeu(){
		p = new Paquet();
		f = new Fenetre();
		souris = new Souris(f.getHauteur());
		f.addMouseListener(souris);
		f.addMouseMotionListener(souris);
		cartes = new CarteG[Csts.CARTE_FENETRE];
		positionCartes = new Point[Csts.CARTE_FENETRE];
		
		positionCartes[0] = new Point((int)f.getMilieu().getX()/2,(int)f.getMilieu().getY());
		positionCartes[1] = new Point((int)(f.getMilieu().getX()/2+f.getMilieu().getX()),(int)f.getMilieu().getY());
	
		index = 0;
		initialisationIndexCartes();
		initialiseCartes();
	}
	
	private void initialisationIndexCartes(){
		indexCartes = new int[Csts.NB_CARTES];
		for(int i=0;i<Csts.NB_CARTES;i++){
			indexCartes[i] = i;
			index++;
		}
		melangeCartes(indexCartes);
	}
	
	private void initialiseCartes(){
		for(int i=0;i<Csts.CARTE_FENETRE;i++){
			cartes[i] = new CarteG(p.getCarte(indexCartes[i]), positionCartes[i], f.getLargeur()/6);
			f.ajouter(cartes[i]);
			System.out.println(cartes[i].getCarte());
		}
	}
	
	private void selection(){
		for(int i=0;i<Csts.CARTE_FENETRE;i++){
			for(int j=0;j<Csts.SYMBOLES_CARTE;j++){
				if(souris.getClicGauche() && cartes[i].getSymboleG(j).intersection(souris.getPosition()))
					cartes[indexCartes[i]].selectionne(j);
			}
		}
	}
	
	private static void melangeCartes(int[] ar){
		Random rnd = ThreadLocalRandom.current();
			for (int i = ar.length - 1; i > 0; i--){
			int index = rnd.nextInt(i + 1);
			int a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}
	
	
	public void joue(){
		selection();
	}
}
