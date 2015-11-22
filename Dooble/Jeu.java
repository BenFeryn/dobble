import java.awt.Point;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe représentant le mode de jeu basique.
 * Deux cartes à l'écran, d'un côté la carte du joueur et de l'autre le reste du paquet.
 * Si le joueur trouve le symbole en commun entre sa carte et celle au dessus du paquet alors la carte du paquet vient se placer et dessus de sa carte
 * Et une nouvelle carte apparait sur le paquet
 * Les cartes sont toutes dans le désordre
 * Le joueur devra selectionner les symboles en commun sur les <strong>DEUX CARTES</strong> pour valider son coup
 * 
 * @author Camille
 * @version 1.0
 */
public class Jeu {

	private static Fenetre  f;
	private static Paquet p;
	private static Souris souris;
	
	/**
	 * Cartes affichées à l'écran
	 */
	private CarteG cartes[];
	
	/**
	 * Index des cartes, utilisé pour le mélange
	 */
	private int indexCartes[];
	
	/**
	 * Point qui seront utilisés pour positionner les cartes sur l'écran
	 */
	private Point positionCartes[];
	
	/**
	 * Index commun poour cibler le tableau mélangé
	 * Il cible la prochaine carte à afficher
	 */
	private int index;
	
	/**
	 * Génére un Paquet de carte, la fenêtre de jeu, la souris, les point où se trouveront les cartes, mélange les cartes et place les deux premières
	 */
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
	
		index = -1;
		initialisationIndexCartes();
		initialiseCartes();
	}
	
	/**
	 * Crée un tableau d'entier qui sera un tableau d'index pour les cartes
	 * Ce tableau sera mélanger par une aure méthode
	 * @see melanCarte(int[] ar)
	 */
	private void initialisationIndexCartes(){
		indexCartes = new int[Csts.NB_CARTES];
		for(int i=0;i<Csts.NB_CARTES;i++){
			indexCartes[i] = i;
		}
		melangeCartes(indexCartes);
		for(int i=0;i<indexCartes.length;i++)
			System.out.print(indexCartes[i]+" ");
		System.out.println();
	}
	
	/**
	 * Mélange un tableau d'entiers donné
	 * @param ar int[]
	 * 		Tableau d'entier à mélanger
	 */
	private static void melangeCartes(int[] ar){
		Random rnd = ThreadLocalRandom.current();
		for (int i = ar.length - 1; i > 0; i--){
			int index = rnd.nextInt(i + 1);
			int a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}
	
	/**
	 * Initiaise les deux première cartes du jeu
	 * Cette méthode n'est appelée qu'une seule fois dans le constructeur
	 */
	private void initialiseCartes(){
		for(int i=0;i<Csts.CARTE_FENETRE;i++){
			index++;
			cartes[i] = new CarteG(p.getCarte(indexCartes[i]), positionCartes[i], f.getLargeur()/6);
			f.ajouter(cartes[i]);
			// TODO à supprimer
			//System.out.println(cartes[i].getCarte());
		}
	}
	
	/**
	 * Méthode appelée constamment par la méthode joue pour selectionner les symbole s'il le faut
	 * @see joue()
	 */
	private void selection(){
		if(souris.getClicGauche()){
			for(int i=0;i<Csts.CARTE_FENETRE;i++){
				for(int j=0;j<Csts.SYMBOLES_CARTE;j++){
					if(cartes[i].getSymboleG(j).intersection(souris.getPosition())){
						System.out.println("[!] Selection du symbole "+cartes[i].getSymboleG(j).getSymbole().getValeurSymbole()+" de la carte "+(i+1)+"("+cartes[i].getCarte().getId()+")");
						cartes[i].selectionne(j);
					}
				}
			}
		}
	}
	
	/**
	 * Méthode appelée constamment par le Main pour faire avancer le jeu
	 */
	public void joue(){
		selection();
		if(cartes[0].getSelectionne() && cartes[1].getSelectionne()){
			System.out.println("[!] ça compare");
			if(cartes[0].getSymboleSelectionne().equals(cartes[1].getSymboleSelectionne())){
				bonnePaire();
			}else{
				mauvaisePaire();
			}
		}
	}

	/**
	 * Méthode appelé quand une paire de symbole est trouvée par le joueur
	 */
	private void bonnePaire() {
		System.out.println("Nice ! GG.");
		for(int i=0;i<Csts.CARTE_FENETRE;i++){
			cartes[i].setSelectionne(false);
			cartes[i].getSymboleSelectionne().setSelectionne(false);
		}
		nouvelleCartePaquet();
	}

	/**
	 * Méthode appelé quand le joueur selectionne une fausse paire
	 */
	private void mauvaisePaire() {
		System.out.println("Kappa.");
		for(int i=0;i<Csts.CARTE_FENETRE;i++){
			cartes[i].getSymboleSelectionne().setSelectionne(false);
			cartes[i].setSelectionne(false);
		}
	}

	/**
	 * Méthode qui ramère le carte du paquet sur le tas du joueur et affiche la nouvelle carte du paquet
	 */
	private void nouvelleCartePaquet() {
		for(int i=0;i<Csts.CARTE_FENETRE;i++){
			for(int j=0;j<Csts.SYMBOLES_CARTE;j++){
				f.supprimer(cartes[i].getSymboleG(j));
				f.repaint();
			}
			f.supprimer(cartes[i]);
			cartes[i] = new CarteG(p.getCarte(indexCartes[index+i]), positionCartes[i], cartes[i].getRayon());
			f.ajouter(cartes[i]);
		}
		index++;
	}
}
