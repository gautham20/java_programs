package gud;

import java.math.BigInteger;
import java.util.Scanner;
public class Solution {

	 public static void main(String[] args) {
	       Scanner s = new Scanner(System.in);
	        int t = s.nextInt();s.nextLine();
	       
	       
	        do{
	           
	           String  str = s.nextLine();
	           BigInteger num = new BigInteger(str);
	           for(int i=0;i<=31;i++){
	           num= num.flipBit(i);
	           }
	           System.out.println(num);
	           t--;
	        }while(t>0);
	    }
	}
