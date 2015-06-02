package gud;

import java.util.Scanner;

//to find the sum of diagonals in a clockwise spiral square of max size 1001*1001
public class clock_diagonal {
	
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int max = s.nextInt();
		int row = (max-1)/2;
		int ans = 1;
		int curr = 1;
		for(int i=1,incr=2;i<=row;i++,incr+=2){
			int count=4;
			while(count>0){
				curr += incr;
				ans += curr;
				System.out.println(ans+" "+curr);
				count--;
			}
		}
		System.out.println(ans);
	}
	

}
