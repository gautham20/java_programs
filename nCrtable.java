package gud;

import java.util.Scanner;
import java.math.BigInteger;

public class nCrtable {
	public static void main(String args[]){
		 Scanner s = new Scanner(System.in);
		 int t = s.nextInt();s.nextLine();
		 while(t>0){
			 int n = s.nextInt();s.nextLine();
			 BigInteger num=new BigInteger("1");
			 BigInteger arr[] = new BigInteger[n];
			 arr[0]=new BigInteger("1");
			 boolean ef = (n%2)==0, flag=true;
			 int j=0;
			 System.out.print(num+" ");
			 for(int i=0;i<(n);i++){
				 
				 if(i<(n/2)){
					 j=i+1;
				 num = num.multiply(new BigInteger(Integer.toString(n-i)));
				 num = num.divide(new BigInteger(Integer.toString(i+1)));
				 arr[i+1]=num;
				 
				 
				 System.out.print(num.mod(new BigInteger("1000000000"))+" ");
				 }
				 else{
				 if(ef && flag ){
					 j--; flag = false;
				 }
				 System.out.print(arr[j].mod(new BigInteger("1000000000"))+" ");
				 j--;
				 }
				 
			 }
			 System.out.println();
			 t--;
		 }
		 
	}
	
	

}
