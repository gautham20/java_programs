package gud;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class nfibcustom2 {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t>0){
			int a= s.nextInt();
			int b= s.nextInt();
			int n= s.nextInt();
			if(n==0){ System.out.println(a); }
			else if(n==1) {System.out.println(b); }
			else{
				long t1 = nfib(n-1);
				long t2 = nfib(n);
				t1 = t1*a;
				t2 = t2*b;
				t1 += t2;
				System.out.println(t1);
			}
			t--;
		}
	}
	
	static long nfib (int n) {
		if(n==1){
			return 1;
		}
		double sf = Math.sqrt(5);
		double g1 = (1 + sf)/2;
		double g2 = (1-sf)/2;
		g1 = Math.pow(g1, n);
		g2 = Math.pow(g2, n);
		Double answer = g1-g2;
		answer = answer/sf;
		long atemp = Math.round(answer);
		return atemp;
	}
	
	
}


