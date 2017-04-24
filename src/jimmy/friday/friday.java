package jimmy.friday;

/*
ID: 20165221
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday {
	public static final int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};
	public static void main (String [] args) throws IOException {
	    BufferedReader f = new BufferedReader(new FileReader("friday.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
	    int period = Integer.parseInt(f.readLine());
		int[] a = getDayTimes(period);
		out.print(a[6] + " ");
		for(int m = 0; m <= 4;m++){
			out.print(a[m] + " ");
		}
		out.println(a[5]);
		                                  // close the output file
	}
	
	public static int getMonthDays(int year,int month){
		
		return month == 2 && isLeap(year)?monthDays[month-1] + 1:monthDays[month-1];
	}
	
	public static boolean isLeap(int year){
		
		return (year%100!=0&&year%4==0)||(year%400==0)? true:false;
	}
	
	public static int[] getDayTimes(int period){
		
		int[] dayTimes = {0,0,0,0,0,0,0,0};
		int t = 0;
		for(int i = 1900; i < 1900 + period; ++ i){
			for(int j = 1;j <= 12; ++j){
				
				t = (dayTimes[7] + 13) % 7;
				dayTimes[t]++;
				dayTimes[7] += getMonthDays(i,j);
			}	
		}
		
		return dayTimes;
	}
}