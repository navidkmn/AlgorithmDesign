import java.util.ArrayList;
import java.util.Scanner;

public class schedule {

	public static void main(String[] args) {
		Scanner scan =  new Scanner(System.in);
		int activityNo = scan.nextInt();
		int [] startTime = new int[activityNo];
		int [] finishTime = new int[activityNo];
		ArrayList<Integer> choosenActivities = new ArrayList<Integer>();
		
		for(int i = 0 ; i < activityNo ; i++)
			startTime[i] = scan.nextInt();
		
		for(int i = 0 ; i < activityNo ; i++)
			finishTime[i] = scan.nextInt();
		
		choosenActivities.add(0);
		int lastActivity = 0;
		
		for(int i = 1 ; i < activityNo ; i++)
			if(startTime[i] >= finishTime[lastActivity]){
				choosenActivities.add(i);
				lastActivity = i;
			}
		
		for(int i = 0 ; i < choosenActivities.size() ; i++)
			System.out.print(choosenActivities.get(i) + " ");
	}
}
