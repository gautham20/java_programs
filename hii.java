package gud;

import java.util.Scanner;


public class hii 
{
	
	static long mod = (long)1e9+7;
	static Scanner s = new Scanner(System.in);
	public static void main(String args[]){
		int n = s.nextInt();
		int[] a = new int[n];
		for(int i = 0;i<n;i++)
		{
			a[i]=s.nextInt();
		}
		pandamaxor(a);
			
		}
	
	  public static void pandamaxor(int[] arr) {
		    
		  long maxor_num[] = new long[130];
		  for( int i = 0 ; i<arr.length ; i++){
			  long temp[] = new long[130];
			  for(int j=0;j<129;j++){
				  if(maxor_num[j]!=0){
					  int calc = j^arr[i];
					  temp[calc]+=maxor_num[j];
					  temp[calc]=check(temp[calc]);
				  }
			  }
			  for(int k=0;k<129;k++){
				  maxor_num[k]+=temp[k];
				  maxor_num[k]=check(maxor_num[k]);
			  }
			  maxor_num[arr[i]]++;
			  maxor_num[arr[i]]=check(maxor_num[arr[i]]);
		  }
		  
		  for(int k=0;k<129;k++){
			  System.out.print(maxor_num[k]+" ");
		  }
		  
		  
		  
		  System.out.println();

		  
			  long sum=0,nCk=1;
			  for(int i=0;i<130;i++){
				  long n=maxor_num[i];
					if(n>1){
		    			nCk=1;
		    			for(int k=0;k<2;k++){
		    				 nCk = nCk * (n-k) / (k+1);
		    				 nCk=check(nCk);
		    			}
		    			sum = sum + nCk;
		    			sum = check(sum);
					}
		    			
		    			
			  }
			  System.out.println(sum%1000000007);
	  }
	  
	  static long check (long num){
		  if(num>mod)
		  return num%mod;
		  else
			  return num;
	  }

}
