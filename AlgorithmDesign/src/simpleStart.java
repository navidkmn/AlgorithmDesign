import java.util.Scanner;
import java.util.Stack;

public class simpleStart {

	int base;

	public String convertion(int No) {
		
		Stack<Integer> s = new Stack<Integer>();
		String result = "";
		
		while (No != 0) {
			s.push(No % base);
			No /= base;
		}
		while (!s.isEmpty()) {
			int remainder = s.pop();
			if (remainder >= 10)
				result += (char) (65 + (remainder - 10));
			else
				result += Integer.toString(remainder);
		}
		return result;
	}
	
	public boolean isSimmetry(String s) {

		if (s.length() == 1)
			return true;

		if (s.length() == 2) {
			if (s.charAt(0) == s.charAt(1))
				return true;
			else
				return false;
		}
		
		String sub = s.substring(1, s.length()-1);
		boolean subBool = isSimmetry(sub);
		if(!subBool)
			return false;
		else{
			if(s.charAt(0) == s.charAt(s.length()-1))
				return true;
			else
				return false;
		}
			
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		simpleStart ss = new simpleStart();
		ss.base = scan.nextInt();

		for (int i = 1; i <= 300; i++) {
			int No = (int)Math.pow(i, 2);
			String result = ss.convertion(No);
			if(ss.isSimmetry(result))
				System.out.println(ss.convertion(i) +" "  + result);
		}
	}

}
