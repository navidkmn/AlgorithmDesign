import java.util.Scanner;

public class abbreviation {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String line = scan.nextLine();
		String str = "";
		
		while(!line.equals(".")){
			str += line+" ";
			line = scan.nextLine();
		}
		String[] prim = str.split(" ");
		
		String word = "";
		
		while(scan.hasNext())
			word+= scan.next();

		int result = 0;
		boolean[] check = new boolean[word.length()+1];
		check[0] = true;
		
		for (int j = 1; j < word.length() + 1; j++) {
			for (int i = 0; i < prim.length; i++){
				if (prim[i].length() <= j) {
					if (word.substring(j - prim[i].length(), j).equals(prim[i]) && check[j - prim[i].length()]){
						check[j] = true;
						result = j;
					}
				}
			}
		}
		System.out.println(result);
	}
}
