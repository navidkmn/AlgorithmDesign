import java.util.Scanner;

public class coins {
	
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		int coinNo = scan.nextInt();
		int sum = scan.nextInt();
		
		int[] value = new int[coinNo];
		int[] result = new int[sum+1];

		for(int i = 0 ; i < coinNo ; i++)
			value[i] = scan.nextInt();
		
		for (int i = 0; i < result.length; i++) 
			result[i] = 0;
		result[0]=1;
		
		for(int i = 0 ; i < coinNo ; i++)
			for(int j = value[i] ; j <= sum ; j++){
				result[j] += result[j - value[i]];
				result[j] %= 1000000;
			}
		System.out.println(result[result.length - 1]);
	}
}