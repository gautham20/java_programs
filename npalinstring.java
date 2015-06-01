package gud;

import java.util.Scanner;

public class npalinstring {
	 public static void main(String[] args) {
	       Scanner s = new Scanner(System.in);
	        int t = s.nextInt();s.nextLine();
	        while(t>0){
	            int remove = -1 ;
	            String st = s.nextLine();
	            char[] arr = st.toCharArray();
	            int j = st.length()-1;
	            boolean flag = false;
	            for(int i=0;i<(st.length()/2);i++){
	                if(arr[i]!= arr[j]){
	                    System.out.println("here"+ i);
	                    if(arr[i]!= arr[j-1]){
	                        System.out.println("here1"+ i);
	                        remove = i;
	                        flag = true;
	                        break;
	                    }
	                    else if(arr[j]!= arr[i+1]){
	                        System.out.println("here2"+ j);
	                        remove = j;
	                        flag = true;
	                        break;
	                    }
	                    if(!flag){
	                    	if(arr[i+1]==arr[j-2]){
	                    		remove = j;
	                    	}
	                    	else if(arr[j-1]==arr[i+2]){
	                    		remove = i;
	                    	}
	                    	else{
	                    	remove = i;
	                    	}
	                    	break;
	                    }
	                }
	                j--;
	            }
	            
	            
	            t--;
	            System.out.println(remove);
	        }
	    }
	    
	}
