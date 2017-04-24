package jimmy.namenum;
/*
ID: 20165221
LANG: JAVA
TASK: namenum
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class namenum {

	private static Scanner scan = null;
	private static long[] dict = new long[5000];
	private static String[] str = new String[5000];
	public static void main(String[] args) throws IOException {
		scan = new Scanner(new File("dict.txt"));
		for(int i = 0;i < 5000; ++i){
			if(scan.hasNextLine()){
				String s = scan.nextLine();
				str[i] = s;
				dict[i] = getDictNum(s);
				//System.out.println(dict[i]+str[i]);
			}
		}
		Scanner scan2 = new Scanner(new File("namenum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		long num = scan2.nextLong();
		int[] index = findDict(num);
		if(index[0] == 0){
			out.println("NONE");
		}else{
			for(int i =1;i <= index[0];++i){
				out.println(str[index[i]]);
			}
		}
		out.close();
	}
	
	public static long getDictNum(String s){
		long sum = 0;
		for(int j = 0;j < s.length();++j){
			if(charToNum(s.charAt(j)) == 0){
				return -1;
			}
			sum += charToNum(s.charAt(j))*Math.pow(10, s.length() - j -1 );
		}
		return sum;
	}
	
	public static int[] findDict(long num){
		int[] index = new int[10];
		int count = 0;
		for(int i =0;i < 5000;++i){
			if(num == dict[i])
				index[++count] = i;
		}
			index[0] = count;
			return index;
	}
	
	public static int charToNum(char temp){
		switch(temp){
		case 'A':
		case 'B':
		case 'C':
			return 2;
		case 'D':
		case 'E':
		case 'F':
			return 3;
		case 'G':
		case 'H':
		case 'I':
			return 4;
		case 'J':
		case 'K':
		case 'L':
			return 5;
		case 'M':
		case 'N':
		case 'O':
			return 6;
		case 'P':
		case 'R':
		case 'S':
			return 7;
		case 'T':
		case 'U':
		case 'V':
			return 8;
		case 'W':
		case 'X':
		case 'Y':
			return 9;
		default:
			return 0;
		}
	}
	
}
