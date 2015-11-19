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
	
	/* Constructeur */
	
	/**
	 * Instanciera les cartes et leur contenu
	 */
	public Paquet(){
		cartes = new Carte[Csts.NB_CARTES];
		
		for(int i=0;i<Csts.NB_CARTES;i++){
			int[] c = {i,i+1,i+2,i+3,i+4,i+5,i+6,i+7};
			cartes[i] = new Carte(i,c);
		}
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
}