package jimmy.transform;

/*
ID: 20165221
LANG: JAVA
TASK: transform
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class transform {

	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(new File("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		int n = Integer.parseInt(scan.nextLine());
		int[][] matrix1 = new int[n][n];
		int[][] matrix2 = new int[n][n];
		for(int i =0;i<n;++i){
			String s = scan.nextLine();
			for(int t = 0;t < n; ++t){
				if(s.charAt(t) == '@')
					matrix1[i][t] = 1;
				else if(s.charAt(t) == '-')
					matrix1[i][t] = 0;
			}
		}
		for(int i =0;i<n;++i){
			String s = scan.nextLine();
			for(int t = 0;t < n; ++t){
				if(s.charAt(t) == '@')
					matrix2[i][t] = 1;
				else if(s.charAt(t) == '-')
					matrix2[i][t] = 0;
			}
		}
//		for(int i=0;i<matrix1[0].length;++i){
//			for(int j=0;j<matrix1[0].length;++j){
//				System.out.print(matrix1[i][j]);
//			}
//			System.out.println();
//		}
//		for(int i=0;i<matrix2[0].length;++i){
//			for(int j=0;j<matrix2[0].length;++j){
//				System.out.print(matrix2[i][j]);
//			}
//			System.out.println();
//		}
		if(compare(matrix2, degreeOfNinty(matrix1))){
			out.println(1);
		}else if(compare(matrix2, degreeOfEight(matrix1))){
			out.println(2);
		}else if(compare(matrix2, degreeOftwo(matrix1))){
			out.println(3);
		}else if(compare(matrix2, reflect(matrix1))){
			out.println(4);
		}else if(combination(matrix2, matrix1)){
			out.println(5);
		}else if(compare(matrix1, matrix2)){
			out.println(6);
		}else{
			out.println(7);
		}
		out.close();

	}
	
	public static int[][] degreeOfNinty(int[][] matrix){
		
		int n = matrix[0].length;
		int[][] temp = new int[n][n];
		for(int i = 0;i < n;++i){
			for(int t = 0;t < n; ++t){
				temp[t][n-i-1] = matrix[i][t]; 
			}
		}
		return temp;
	}
	
	public static int[][] degreeOfEight(int[][] matrix){
		int n = matrix[0].length;
		int[][] temp = new int[n][n];
		temp = degreeOfNinty(matrix);
		temp = degreeOfNinty(temp);
		return temp;
	}
	
	public static int[][] degreeOftwo(int[][] matrix){
		int n = matrix[0].length;
		int[][] temp = new int[n][n];
		temp = degreeOfNinty(matrix);
		temp = degreeOfNinty(temp);
		temp = degreeOfNinty(temp);
		return temp;
	}
	
	public static int[][] reflect(int[][] matrix){
		int n = matrix[0].length;
		int[][] temp = new int[n][n];
		for(int j = 0;j < n;++j){
			for(int t = 0;t < n; ++t){
				temp[t][j] = matrix[t][n-j-1];
			}
		}
		return temp;
	}
	
	public static boolean combination(int[][] matrix1,int[][] matrix2){
		
		int n = matrix1[0].length;
		int[][] temp = new int[n][n];
		temp = reflect(matrix1);
		for(int i = 0;i < 3;++i){
			temp = degreeOfNinty(temp);
			if(compare(temp, matrix2)){
				return true;
			}
		}
		return false;
	}
	public static boolean compare(int[][] matrix1,int[][] matrix2){
		
		for(int i=0;i<matrix1[0].length;++i){
			for(int j=0;j<matrix1[0].length;++j){
				if(matrix1[i][j] != matrix2[i][j]){
					return false;
				}
			}
		}
		return true;
		
	}
}
