package gud;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Number_list {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t>0){
            int n = s.nextInt();
            int k = s.nextInt();
            long sc_arr[] = new long[(n/2)+1];
            long scount = 0 ;
            int prev=-1;
            int diff=0;
            int sub=0;
            long ans=0;
            int revcount = 1;
            long presc = 0;
            int cond = n%2==0? n/2 : (n/2)+1;
            for(int i=0;i<n;i++){
                int num = s.nextInt();
                if(i<cond){
                scount = scount + ((long)n - (2 * (long)i ));
                sc_arr[i] = scount;
                }
                else{
                    scount = sc_arr[(n/2)-revcount];
                    revcount++;
                }
                
                if(num > k ){
                    sub = 0;
                    ans = ans+scount;
                    if(prev!=-1){
                        if(num >= prev){
                            
                            int tc = i%2==0? (i/2) : (i/2)+1;
                            if(diff>tc){
                                diff = i%2==0? (tc - (diff - tc))+1: tc - ((diff-tc));
                            }
                            for(int c=1;c<=diff;c++){
                                sub = sub + (i - (2*(c-1)));
                            }
                            ans = ans + sub - presc;
                        }
                        else{
                            int rem = (n-i)+(diff-1);
                            int tc2 = rem%2==0? (rem/2) : (rem/2)+1;
                            if(diff>tc2){
                                 diff = rem%2==0? (tc2 - (diff - tc2))+1: tc2 - ((diff-tc2));
                            }
                            for(int c=1;c<=diff;c++){
                                sub = sub +(rem - (2*(c-1)));
                            }
                            ans = ans + sub - scount;
                        }
                        //System.out.println(num+" "+sub);
                    }
                    
                        prev = num;
                        presc = scount;
                        diff=1;
                    
                }
                else{
                    diff++;
                }
               // System.out.println(num+" "+ans);
            }
            System.out.println(ans);
            t--;
        }
        
    }
}
