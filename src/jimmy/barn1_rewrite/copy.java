package jimmy.barn1_rewrite;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
/*
ID: 20165221
LANG: JAVA
TASK: barn1
*/
public class copy {

	//1.先将有牛的牛棚编号写入数组
	//2.有牛的牛棚之间的空牛棚数写入length数组中
	//3.计算出一根木板所需要的长度
	//4.选空牛棚数最大的作为间隔将木板切开，直到木板数满足要求，计算出所需木板的总长度
	
	public static void main(String[] args) throws IOException {
		//1.先将有牛的牛棚编号写入数组
		Scanner scan = new Scanner(new File("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		int M = scan.nextInt();
		int S = scan.nextInt();
		int stallNum = scan.nextInt();
		int[] cow = new int[stallNum];
		for(int i = 0;i<stallNum;i++){
			cow[i] = scan.nextInt();
		}
		//2.有牛的牛棚之间的空牛棚数写入length数组中
		int[] cowsLength = new int[stallNum - 1];
		int count = 0;
		for(int i = 1;i < cow.length;i++){
			int t = cow[i] - cow[i-1]-1;
			if(t != 0){
				cowsLength[count] = t;
				count++;
			}
		}
		Arrays.sort(cowsLength,0,count-1);
		//3.计算出一根木板所需要的长度
		int woodLength = cow[cow.length-1] - cow[0] + 1;
		//4.选空牛棚数最大的作为间隔将木板切开，直到木板数满足要求，计算出所需木板的总长度
		int num = 1;
		while(num != M){
			woodLength = woodLength - cowsLength[count-1];
			count--;
			num++;
		}
		out.println(woodLength);
		out.close();
		
	}
	
}
