import java.util.Scanner;

public class TA {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int maxTime = scan.nextInt();
		int quizs = scan.nextInt();
		
		int maxGrade = 0;

		int [] grades = new int [quizs];
		int [] times = new int [quizs];
		
		for (int i = 0; i < quizs; i++) {
			int grade = scan.nextInt();
			int time = scan.nextInt();
			grades[i] = grade;
			times[i] = time;
		}
		
		int leftTime = maxTime;
		boolean run = true;
		
		while(run){
			run = false;
			int maxTemp = 0;
			int quizNoTemp = -1;
			for(int i = 0 ; i < quizs ; i++){
				int calculate = (int)(leftTime / times[i])*(grades[i]);
				if(calculate > maxTemp){
						maxTemp = calculate;
						quizNoTemp = i;
						run = true;
				}
			}		
			if(run){
			maxGrade += grades[quizNoTemp];
			leftTime -= times[quizNoTemp];
			}
		}
		System.out.println(maxGrade);
	}
}
