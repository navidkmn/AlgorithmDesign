import java.util.Arrays;
import java.util.Scanner;

public class permutation {

	int clerksNo;
	int[][] timeTable;
	int[] tempActivityPosition;
	int[] finalActivityPosition;
	int minCost;

	public boolean promising(int i, int k) {
		
		for(int x = 0 ; x < i ; x++)
			if(tempActivityPosition[x] == k)
				return false;
		
		int tempCost = 0;
		for (int j = 0; j < i; j++)
			tempCost += timeTable[j][tempActivityPosition[j]];
		tempCost += timeTable[i][k];
		
		if (tempCost >= minCost)
			return false;
		
		return true;
	}

	public void permute(int i) {
		if (i == clerksNo) {
			int tempCost = 0;
			for (int k = 0; k < clerksNo; k++)
				tempCost += timeTable[k][tempActivityPosition[k]];
			minCost = tempCost;
			finalActivityPosition = tempActivityPosition.clone();
		
		}
		else{
		for (int k = 0; k < clerksNo; k++)
			if (promising(i, k)) {
				tempActivityPosition[i] = k;
				permute(i + 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		permutation p = new permutation();

		p.clerksNo = scan.nextInt();
		p.timeTable = new int[p.clerksNo][p.clerksNo];
		p.tempActivityPosition = new int[p.clerksNo];
		p.finalActivityPosition = new int[p.clerksNo];

		
		for (int i = 0; i < p.clerksNo; i++)
			for (int j = 0; j < p.clerksNo; j++)
				p.timeTable[i][j] = scan.nextInt();

		p.minCost = Integer.MAX_VALUE;

		p.permute(0);
		
		for(int i = 0 ; i < p.clerksNo ;i++)
			System.out.println(p.finalActivityPosition[i]);
	}
}
