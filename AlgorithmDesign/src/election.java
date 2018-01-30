import java.util.Scanner;
import java.util.Vector;

public class election {

		public static void main(String[] args) {
			
			int finalDistance = 0;
			
			int number;
			int [][] graph;
			int minEdge = Integer.MAX_VALUE;
			int sourceVertex = -1;
			int destinationVertex = -1;
			
			Vector<Integer> white = new Vector<Integer>();
			Vector<Integer> black = new Vector<Integer>();
			
			Scanner scan = new Scanner(System.in);
			
			number = scan.nextInt();
			graph = new int [number][number];
			
			for(int i = 0 ; i < number ; i++)
				white.add(i);
			
			for(int i = 0 ; i < number ; i++)
				for(int j = 0 ; j < number ; j++){
					int distance = scan.nextInt();
					graph [i][j] = distance;
					if(distance != 0 && distance < minEdge){
						minEdge = distance;
						sourceVertex = i;
						destinationVertex = j;
					}
				}
			
			finalDistance += minEdge;
			
			white.removeElement(sourceVertex);
			white.removeElement(destinationVertex);
			black.add(sourceVertex);
			black.add(destinationVertex);
			
			while(!white.isEmpty()){
				
				int minTemp = Integer.MAX_VALUE;
				int sourceTemp = -1;
				int destinationTemp = -1;
				
				for(int i = 0 ; i < black.size() ; i++)
					for(int k = 0 ; k < number ; k++){
						if(graph[black.elementAt(i)][k] != 0 && graph[black.elementAt(i)][k] < minTemp && !black.contains(k)){
							minTemp = graph[black.elementAt(i)][k];
							destinationTemp = k;
						}
					}
				
				finalDistance += minTemp;
				white.removeElement(destinationTemp);
				black.add(destinationTemp);
			}
			
			System.out.println(finalDistance);
		}
}
