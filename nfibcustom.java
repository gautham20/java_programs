package gud;

import java.util.Scanner;
import java.math.BigInteger;
import java.math.BigDecimal;
public class nfibcustom {
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
				BigInteger t1 = nfib(n-1);
				BigInteger t2 = nfib(n);
				t1 = t1.multiply(new BigInteger(Integer.toString(a)));
				t2 = t2.multiply(new BigInteger(Integer.toString(b)));
				t1 = t1.add(t2);
				String str = t1.toString();
				System.out.println(str);
			}
			t--;
		}
	}
	
	static BigInteger nfib (int n) {
		if(n==1){
			return new BigInteger("1");
		}
		double sf = Math.sqrt(5);
		double g1 = (1 + sf)/2;
		double g2 = (1-sf)/2;
		BigDecimal g1b = new BigDecimal(Double.toString(g1));
		g1b = g1b.pow(n);
		BigDecimal g2b = new BigDecimal(Double.toString(g2));
		g2b = g2b.pow(n);
		BigDecimal answer = g1b.subtract(g2b);
		answer = answer.divideToIntegralValue(new BigDecimal(Double.toString(sf)));
		BigInteger atemp = answer.toBigInteger();
		return atemp;
	}
	
	
}
