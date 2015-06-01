package gud;

import java.util.Scanner;

public class largestIncresingsubsequenceDP {
	 public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
	        int t = s.nextInt();
	        while(t>0){
	            int n = s.nextInt();
	            int iarr[] = new int[n];
	            int sarr[] = new int[n+1];
	            for(int k=0;k<n;k++){
	                iarr[k] = s.nextInt();
	            }
	            sarr[0]=-1;
	            int count = 0;
	            for(int i=0;i<n;i++){
	                for(int c=count;c>=0;c--){
	                    if(sarr[c]<iarr[i]){
	                        sarr[c+1] = iarr[i];
	                        if((c+1)>count){
	                            count  =c+1;
	                        }
	                        break;
	                    }
	                }
	            }
	            t--;
	            System.out.println(count);
	           count = n-(count);
	            String str = count%2==0? "Bob" : "Alice";
	            System.out.println(str);
	        }
	    }
	}