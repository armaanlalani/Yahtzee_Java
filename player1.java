
public class player1 {
	
	int[][] Player = new int [2][13];
	int p1total = 0;
	int p2total = 0;
	
	public int getScore(int row, int column) {
		return Player[row][column];
	}
	
	public void addScore(int row, int column, int score) {
		Player[row][column] = score;
	}
	
	public int p1TotalScore() {
		for(int i = 0; i < Player[0].length; i ++) {
			p1total = p1total + Player[0][i];
		}
		return p1total;
	}
	
	public int p2TotalScore() {
		for(int i = 0; i < Player[1].length; i ++) {
			p2total = p2total + Player[1][i];
		}
		return p2total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
