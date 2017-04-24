package jimmy.palsquare;

/*
ID: 20165221
LANG: JAVA
TASK: palsquare
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class palsquare {

	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(new File("palsquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		int base = scan.nextInt();
		for(int i = 1;i<=300;++i){
			
			byte[] num1 = numTrans(i, base);
			byte[] num2 = numTrans(i*i, base);
			if(isPalindromic(num2)){
				for(int count1 = num1[0];count1>=1;count1--){
					if(base>10&&num1[count1]>9){
						char temp = (char)(65+num1[count1]-10);
						out.print(temp);
					}else
						out.print(num1[count1]);
				}
				out.print(" ");
				for(int count2 = num2[0];count2>=1;count2--){
					if(base>10&&num2[count2]>9){
						out.print((char)(65+num2[count2]-10));
					}else
						out.print(num2[count2]);
				}
				out.println();
			}
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
}
