package gud;

import java.util.Scanner;
import java.math.BigInteger;
public class fillJars {
	 public static void main(String args[]){
		 Scanner s = new Scanner(System.in);
		 int n = s.nextInt();
		 BigInteger n1 = new BigInteger(Integer.toString(n));
		 int m= s.nextInt();
		 BigInteger sum = new BigInteger("0");
		 long[] jars = new long[n];
		 while(m>0){
			 int a = (s.nextInt()-1);
			 int b = (s.nextInt()-1);
			 BigInteger k = new BigInteger(s.next());
			 
			 BigInteger diff =new BigInteger( Integer.toString((b-a)+1));
			 sum = sum.add(k.multiply(diff));
			 m--;
		 }
		
		 sum = sum.divide(n1);
		 System.out.println(sum);
	 }
}
