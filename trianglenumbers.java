package gud;

import java.util.Arrays;
import java.util.Scanner;

public class trianglenumbers {
	
	
	
	// two dimensional array can not exceed 6digitX6digit
	//
	//
	//
	//
	//
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int largest = 0;
		int tc[] = new int[t];
		for(int i=0;i<t;i++){
			tc[i] = s.nextInt();
			largest = tc[i]>largest?tc[i]:largest;
		}
		int max_column =largest;
		
		boolean matrix[][] = new boolean[largest][max_column];
		//Arrays.fill(matrix, 0);
		matrix[0][0] = true;
		matrix[1][0] = matrix[1][1] = true;
		int column = 3;
		for(int i=2;i<largest;i++){
				matrix[i][0]= true;
				matrix[i][1]= !(i%2==0);
			for(int j=2;j<column;j++){
				
				if(j==i){
					matrix[i][j] = matrix[i-1][j-2]^matrix[i-1][j-1]^matrix[i-1][j-2];
				}
				else
					matrix[i][j] = matrix[i-1][j-2]^matrix[i-1][j-1]^matrix[i-1][j];
			}
			column++;
		}
		
		for(int k=0;k<t;k++){
			int row = tc[k]-1;
			int climit = row;
			for(int c=1;c<=climit;c++){
				if(!matrix[row][c]){
					System.out.println(c+1);
					break;
				}
			}
		}
	}
}
