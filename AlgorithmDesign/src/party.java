import java.util.Scanner;
import java.util.Vector;

public class party {
	
	public static boolean checkCorrection(int flag , String no ,int[] conditions ,String[] result){
		if(flag == -1)
			return true;
		else{
			for(int i = 0 ; i<= flag ; i++){
				if(!result[conditions[i] -1].equals(no))
					return false;
			}
			return true;
		}
}

	public static int convert(String[] input){
		int no = 0;
		for(int i = 0 ; i < input.length ; i++){
			if(input[i].equals("1"))
				no += Math.pow(2, input.length - 1 - i);
		}
		return no;
	}
	
	public static boolean check(String[] first , String[] second){
		int firstInt = 0;
		int secondInt = 0;
		for(int i = 0 ; i < first.length ; i++){
			if(first[i].equals("1"))
				firstInt += Math.pow(2, first.length - 1 - i);
			if(second[i].equals("1"))
				secondInt += Math.pow(2, second.length - 1 - i);
		}
		if(firstInt == secondInt)
			return true;
		else
			return  false;
	}
	
	public static String[] key1(String []lamps){
		String[] newLamps = new String[lamps.length];
		int newFlag = 0;
		for(int i = 0 ; i < lamps.length ;i++)
			if(lamps[i].equals("1"))
				newLamps[newFlag++] = "0";
			else
				newLamps[newFlag++] = "1";
		return newLamps;
	}
	
	public static String[] key2(String[] lamps) {
		String[] newLamps = new String[lamps.length];
		int newFlag = 0;
		for (int i = 0; i < lamps.length; i++) {
			if ((i+1) % 2 != 0) {
				if (lamps[i] == "1")
					newLamps[newFlag++]= "0";
				else
					newLamps [newFlag++]= "1";
			}
			else
				newLamps [newFlag++]= lamps[i];
		}
		return newLamps;
	}
	
	public static String[] key3(String[] lamps) {
		String[] newLamps = new String[lamps.length];
		int newFlag = 0;
		for (int i = 0; i < lamps.length; i++) {
			if ((i+1) % 2 == 0) {
				if (lamps[i] == "1")
					newLamps[newFlag++]= "0";
				else
					newLamps [newFlag++]= "1";
			}
			else
				newLamps [newFlag++]= lamps[i];
		}
		return newLamps;
	}

	public static String[] key4(String[] lamps) {
		String[] newLamps = new String[lamps.length];
		int newFlag = 0;
		for (int i = 0; i < lamps.length; i++) {
			if ((i+1) % 3 == 1) {
				if (lamps[i] == "1")
					newLamps[newFlag++]= "0";
				else
					newLamps [newFlag++]= "1";
			}
			else
				newLamps [newFlag++]= lamps[i];
		}
		return newLamps;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Vector<String[]> status = new Vector<String[]>();
		Vector<String[]> help  = new Vector<String[]>();
		
		int lampNo = scan.nextInt();
		int counter = scan.nextInt();
		
		String[] firstStatus = new String[lampNo];
		for(int i = 0 ; i < firstStatus.length ; i++)
			firstStatus[i] = "1";
		
		status.addElement(firstStatus);

		int[] on = new int[lampNo];
		int[] off = new int[lampNo];

		int lightOn = scan.nextInt();
		int onFlag = -1;
		while(lightOn != -1){
			on[++onFlag] = lightOn;
			lightOn = scan.nextInt();
		}

		int lightOff = scan.nextInt();
		int offFlag = -1;
		while(lightOff != -1){
			off[++offFlag] = lightOff;
			lightOff = scan.nextInt();
		}

		for(int i = 0 ; i < counter ; i++){
			if(status.size() !=0){
				help = (Vector<String[]>) status.clone();
				status.clear();
				for(int k = 0 ; k < help.size() ; k++){
					
					String[] first = key1(help.elementAt(k));
					String[] second = key2(help.elementAt(k));
					String[] third = key3(help.elementAt(k));
					String[] forth = key4(help.elementAt(k));
					
					if(status.isEmpty())
						status.addElement(first);
					else {
						boolean flag1 = true;
						for (int t = 0; t < status.size(); t++) {
							if (check(first, status.elementAt(t))){
								flag1 = false;
								break;
							}
						}
						if (flag1)
							status.addElement(first);
					}
					
					boolean flag2 = true;
					for(int t = 0 ; t < status.size() ; t++){
						if(check(second, status.elementAt(t)))
							flag2 = false;
					}
					if(flag2)
						status.addElement(second);

					boolean flag3 = true;
					for(int t = 0 ; t < status.size() ; t++){
							if(check(third, status.elementAt(t)))
								flag3 = false;
					}
					if(flag3)
						status.addElement(third);

					boolean flag4 = true;
					for(int t = 0 ; t < status.size() ; t++){
						if(check(forth, status.elementAt(t)))
							flag4 = false;
					}
					if(flag4)
						status.addElement(forth);				
				}
			}
		}
		
		for(int i = 0 ; i < status.size() ; i++){
			for(int k =0 ; k < status.elementAt(0).length ; k++)
				System.out.print(status.elementAt(i)[k]);
			System.out.println();
		}
		
		help = (Vector<String[]>) status.clone();
		status.clear();
		
		for(int i = 0 ; i < help.size() ;i++){
			String[] result = help.elementAt(i);
			if(checkCorrection(onFlag, "1", on, result) && checkCorrection(	offFlag, "0", off, result)){
					if(status.isEmpty())
						status.addElement(result);
					else{
						int size = status.size();
						for(int h = 0 ; h < size; h++){
							if(h != size -1){
								if(convert(result) > convert(status.elementAt(h)) && convert(result) < convert(status.elementAt(h + 1))){
									status.add(h+1, result);
									break;
								}
							}
							else{
								if(convert(result) > convert(status.elementAt(h))){
									status.addElement(result);
									break;
								}
								else{
									status.add(h, result);
									break;
								}
							}
						}
					}
				}
		}
		
//		if(status.isEmpty())
//			System.out.println("IMPOSSIBLE");
//		else
//			for(int i = 0 ; i < status.size() ; i++){
//				for(int k =0 ; k < status.elementAt(0).length ; k++)
//					System.out.print(status.elementAt(i)[k]);
//				System.out.println();
//			}
	}
}
