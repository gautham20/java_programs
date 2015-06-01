package gud;

import java.util.Scanner;
import java.math.BigInteger;
public class nfib2 {
	public static void main(String args[]){
		
		Scanner s = new Scanner(System.in);
		long n = s.nextInt();
		long start = System.nanoTime();
		BigInteger answer = fib(new BigInteger(Long.toString(n)));
		long time = System.nanoTime() - start;
		//answer = answer.mod(new BigInteger("1000000007"));
		time = System.nanoTime() - start;
		  System.out.printf("Time to compute: %5.2f seconds.%n", time / 1.0e9);
		System.out.println(answer);
	}
	 
	static BigInteger fib(BigInteger n){
		if(n.longValue()==0){ return new BigInteger("0"); }
		else if(n.longValue()==1){ return new BigInteger("1"); }
		else if(n.longValue()==2){ return new BigInteger("1"); }
		else if(n.longValue()==3){ return new BigInteger("2"); }
		else
		{
			if(n.mod(new BigInteger("2")).longValue()==0){
				BigInteger x = n.divide(new BigInteger("2"));
				BigInteger x1 = x.subtract(new BigInteger("1"));
				return ((fib(x1).multiply(new BigInteger("2"))).add(fib(x))).multiply(fib(x));
				
			}
			else{
				
				BigInteger x = (n.add(new BigInteger("1"))).divide(new BigInteger("2"));
			BigInteger x1 = x.subtract(new BigInteger("1"));
			return (fib(x1).pow(2)).add(fib(x).pow(2));
			}
		}
		
		
		
	}
}


