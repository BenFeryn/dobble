public class Main {

	public static void main(String[] args) {
		
		Jeu j = new Jeu();
		
		while(true){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			j.joue();
		}
	}
}
