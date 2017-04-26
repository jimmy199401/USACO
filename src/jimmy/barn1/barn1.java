package jimmy.barn1;

/*
ID: 20165221
LANG: JAVA
TASK: barn1
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class barn1 {

	private static class node{
		public node(int start,int end){
			this.start = start;
			this.end = end;
		}
		public int start;
		public int end;
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(new File("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		int M = scan.nextInt();
		scan.nextInt();
		int t = scan.nextInt();
		int[] array = new int[t];
		for(int i = 0;i<t;i++){
			array[i] = scan.nextInt();
		}
		int start = 0;
		int count = 0;
		ArrayList<node> list = new ArrayList<node>();
		for(int i = 0;i<array.length;i++){
			if(count == 0||array[i] - array[i-1] ==1){
				count++;
			}else{
				//System.out.println("--"+i);
				//System.out.println(count);
				node n = new node(array[start], array[start+count-1]);
				list.add(n);
				start = i;
				count = 1;
			}
			if(count!=0 && i ==array.length-1){
				list.add(new node(array[start], array[start+count-1]));
			}
		}
		//System.out.println(list.size());
		//System.out.println(list.get(6).end);
		int label = 2;
		int flag = 0;
		while(list.size()>M){
			for(int i = 1;i < list.size();i++){
				//System.out.println(list.get(i).start);
				if(list.get(i).start- list.get(i-1).end==label){
					//list.get(i-1).end = list.get(i).end;
					//System.out.println("-------");
					int t1 = list.get(i-1).start;
					int t2 = list.get(i).end;
					list.remove(i-1);
					list.remove(i-1);
					list.add(i-1, new node(t1,t2));
					if(list.size() == M){
						break;
					}else
						i = i-1;
				}
			}
				label = label+1;
		}
		int sum = 0;
		for(int i = 0;i<list.size();i++){
			//System.out.println("-------"+list.get(i).start);
			sum = sum+(list.get(i).end - list.get(i).start+1);
		}
		out.println(sum);
		out.close();
	}
	
}
