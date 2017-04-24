package jimmy.milk2;

/*
ID: 20165221
LANG: JAVA
TASK: milk2
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class milk2 {

	private static int[] time = new int[1000001];
	private static int longMilkTime = 0;
	private static int longNMilkTime = 0;

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		int n = Integer.parseInt(scan.nextLine());
		for(int i =1;i <= n;i++){
			int start = scan.nextInt();
			int end = scan.nextInt();
			addTimePot(start+1,end);
		}
		setTime();
		//System.out.println(longMilkTime-1);
		//System.out.println(longNMilkTime+1);
		out.print(longMilkTime);
		out.print(" ");
		out.println(longNMilkTime);
		
		out.close();
	}
	
	public static void addTimePot(int start,int end){
		
		for(int i = start;i <= end;++i){
			time[i] = 1;
		}
	}
	
	public static void setTime(){
		int index =0;
		int last = 1000001;
		while(index <= 1000000){
			if(time[++index] == 1)
				break;
		}
		while(last >1){
			if(time[--last] == 1){
				break;
			}
		}
		int indexCh = 1; 
		int count = 0;
		//System.out.println(index);
		//System.out.println(last);
		for(int i = index;i <= last;++i){
			if(time[i] == indexCh){
				count++;
			}else{
				if(indexCh == 1){
					if(count>longMilkTime){
						longMilkTime = count;
						//System.out.println(longMilkTime);
					}
					count = 1;
				}else{
					if(count>longNMilkTime){
						longNMilkTime = count;
						//System.out.println(longNMilkTime);
					}
					count = 1;
				}
				indexCh = time[i];
			}
			if( i == last){
				if(indexCh == 1){
					if(count>longMilkTime){
						longMilkTime = count;
					}
				}else{
					if(count>longNMilkTime){
						longNMilkTime = count;
					}
				}
			}
		}
	}
}
