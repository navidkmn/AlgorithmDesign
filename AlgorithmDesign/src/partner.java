import java.util.Scanner;

public class partner {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int relationNo = scan.nextInt();
		int[][] relations = new int[relationNo][3];
		
		int max= 0;
		
		for(int i = 0 ; i < relationNo ; i++){
			relations[i][0] = scan.nextInt();
			relations[i][1] = scan.nextInt();
			relations[i][2] = scan.nextInt();
			max= Math.max(max, Math.max(relations[i][0], relations[i][1]));
		}
		
		int[][] fTable = new int[max+1][max+1];
		int[][] sTable = new int[max+1][max+1];
		
		for (int i = 0; i <= max; i++)
			for (int j = 0; j <= max; j++) {
				fTable[i][j] = 0;
				sTable[i][j] = 0;
			}
		
		for (int i = 0; i < relationNo; i++){
			fTable[relations[i][0]][relations[i][1]] = relations[i][2];
			sTable[relations[i][0]][relations[i][1]] = relations[i][2];
		}
		
		for (int t = 0; t <= max; t++) {
			for (int i = 0; i <= max; i++)
				for (int j = 0; j <= max; j++) {
					if (fTable[i][j] > 50)
						for (int k = 0; k <= max; k++) {
							sTable[i][k] += fTable[j][k];
						}
				}
			for (int i = 0; i <= max; i++) {
				for (int j = 0; j <= max; j++) {
					if (sTable[i][j] > 50)
						fTable[i][j] = sTable[i][j];
					sTable[i][j] = 0;
				}
			}
			for (int i = 0; i < relationNo; i++){
				sTable[relations[i][0]][relations[i][1]] = relations[i][2];
			}
		}

		for (int i = 0; i <= max; i++)
			for (int j = 0; j <= max; j++) {
				if(fTable[i][j] >50 && i!=j)  
					System.out.println(i + " "+ j);
			}
	}
}