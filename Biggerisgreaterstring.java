package gud;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Biggerisgreaterstring {
	
	 public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
	        int t = s.nextInt();s.nextLine();
	        while(t>0){
	            String str = s.nextLine();
	            char arr[] = str.toCharArray();
	            int carr[] = new int[26];
	            boolean flag = false;
	            int len = arr.length;
	            char key = arr[len-1];
	            carr[((int)arr[len-1])%97]++;
	            int sortstart = 0;
	            for(int i=(len-2);i>=0 && !flag ;i--){
	            	
	            	carr[((int)arr[i])%97]++;
	                if(arr[i]>=key){
	                    key = arr[i];
	                }
	                else{
	                    arr[i+1] = arr[i];
	                    arr[i] = key;
	                    sortstart = i+1;
	                    carr[((int)arr[i])%97]--;
	                    flag = true;
	                    break;
	                }
	            }
	            if(flag){
	            	
	            	str = new String(arr);
	                System.out.println(str+ "  "+sortstart+"  "+len);
	            	 for(int i=1;i<26;i++){
	                 	carr[i] = carr[i] + carr[i-1];
	                 }
	            	 
	            	 for(int i=0;i<26;i++){
		                 	System.out.println(carr[i]+"   "+ (char)(i+97) );
		                 }
	            
	            	 
	            	char sub_arr[] = Arrays.copyOfRange(arr, sortstart, len);
	            	
	            	
	            	
	            	
	            	
	            	
	            	
	            	for(int i=(sub_arr.length)-1;i>=0;i--){
	            		 System.out.println(((carr[((int)sub_arr[i]%97)])-1)+"   "+sub_arr[i]+"  "+i);
	            		 arr[((carr[((int)sub_arr[i]%97)])-1)+sortstart] = sub_arr[i];
	            		 carr[((int)sub_arr[i])%97]--;
	            	 }
	            	 
	                str = new String(arr);
	                System.out.println(str);
	            }
	            else{
	                System.out.println("no answer");
	            }
	            t--;
	        }
	    }
	 

	}