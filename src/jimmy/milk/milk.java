package jimmy.milk;
/*
ID: 20165221
LANG: JAVA
TASK: milk
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class milk {

	private static int z = 0;
	public static void main(String[] args) throws IOException {
//		Scanner f1 = new Scanner(new File("milk.in"));
//		int count = 0;
//		while(f1.hasNextLine()){
//			f1.nextLine();
//			count ++;
//		}
		Scanner f2 = new Scanner(new File("milk.in"));
		int[][] company= new int[2][5000];
		int needUnits = f2.nextInt();
		//System.out.println(needUnits);
		int peopleNum = f2.nextInt();
		int i = 0;
		while(f2.hasNext()){
			company[1][i] = f2.nextInt();
			company[0][i] = f2.nextInt();
			z++;
			i++;
		}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		if(needUnits == 0){
			out.println(0);
		}else
			out.println(getLowCost(company, needUnits, peopleNum));
		out.close();
		                   
	}
	
	public static int getLowCost(int[][] farmerProduct,int needUnits,int peopleNum){
		int max = 0;
		farmerProduct = decide(sort(farmerProduct, 0), needUnits, peopleNum);
		if(farmerProduct[0][0] == -1){
			max = -1;
		}else{
			farmerProduct = sort(farmerProduct, 1);
			for(int i = 0;i<z;++i){
				if(needUnits>farmerProduct[0][i]){
					max = max + farmerProduct[0][i]*farmerProduct[1][i];
					needUnits = needUnits - farmerProduct[0][i];
				}else if(needUnits!=0){
					max = max + needUnits*farmerProduct[1][i];
					needUnits = 0;
				}
			}
		}
		return max;
	}
	public static int[][] sort(int[][] farmerProduct,int axis){
		

		for(int i = 0;i < z-1;++i){
			for(int j = 0;j < z - i -1;j++){
				if(farmerProduct[axis][j]>farmerProduct[axis][j+1]){
					int temp1 = farmerProduct[0][j];
					int temp2 = farmerProduct[1][j];
					farmerProduct[0][j] = farmerProduct[0][j+1];
					farmerProduct[1][j] = farmerProduct[1][j+1];
					farmerProduct[0][j+1] = temp1;
					farmerProduct[1][j+1] = temp2;
				}
			}
		}
		return farmerProduct;
	}
	public static int[][] decide(int[][] farmerProduct,int needUnits,int peopleNum){
		boolean flag = false;
		for(int i = 0; i < z - peopleNum+1;++i){
			int sum = 0;
			for(int j = i;j< peopleNum;++j){	
				sum = sum + farmerProduct[0][j];
			}
			//System.out.println(sum);
			if(sum >= needUnits){
				
				flag = true;
				break;
			}else{
				farmerProduct[0][i] = 0;
			}
		}
		if(flag == false)
			farmerProduct[0][0] = -1;
		return farmerProduct;
	}
}
