
public class CheckPosition {
	private int a[][];
	private int size;
	private int winner;
	private boolean won;

	public CheckPosition(int x, int y) {
		a = new int[x][x];
		size = x;
		winner = y;
		won = false;
	}
	
	public void add(int x, int y, boolean player) {
		int play = player?2:1;
		a[x][y] = play;
	}
	
	public boolean checkWinner() {
		checkWinRow();
		checkWinColumn();
		checkWinDiag();
		if (won) {
			System.out.println("Player won");
		}
		return won;
	}
	
	private void checkWinRow() {
		
		int count = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size-1; j++) {
				if (a[i][j] == a[i][j+1]) {
					if (a[i][j] != 0) {
						count++;
						if (count == winner-1) won = true;
					}
				}
			} 
			count = 0;
		}
		
	}
	
	private void checkWinColumn() {
		
		int count = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size-1; j++) {
				if (a[j][i] == a[j+1][i]) {
					if (a[j][i] != 0) {
						count++;
						if (count == winner-1) won = true;
					}
				}
			} 
			count = 0;
		}
				
	}
	
	private void checkWinDiag() {
		
		int countA, countB;
		
		// top-left to bottom-right - green diagonals
		for(int i = 0; i <= size - winner; i++){
		    countA = countB = 0;
		    int row, col;
		    for( row = i, col = 0; row < size && col < size; row++, col++ ){
		        if (a[row][col] == 1 || a[row][col] == 2) {
		        	if(a[row][col] == 1) countA++; 
		        	if(a[row][col] == 2) countB++;
		        	if(countA >= winner || countB >= winner)  won = true;
		        }  else {
		            countA = countB = 0;
		        }
		    }
		}
	
		for(int i = size-1; i >= winner-1; i--){	
		    countA = countB = 0;
		    int row, col;
		    for( row = i, col = 0; row >= winner-1 && col < size; row--, col++){
		        if (a[row][col] == 1 || a[row][col] == 2) {
		        	if(a[row][col] == 1) countA++; 
		        	if(a[row][col] == 2) countB++;
		        	if(countA >= winner || countB >= winner)  won = true;
		        }  else {
		            countA = countB = 0;
		        }
		    }
		} // end for
		
		// top-right to bottom-left 
		for(int  i = 1; i <= size-winner; i++){
		    countA = countB = 0;
		    int row, col;
		    for( row = size-1, col = i; row >= winner-1 && col < size; row--, col++) {
		        if (a[row][col] == 1 || a[row][col] == 2) {
		        	if(a[row][col] == 1) countA++;
		        	if(a[row][col] == 2) countB++;
		        	if(countA >= winner || countB >= winner) won = true;
		        }  else {
		            countA = countB = 0;
		        }
		    } // end for
		} // end for	

		
		// top-left to bottom-right - red diagonals
		for(int  i = 1; i <= size - winner; i++){
		    countA = countB = 0;
		    int row, col;
		    for( row = 0, col = i; row < size && col < size; row++, col++ ) {
		        if (a[row][col] == 1 || a[row][col] == 2) {
		        	if(a[row][col] == 1) countA++;
		        	if(a[row][col] == 2) countB++;
		        	if(countA >= winner || countB >= winner) won = true;
		        }  else {
		            countA = countB = 0;
		        }
		    } // end for
		} // end for

	} // end method
}
