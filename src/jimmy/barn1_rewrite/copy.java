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

	//1.�Ƚ���ţ��ţ����д������
	//2.��ţ��ţ��֮��Ŀ�ţ����д��length������
	//3.�����һ��ľ������Ҫ�ĳ���
	//4.ѡ��ţ����������Ϊ�����ľ���п���ֱ��ľ��������Ҫ�󣬼��������ľ����ܳ���
	
	public static void main(String[] args) throws IOException {
		//1.�Ƚ���ţ��ţ����д������
		Scanner scan = new Scanner(new File("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		int M = scan.nextInt();
		int S = scan.nextInt();
		int stallNum = scan.nextInt();
		int[] cow = new int[stallNum];
		for(int i = 0;i<stallNum;i++){
			cow[i] = scan.nextInt();
		}
		//2.��ţ��ţ��֮��Ŀ�ţ����д��length������
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
		//3.�����һ��ľ������Ҫ�ĳ���
		int woodLength = cow[cow.length-1] - cow[0] + 1;
		//4.ѡ��ţ����������Ϊ�����ľ���п���ֱ��ľ��������Ҫ�󣬼��������ľ����ܳ���
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
