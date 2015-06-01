package gud;

import java.util.Scanner;

public class subcountingsort {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int ar_original[] = new int[n];
        int ar[] = new int[100];
        int ar_answer[] = new int[n];
        for(int i=0;i<n;i++){
        	
        	int num = s.nextInt();
        	String st = s.nextLine();
        	ar_original[i]=num;
            ar[num]++;
        }
        for(int i=1;i<100;i++){
        	ar[i] = ar[i] + ar[i-1];
     
        }
      
        for(int i=0;i<100;i++){
        	System.out.print(ar[i]+" ");
        }
       
    }
}

