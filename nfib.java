package gud;

import java.util.Scanner;
import java.math.BigInteger;
import java.math.BigDecimal;
public class nfib {
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(n);
		double sf = Math.sqrt(5);
		double g1 = (1 + sf)/2;
		double g2 = (1-sf)/2;
		BigDecimal g1b = new BigDecimal(Double.toString(g1));
		g1b = g1b.pow(n);
		BigDecimal g2b = new BigDecimal(Double.toString(g2));
		g2b = g2b.pow(n);
		BigDecimal answer = g1b.subtract(g2b);
		System.out.println("temp"+answer);
		//BigInteger atemp = answer.toBigInteger();
		//BigDecimal a2 = new BigDecimal(atemp);
		answer = answer.divideToIntegralValue(new BigDecimal(Double.toString(sf)));
		BigInteger atemp = answer.toBigInteger();
		System.out.println(atemp);
}
}

/* GOLDEN RATIO
 * 
 *    fib(n) =  ( (((1+sqrt(5))/2)^n - (((1-sqrt(5))/2)^n )/ sqrt(5)  
 * 
 * 
 * 
 * 
 * 
 * One method was proposed by the late Prof. Edsgar W Dijkstra around 1978, described in note EWD654 "In honor of Fibonacci" (PDF, 38K; download the free Acrobat Reader to view it if your browser will not display it).
Note that Dijkstra's series begins F(1)=0 and F(2)=1 so, using our index system which has F(0)=0 and F(1)=1, we have:
F(2n-1) = F(n-1)2 + F(n)2
F(2n) = ( 2 F(n-1) + F(n) ) F(n)
which need only F(n) and F(n-1) to compute both F(2n) and F(2n-1). Although the formula in Dijkstra's note were "well-known" in 1978, his method of using these two formula in this way as an efficient algorithm for computing big Fibonacci numbers may be original.
So, to compute F(1000) we would use the two formulae as follows:

    F(1000) needs F(500) and F(499)
    F(500) and
    F(499) need F(250) and F(249)
    F(250) and
    F(249) need F(124) and F(125)
    F(124) needs F(61) and F(62)
    F(125) needs F(62) and F(63)
    F(63) needs F(32) and F(31)
    F(62) and
    F(61) needs F(31) and F(30)
    F(32) and
    F(31) need F(16) and F(15)
    F(30) needs F(15) and F(14)
    F(16) and
    F(15) need F(8) and F(7)
    F(14) needs F(7) and F(6)
    F(8) and
    F(7) need F(4) and F(3)
    F(6) needs F(3) and F(2)
    F(4) and
    F(3) need F(2) and F(1)
    F(2) needs F(1) and F(0)
    F(1) and
    F(0) are 1 and 0 by definition

So there are very few (22) F values needed to compute F(1000) and it takes much less work than using the method of "add the previous two F values to get the next one". 



*/
