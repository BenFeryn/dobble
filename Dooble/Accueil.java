import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Accueil extends JFrame{
	
	private JButton play, leave, scoreboard;
	private JPanel mainPanel, logoPanel, buttonPanel;
	private JLabel logo;
	
	public Accueil(){
		super("Dobble - Menu");
		
		play =  new JButton("Jouer !");
		play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e1) {
				Jeu j = new Jeu();
				setVisible(false);
				
				while(true){
					try {
						Thread.sleep(1);
					} catch (InterruptedException e2) {
						e2.printStackTrace();
					}
					
					j.joue();
				}
			}
		});
		
		leave = new JButton("Quitter");
		leave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);	
			}
		});
		
		scoreboard = new JButton("Tableau des scores");
		scoreboard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("[!] Just do it !");
			}
		});
		
		buttonPanel = new JPanel(new FlowLayout());
		buttonPanel.add(play);buttonPanel.add(scoreboard);buttonPanel.add(leave);
		
		mainPanel = new JPanel();
		mainPanel.add(buttonPanel,BorderLayout.NORTH);
		
		getContentPane().add(mainPanel);
		
		pack();
		setVisible(true);
	}
	
}
