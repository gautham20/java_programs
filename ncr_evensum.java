package gud;

import java.math.BigInteger;
import java.util.Scanner;

public class ncr_evensum {

    public static void main(String[] args) {
       Scanner s  = new Scanner(System.in); 
       int n = s.nextInt();
        int temp;
       int ecount = 0;
       int ocount = 0;
        for(int i =0 ; i<n ;i++){
            temp = s.nextInt();
            if(temp%2==0){
                ecount++;
            }
            else
                ocount++;
        }
      // System.out.println(ocount+"   "+ecount);
      BigInteger nodd = new BigInteger("1");
      BigInteger neven ;
      if(ecount>0){
    	  neven  = new BigInteger("2");
      }
      else{
    	  neven = new BigInteger("1");
      }
      BigInteger ans;
      BigInteger tempsum = new BigInteger("1");
      BigInteger counter = new BigInteger("1");
      boolean even_iseven = ecount%2==0;
      boolean odd_iseven = ocount%2==0;
      
      for(int i=0;i<ocount;i+=1){
    	  tempsum = tempsum.multiply(new BigInteger(Integer.toString(ocount-i)));
    	  tempsum = tempsum.divide(new BigInteger(Integer.toString(i+1)));
    	  //System.out.println(tempsum);
    	  if(i%2!=0){
    	  nodd = nodd.add(tempsum);
    	  }
      }
      tempsum = new BigInteger("1");
      
     // System.out.println("even");
      for(int i=0;i<(ecount)/2;i+=1){
    	 
    	  tempsum = tempsum.multiply(new BigInteger(Integer.toString(ecount-i)));
    	  tempsum = tempsum.divide(new BigInteger(Integer.toString(i+1)));
    	  //System.out.println(tempsum);
    	  if(even_iseven && i==(ecount/2)-1){
    		  neven = neven.add(tempsum);
    	  }
    	  else
    	  neven = neven.add(tempsum.multiply(new BigInteger("2")));
    	  
    	  //System.out.println(tempsum);
    	  
      }
      
      //System.out.println(nodd+"   "+neven);
      ans = neven.multiply(nodd);
      ans = ans.subtract(new BigInteger("1"));
      //System.out.println(ans);
      ans = ans.mod(new BigInteger("1000000007"));
      System.out.println(ans);
        
    }
}
