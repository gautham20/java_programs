package gud;

import java.util.Arrays;
import java.util.Scanner;

public class biggerisgreater2 {

	 public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
	        int t = s.nextInt();s.nextLine();
	        while(t>0){
	            String str = s.nextLine();
	            char arr[] = str.toCharArray();
	            
	            boolean flag = false;
	            int len = arr.length;
	            char key = arr[len-1];
	            char sml = arr[len-1];
	            int smlindex = len-1;
	            int sortstart = 0;
	            for(int i=(len-2);i>=0 && !flag ;i--){
	            	System.out.println(key+"  "+arr[i]+"   "+i);
	                if(arr[i]>key){
	                	char temp = arr[i];
	                	int j = -1;
	                    
	                    for( j=i+1;j<=len-1;j++){
	                    	if(temp>arr[j]){
	                    		arr[j-1] = arr[j];	
	                    	}
	                    	else
	                    		break;
	                    }
	                    arr[--j] = temp;
	                    key = temp;
	                   
	                }
	                else if(arr[i] < key ){
	                	char t2 = arr[i];
	                	arr[i] = arr[i+1];
	                	arr[i+1]  = t2;
	                    flag = true;
	                    break;
	                }
	            }
	            if(flag){
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
