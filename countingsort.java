package gud;

import java.util.Scanner;

public class countingsort {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int ar_original[] = new int[n];
        int ar[] = new int[100];
        int ar_answer[] = new int[n];
        for(int i=0;i<n;i++){
        	
        	int num = s.nextInt();
        	//System.out.println(i+"  "+num);
        	ar_original[i]=num;
            ar[num]++;
        }
        for(int i=1;i<100;i++){
        	ar[i] = ar[i] + ar[i-1];
     
        }
      
        

        
        for(int i=(n-1);i>=0;i--){
        	//System.out.println(i);
        	ar_answer[(ar[ar_original[i]]-1)]= ar_original[i] ;
        	ar[ar_original[i]]--;
        }
        for(int i=0;i<n;i++){
        	System.out.print(ar_answer[i]+" ");
        }
       
    }
}

