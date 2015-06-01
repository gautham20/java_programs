package gud;

import java.util.Scanner;

public class chocos {
	public static void main(String args[]){
		 Scanner s = new Scanner(System.in);
		 int t = s.nextInt();
		 while(t>0){
			 int n = s.nextInt();
			 int c = s.nextInt();
			 int m = s.nextInt();
			 int result=0;
			 int num =(int) Math.floor(n/c);
			 result += num;
			 while(num>=m){
			 int xtra = (int) Math.floor(num/m);
			 result += xtra;
			 int remain = num%m;
			 num = xtra+remain;
			 }
			 System.out.println(result);
			 t--;
		 }
	}
}
