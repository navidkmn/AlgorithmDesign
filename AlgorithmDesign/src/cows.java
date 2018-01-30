import java.util.Scanner;

public class cows {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		final int vertexes = 52;

		int[][] graph = new int[vertexes][vertexes];

		for (int i = 0; i < vertexes; i++)
			for (int j = 0; j < vertexes; j++){
				if(i != j)
					graph[i][j] = 1000000;
				else
					graph[i][j] = 0;
			}

		boolean[] isBlack = new boolean[vertexes];
		int[] nearest = new int[vertexes];
		int[] distance = new int[vertexes];

		int linksNo = scan.nextInt();

		for (int i = 0; i < linksNo; i++) {

			String source = scan.next();
			String dest = scan.next();
			String length = scan.next();

			int x = 0;
			int y = 0;

			if ((int) source.charAt(0) >= 65 && (int) source.charAt(0) <= 89)
				x = (int) source.charAt(0) - 64;
			else {
				if ((int) source.charAt(0) == 90)
					x = 0;
				else if ((int) source.charAt(0) >= 97 && (int) source.charAt(0) <= 122)
					x = (int) source.charAt(0) - 71;
			}

			if ((int) dest.charAt(0) >= 65 && (int) dest.charAt(0) <= 89)
				y = (int) dest.charAt(0) - 64;
			else {
				if ((int) dest.charAt(0) == 90)
					y = 0;
				else if ((int) dest.charAt(0) >= 97 && (int) dest.charAt(0) <= 122)
					y = (int) dest.charAt(0) - 71;
			}

			graph[x][y] = Math.min(graph[x][y], Integer.parseInt(length));
			graph[y][x] = Math.min(graph[x][y], Integer.parseInt(length));
		}

		isBlack[0] = true; // "Z"

		for (int i = 1; i < vertexes; i++) {
			nearest[i] = 0;
			distance[i] = graph[i][0];
			isBlack[i] = false;
		}

		int no = 0;

		while (no < vertexes - 1) {
			int tempMin = 100000;
			int vNear = 0;

			for (int i = 1; i < vertexes; i++) {
				if (isBlack[i] == false)
					if (distance[i] < tempMin) {
						tempMin = distance[i];
						vNear = i;
					}
			}
				isBlack[vNear] = true;
				no++;

			for (int i = 1; i < vertexes; i++) {
				if (isBlack[i] == false)
					if (graph[vNear][i] + distance[vNear] < distance[i]) {
						distance[i] = graph[vNear][i] + distance[vNear];
						nearest[i] = vNear;
					}
			}
		}
		int min = Integer.MAX_VALUE;
		int vertex = 0;
		for (int i = 1; i <= 25; i++) {
			if(distance[i] < min){
				min = distance[i];
				vertex = i + 64;
			}
			}
		System.out.println((char)vertex + " " + min);
	}
}
