package jimmy.dualpal;

/*
ID: 20165221
LANG: JAVA
TASK: dualpal
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class dualpal {

	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(new File("dualpal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		int n = scan.nextInt();
		int s = scan.nextInt();
		int ts = s+1;
		int count = 1;
		while(count <= n){
			if(getNum(ts)>=2){
				out.println(ts);
				count++;
			}
			ts++;
		}
		out.close();
	}
	
	public static byte[] numTrans(int num,int base){
		
		byte[] aNum = new byte[32];
		int count =1;
		while(num != 0){
			aNum[count++] = (byte) (num%base);
			num = num/base;
		}
		aNum[0] = (byte)(count-1);
		return aNum;
	}
	
	public static boolean isPalindromic(byte[] num){
		int tempN = num[0];
		for(int i = 1;i<=tempN;++i){
			if(num[i] != num[tempN-i+1]){
				return false;
			}
		}
		return true;
	}
	public static int getNum(int num){
		int count = 0;
		for(int i =2;i <=10;i++){
			if(isPalindromic(numTrans(num, i))){
				count++;
			}
		}
		return count;
	}
}
