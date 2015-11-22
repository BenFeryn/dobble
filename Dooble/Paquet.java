import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Cette classe représente un paquet de cartes.
 * Le contenu des cartes est déterminé dans cette classe.
 * Il devra respécter les régles du jeu Dooble.
 * 
 * @author Camille
 * @version 1.0
 */
public class Paquet{
	
	/* Attributs */
	
	/**
	 * Instanciation des cartes dans le paquet.
	 * @see Carte
	 * Pourra être modifié
	 * @see setCarte(int i, Carte c)
	 */
	private Carte cartes[];
	
	/* Constructeur */
	
	/**
	 * Instanciera les cartes et leur contenu
	 */
	public Paquet(){
		cartes = new Carte[Csts.NB_CARTES];
		
		for(int i=0;i<Csts.NB_CARTES;i++){
			int[] c = {0,1,2,3,4,5,6,7};
			melangeSymbole(c);
			cartes[i] = new Carte(i,c);
		}
	}
	
	/* Accesseur */
	
		/* GET */
			
			/**
			 * Retourne une carte du paquet avec un indice donné
			 * @param i int
			 * 		indice de la carte à retourner
			 * @return Carte
			 * 		Carte retournée
			 */
			public Carte getCarte(int i){
				return cartes[i];
			}
	
		/* SET */
			
			/**
			 * Change une carte du paquer en une autre carte avec un indice donné
			 * @param i int
			 * 		indice de la carte à changer
			 * @param c
			 * 		Nouvelle carte
			 */
			public void setCarte(int i, Carte c){
				cartes[i] = new Carte(c);
			}
	
	/* Méthode */
	
	/**
	 * Redéfinition de la méthode toString pour décrire le paquet
	 */
	public String toString(){
		String str = new String("");
		
		for(int i=0;i<Csts.NB_CARTES;i++){
			str += cartes[i].toString()+"\n";
		}
		
		return str;
	}
	
	/**
	 * Mélange un tableau d'entiers donné
	 * @param ar int[]
	 * 		Tableau d'entier à mélanger
	 */
	private static void melangeSymbole(int[] ar){
		Random rnd = ThreadLocalRandom.current();
		for (int i = ar.length - 1; i > 0; i--){
			int index = rnd.nextInt(i + 1);
			int a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		}
	}
}