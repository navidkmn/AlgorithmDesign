import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class dogHouse {
	
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		int[][] graph;
		double[][] distance;
		int[][] position;
		boolean [] check;
		
		double min = Double.MAX_VALUE;
		double maxInDistance = 0;
		
//		ArrayList<Integer> firstSection = new ArrayList<Integer>();
//		ArrayList<Integer> secondSection = new ArrayList<Integer>();
//		Stack<Integer> connection = new Stack<Integer>();
		
		int size = scan.nextInt();
		graph = new int[size][size];
		distance = new double[size][size];
		position = new int[size][2];
		
		check = new boolean[size];
		for(int i = 0 ; i < size ; i++)
			check[i] = false;
		
		for (int i = 0; i < size; i++) {
			position[i][0] = scan.nextInt();
			position[i][1] = scan.nextInt();
		}
		
		for(int i = 0  ; i < size ; i++){
			String line = scan.next();
			for(int j = 0 ; j < line.length() ; j++)
				graph[i][j] = Integer.parseInt(line.substring(j, j+1));
		}
		
		for(int i = 0 ; i < size ; i++)
			for(int j = 0 ; j < size ; j++){
				if(i == j)
					distance[i][j] = 0;
				else{
					if(graph[i][j] == 1)
						distance[i][j] = Math.sqrt(Math.pow(position[i][0] - position[j][0], 2) + Math.pow(position[i][1] - position[j][1], 2));
					else
						distance[i][j] = Double.MAX_VALUE;
				}
			}
		
//		connection.push(0);
//		check[0] = true;
//		firstSection.add(0);
//		
//		while(!connection.isEmpty()){
//			int next = connection.pop();
//			for(int i = 0 ; i < size ; i++)
//				if(graph[next][i] == 1 && !check[i]){
//					connection.push(i);
//					check[i]= true;
//					firstSection.add(i);
//				}
//		}
//		
//		for(int i = 0 ; i < size ;i++)
//			if(!check[i])
//				secondSection.add(i);
		
		for (int x = 0; x < size; x++) 
			for (int y = 0; y < size; y++) 
				for (int z = 0; z < size; z++) 
					distance[y][z] = Math.min(distance[y][z], distance[y][x] + distance[x][z]);
		
		for (int x = 0; x < size; x++) 
			for (int y = 0; y < size; y++) 
				if(distance[x][y] != Double.MAX_VALUE)
					maxInDistance = Math.max(maxInDistance, distance[x][y]);
				
		for(int i = 0 ; i < size ; i++)
			for(int j = 0 ; j < size ; j++){
				if(distance[i][j] == Double.MAX_VALUE){
				
				double maxPerConnection = 0;
				double no = 0;

				for(int k = 0 ; k < size ;k++)
					if(distance[i][k] != Double.MAX_VALUE)
						no = Math.max(no, distance[i][k]);
				
				maxPerConnection+= no;
				no = 0;
				
				for(int k = 0 ; k < size ;k++)
					if(distance[j][k] != Double.MAX_VALUE)
						no = Math.max(no, distance[j][k]);
				
				maxPerConnection+= no;
				maxPerConnection+=  Math.sqrt(Math.pow(position[i][0] - position[j][0], 2) + Math.pow(position[i][1] - position[j][1], 2));

				min = Math.min(maxPerConnection, min);
			}
		}
		System.out.printf("%.6f", Math.max(maxInDistance, min));
	}
}
