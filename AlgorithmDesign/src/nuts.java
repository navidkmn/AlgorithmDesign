import java.util.Scanner;

public class nuts {

	int size;
	int[] array;
	int first,last;
	
	int findFirst(int[] array, int left , int right , int No){
		if(left > right)
			return -1;
		if (left == right)
			if(array[left] == No)
				return left;
			else
				return -1;
		int mid = (right + left)/2;
		if(array[mid] >= No)
			return findFirst(array , left , mid , No);
		else
			return findFirst(array, mid+1, right, No);
	}
	
	int findLast(int[] array, int left , int right , int No){
		if(left > right)
			return -1;
		if (left == right)
			if(array[left] == No)
				return left;
			else
				return -1;
		int mid = (right + left)/2 +1;
		if(array[mid] <= No)
			return findLast(array , mid , right , No);
		else
			return findLast(array, left, mid-1, No);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		nuts n = new nuts();
		n.size = scan.nextInt();
		n.array = new int[n.size];
		for(int i = 0 ; i < n.array.length; i++)
			n.array[i] = scan.nextInt();
		
		for(int i = 1 ; i <= 100 ; i++){
			n.first = n.findFirst(n.array, 0, n.size-1, i);
			//System.out.println(n.first + " " + i+ " FIRST");
			if(n.first != -1){
				 n.last = n.findLast(n.array, 0, n.size-1, i);
				 //System.out.println(n.last + " " + i+ " Last");
				 System.out.println(n.last - n.first + 1);
			}
			}
	}
}
