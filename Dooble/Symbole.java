import java.awt.Image;

/**
 * Cette classe r�presente un symbole dans une carte.
 * @see Carte
 * 
 * @version 1.0
 * @author Camille
 */
public class Symbole {
	
	/* Attributs */
		
		//TODO A supprimer � l'impl�mentation des images(Temporaire)
		private int temp;
		
		/**
		 * Le lien vers l'image du symbole.
		 * Peut �tre modifi�.
		 * @see setLienImg(String str)
		 */
		private String lienImg;
		
		/**
		 * Image cr��e � partir du lien. 
		 * Sera modifi�e si le lien est modifi�.
		 * @see setLienImg(String str)
		 */
		private Image img;
		
		//TODO A supprimer � l'impl�mentation des images(Temporaire)
		public Symbole(int i) {
			temp = i;
		}
		
		/* Constructeur */
		
		/**
		 * Instanciera un symbole avec un lien vers une image(Internet ou sur le PC) 
		 * @param img String
		 * 		Lien vers l'image <strong>existante</strong>	
		 */
		public Symbole(String img){
			//TODO cr�er l'image � partir du lien donn� et g�rer les exceptions
		}
		

		
		public Symbole(Symbole s) {
			//TODO Supprimer une fois l'impl�mentation des images faite
			this.temp = s.temp;
			
			this.lienImg = s.lienImg;
			this.img = s.img;
		}
	
	/* Accesseurs */
		
		/* GET */

			//TODO A supprimer � l'impl�mentation des images(Temporaire)
			public int getTemp(){
				return temp;
			}
			
			/**
			 * Retourner le lien de l'image
			 * @return lienImg String
			 * 		Lien vers l'image du symbole
			 */
			public String getLienImg(){
				return lienImg;
			}
			
			/**
			 * Retourne l'instance l'Image du symbole
			 * @return img Image
			 * 		Inctance de l'Image
			 */
			public Image getImage(){
				return img;
			}
		
		/* SET */
			
			//TODO A supprimer � l'impl�mentation des images(Temporaire)
			public void setTemp(int t){
				temp = t;
			}
			
			/**
			 * Remplacera le lien de l'image et L'Image
			 * @param str
			 * 		Lien vers nouvelle image
			 */
			public void setLienImg(String str){
				lienImg = str;
				//TODO Instancier la nouvelle image � partir du lien et g�rer les exceptions
			}
		
	/* M�thodes */
			
			/**
			 * Red�finition de la m�thode equals pour cette classe
			 * @param s Symbole
			 * 		Symbole � comparer
			 * @return boolean
			 * 		Si c'est egale ou non
			 */
			public boolean equals(Symbole s){
				return this.temp == s.temp;
				//TODO modifier pour les images
			}
			
			/**
			 * Red�finition de la m�thode toStriing.
			 * Retour la valeur du symbole
			 */
			public String toString(){
				return "Valeur temporaire : "+temp;
				//TODO modifier pour les images
			}
	
}
