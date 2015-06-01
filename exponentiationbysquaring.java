package gud;

import java.math.BigInteger;
import java.util.Scanner;

//if you cant use BigInteger 
// x^n == x(x^2)^((n-1)/2) if n = odd
// x^n == (x^2)^(n/2) if n = even
// use recursion
// and memoization

public class exponentiationbysquaring {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t>0){
            int n = s.nextInt()+1;
            if(n==1){
            	System.out.println("4");
            }
            else{
            BigInteger sum = new BigInteger("2");
            sum = sum.modPow(new BigInteger(Integer.toString(n)),new BigInteger("1000000007"));
            sum = sum.add(new BigInteger("2"));
            System.out.println(sum);
            }
            t--;
        }
    }
}

