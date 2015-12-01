import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Cette classe repr�sente un paquet de cartes.
 * Le contenu des cartes est d�termin� dans cette classe.
 * Il devra resp�cter les r�gles du jeu Dooble.
 * 
 * @author Camille
 * @version 1.0
 */
public class Paquet{
	
	/* Attributs */
	
	/**
	 * Instanciation des cartes dans le paquet.
	 * @see Carte
	 * Pourra �tre modifi�
	 * @see setCarte(int i, Carte c)
	 */
	private Carte cartes[];
	private int matriceSymboles[][];
	
	/* Constructeur */
	
	/**
	 * Instanciera les cartes et leur contenu
	 */
	public Paquet(){
		cartes = new Carte[Csts.NB_CARTES];
		
		/*for(int i=0;i<Csts.NB_CARTES;i++){
			int[] c = {0,1,2,3,4,5,6,7};
			cartes[i] = new Carte(i,c);
		}*/
		creationSymboles();
		InitCartes();
		
	}
	
	/* Accesseur */
	
		/* GET */
			
			/**
			 * Retourne une carte du paquet avec un indice donn�
			 * @param i int
			 * 		indice de la carte � retourner
			 * @return Carte
			 * 		Carte retourn�e
			 */
			public Carte getCarte(int i){
				return cartes[i];
			}
	
		/* SET */
			
			/**
			 * Change une carte du paquer en une autre carte avec un indice donn�
			 * @param i int
			 * 		indice de la carte � changer
			 * @param c
			 * 		Nouvelle carte
			 */
			public void setCarte(int i, Carte c){
				cartes[i] = new Carte(c);
			}
	
	/* M�thode */
	
	/**
	 * Red�finition de la m�thode toString pour d�crire le paquet
	 */
	public String toString(){
		String str = new String("");
		
		for(int i=0;i<Csts.NB_CARTES;i++){
			str += cartes[i].toString()+"\n";
		}
		
		return str;
	}
	
	/**
	 * M�lange un tableau d'entiers donn�
	 * @param ar int[]
	 * 		Tableau d'entier � m�langer
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
	
	private void InitCartes(){
		for(int i =0;i<Csts.NB_CARTES;i++){
			cartes[i] = new Carte(i, matriceSymboles[i]);
		}
	}
	
	private void creationSymboles(){
			/* Symboles 0 - 7 */
				for(int i=0;i<8;i++){
					for(int j = 0;j<7;j++){
						matriceSymboles[i*7+j][j] = i;
					}
				}
			
			
			/* Symboles 8 - 14 */
				for(int b=0;b<7;b++){
					int j=0;
					for(int i=8;i<15;i++){
						matriceSymboles[b*7+i][j] = i;
						j++;
					}
				}
			
			
			/* Symboles 15 - 21 */
				int i=15;
				for(int b=0;b<7;b++){
					for(int j=0;j<7;j++){
						matriceSymboles[7*b+j][j] = i;
						if(j<6)
							i++;
						else{//TODO a voir
							if(i==22)
								i=15;
						}
					}
				}
						
			/* Symboles 22 - 28 */
				i=22;
				for(int b=0;b<7;b++){
					for(int j=0;j<7;j++){
						matriceSymboles[7*b+j][j] = i;
						if(j==7)
							i--;
						else{
							i++;
							if(i==29)
								i=22;
						}
					}
				}
			
			
			/* Symboles 29 - 35 */
				i=29;
				for(int b=0;b<7;b++){
					for(int j=0;j<7;j++){
						matriceSymboles[7*b+j][j] = i;
						if(j==7)
							i-=2;
						else{
							i++;
							if(i==36)
								i-=7;
						}
						if(i<29)
							i+=7;
					}
				}
		}
}