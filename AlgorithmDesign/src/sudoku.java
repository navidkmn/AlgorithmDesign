import java.util.Scanner;

public class sudoku {

	int[][] sudokuTable;
	final int sudokuSize = 9;

	public boolean isFull() {
		int[] position = findZeroPosition();
		int x = position[0];
		int y = position[1];
		
		if(x == -1 && y == -1)
			return true;
		
		for(int k = 1 ; k <= sudokuSize ; k++){
			if(isPromising(x, y, k)){
				sudokuTable[x][y] = k;
				
				if(isFull())
					return true;
				
				sudokuTable[x][y] = 0;
			}
		}
		
		return false;
	}
	
	public int[] findZeroPosition(){
		for(int i = 0 ; i < sudokuSize ; i++)
			for(int j = 0 ; j < sudokuSize ; j++)
				if(sudokuTable[i][j] == 0){
					return new int[] {i , j};
				}
		return new int[] {-1,-1};
	}

	public boolean isPromising(int i, int j, int k) {
		for (int x = 0; x < sudokuSize; x++)
			if (sudokuTable[x][j] == k)
				return false;
		for (int y = 0; y < sudokuSize; y++)
			if (sudokuTable[i][y] == k)
				return false;

		for (int x = (3 * (i / 3)); x < (3 * (i / 3)) + 3; x++)
			for (int y = (3 * (j / 3)); y < (3 * (j / 3)) + 3; y++)
				if (sudokuTable[x][y] == k)
					return false;

		return true;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		sudoku s = new sudoku();
		s.sudokuTable = new int[s.sudokuSize][s.sudokuSize];

		for (int i = 0; i < s.sudokuSize; i++)
			for (int j = 0; j < s.sudokuSize; j++)
				s.sudokuTable[i][j] = scan.nextInt();

		if (s.isFull()) {
			for (int i = 0; i < s.sudokuSize; i++) {
				for (int j = 0; j < s.sudokuSize; j++)
					System.out.print(s.sudokuTable[i][j] + " ");
				System.out.println();
			}
		}
	}
}
