import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Connect4GUI extends JFrame  {
	private int size;
	Connect4Controller control;
	
	public Connect4GUI(int bsize, int win) {
		size = bsize;
		control = new Connect4Controller(bsize, win);
		showGUI();
	}


	private void showGUI() {

		JFrame theFrame = new JFrame("Connect 4");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setLayout(new BorderLayout());
		
//		JPanel title = new JPanel(new GridLayout(1,size));

		JPanel gamePane = control.layout();

                
        JPanel winner = control.winner();
        
                        
//		theFrame.add(title,BorderLayout.NORTH);
		theFrame.add(gamePane, BorderLayout.CENTER);
		theFrame.add(winner, BorderLayout.SOUTH);
		theFrame.pack();
		theFrame.setVisible(true);	
	
	}
	
	
}
