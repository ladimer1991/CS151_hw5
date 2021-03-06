import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Connect4Controller implements ActionListener {
	static JButton b[][];
	CheckPosition a;
	private int size;
	private boolean player1;
	private boolean validMove;
	private boolean won;


	public Connect4Controller(int size, int win) {
		a = new CheckPosition(size, win);
		this.size = size; 
		b = new JButton[size][size];
		player1 = true;
	}
	
	public JPanel layout() {
		JPanel n = new JPanel(new GridLayout(size,size));
		int count = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				b[i][j]= new JButton("");
				b[i][j].setActionCommand("" + count);					
				b[i][j].addActionListener(this);
				n.add(b[i][j]);
				count++;
				}
			}
		return n;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String position = ae.getActionCommand();
		int pos = Integer.valueOf(position);
		dropPiece(pos);
	}
	
	
	private void dropPiece(int pos) {
		int row = (pos)/ size;
		int column = pos % size;
		
		int move = checkRow(row, column);
		if (validMove) {
			if (player1) {
				b[move][column].setText("A");
				player1 = false;
			} else {
				b[move][column].setText("B");
				player1 = true;
			}
		validMove = false;
		}
		a.add(move, column, player1);
		won = a.checkWinner();

	}
	
	private int checkRow(int row, int col) {
		int r = 0; 
		for (int i = 0; i < size; i++) {
			if (!b[i][col].getText().equals("A") && !b[i][col].getText().equals("B")) {
				r = i;
				validMove = true;
			}
		}
		return r;
	}
	
	
	public JPanel winner() {
		JPanel win = new JPanel(new FlowLayout());
		JLabel winner = new JLabel("");

//		if (won) {
			winner.setText("GAMEOVER? true");
	//	} else {
			winner.setText("GAMEOVER? false");
//		}
		
		win.add(winner);
		
		//TODO Change JLabel to winner
		
		return win;
	}
}
