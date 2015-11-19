import java.awt.Image;

/**
 * Cette classe répresente un symbole dans une carte.
 * @see Carte
 * 
 * @version 1.0
 * @author Camille
 */
public class Symbole {
	
	/* Attributs */
		
		//TODO A supprimer à l'implémentation des images(Temporaire)
		private int temp;
		
		/**
		 * Le lien vers l'image du symbole.
		 * Peut être modifié.
		 * @see setLienImg(String str)
		 */
		private String lienImg;
		
		/**
		 * Image créée à partir du lien. 
		 * Sera modifiée si le lien est modifié.
		 * @see setLienImg(String str)
		 */
		private Image img;
		
		//TODO A supprimer à l'implémentation des images(Temporaire)
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
			//TODO créer l'image à partir du lien donné et gérer les exceptions
		}
		

		
		public Symbole(Symbole s) {
			//TODO Supprimer une fois l'implémentation des images faite
			this.temp = s.temp;
			
			this.lienImg = s.lienImg;
			this.img = s.img;
		}
	
	/* Accesseurs */
		
		/* GET */

			//TODO A supprimer à l'implémentation des images(Temporaire)
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
			
			//TODO A supprimer à l'implémentation des images(Temporaire)
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
				//TODO Instancier la nouvelle image à partir du lien et gérer les exceptions
			}
		
	/* Méthodes */
			
			/**
			 * Redéfinition de la méthode equals pour cette classe
			 * @param s Symbole
			 * 		Symbole à comparer
			 * @return boolean
			 * 		Si c'est egale ou non
			 */
			public boolean equals(Symbole s){
				return this.temp == s.temp;
				//TODO modifier pour les images
			}
			
			/**
			 * Redéfinition de la méthode toStriing.
			 * Retour la valeur du symbole
			 */
			public String toString(){
				return "Valeur temporaire : "+temp;
				//TODO modifier pour les images
			}
	
}
