package jimmy.beads;

/*
ID: 20165221
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

class beads {

	private static int count = 0;
	public static void main (String [] args) throws IOException {
	    BufferedReader f = new BufferedReader(new FileReader("beads.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
	    f.readLine();
	    String  str1 = f.readLine();
		String str2 = str1+str1;
		String[] str = new String[count];
		str = getbeads(str2);
		if(count == 1){
			out.println(str2.length()/2);
		}else{
			int a = beadsNum(str);
			out.println((a > str1.length())?str1.length():a);
		}
		out.close(); 
	}

	public static String[] getbeads(String s){
		int index = 0;
		int end = 0;
		int indexChar = s.charAt(0);
	
		String[] str = new String[s.length()]; 
		for(int i = 0;i<s.length();++i){
			if(s.charAt(i) == 'w'){
				end += 1;
				if((end!=s.length())&&indexChar == 'w'){
					indexChar = s.charAt(i+1);
				}
			}else{
				if(s.charAt(i)!=indexChar){
					
					str[count++] = s.substring(index,end);
					//System.out.println(s.substring(index,end));
					index = end;
					end = end +1;
					indexChar = s.charAt(i);
				}else{
					end = end + 1;
				}	
			}
			if((end == s.length()-1) && (index == 0)){
				str[count++] = s; 
			}
		}
		return str;
		
	}
	public static int lastW(String s){
		int count = 0;
		for(int j = s.length()-1;j>=0;j--){
			if(s.charAt(j) == 'w'){
				count++;
			}else{
			break;
			}
		}
		return count;
	}
	public static int beadsNum(String[] str){
		int[] beads = new int[count];
		int[] obeads = new int[count];
		beads[0] = str[0].length();
		obeads[0] = str[0].length();
		for(int i = 1;i < count ;i++){
			
			beads[i] = str[i].length() + lastW(str[i-1]);
			obeads[i] = str[i].length();
		}
		int count1 = obeads[0];
		for(int i = 1;i < count;i++){
			if(beads[i-1] + obeads[i] > count1){
				count1 = beads[i-1] + obeads[i];
			}
		}
		return count1;
	}

}