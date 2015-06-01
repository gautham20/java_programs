package gud;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class almostsort {
    
    public static int[] reverse(int l,int r,int[] arr){
        int temp[] = new int[r-l+1];
        int c =0;
        for(int i=r;i>=l;i--){
            temp[c] = arr[i];
            c++;
        }
        int f=l;
        for(int g=0;g<=(r-l);g++){
            arr[f] = temp[g];
            f++;
        }
        return arr;
    }
    
    public static boolean sorted(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       int n = s.nextInt();
       int arr[] = new int[n];
       boolean slope[] = new boolean[n];
       
       slope[0] = true;
        if(n==2){
            slope[0] = false;
        }
       for(int i=0;i<n;i++){
           arr[i] = s.nextInt();
           if(i>0){
               slope[i] = arr[i]-arr[i-1]>=0;
           }
       }
           boolean flag = false;
           boolean first = true;
           boolean range = false;
           int l=0;
           int r=0;
           for(int i=1;i<n && n>2;i++){
               if(slope[i]==false && !flag){
            	   System.out.println(i +" "+ arr[i-1]);
                   if(first){
                   l = i-1;
                   first = false;
                   }
                   if(slope[i-1]){
                       if(i+1==n){
                       flag = true;
                       }
                       else if(slope[i+1]){ flag =true;}
                   }
                   else{
                       range = true;
                   }
                   if(range){
                       for(int k=l+1;k<n;k++){
                           if(slope[k]){
                               break;
                           }
                           r=k;
                       }
                       break;
                   }
               }
               else if(slope[i]==false && flag){
            	   
                   if(slope[i-1]){
                       if(arr[i]<=arr[l+1]&& arr[l]>=arr[i-1]){
                    	   System.out.println(i +" "+ arr[i]);
                           boolean ro= false;
                           boolean lf = false;
                           boolean swap1 = false,swap2 = false;
                           if(l-1==-1){
                               lf = true;
                               swap1 = true;
                           }
                           if(!lf){
                               if(arr[l-1]<=arr[i]){
                                   swap1 = true;
                               }
                           }
                           if(i+1==n){
                        	   ro= true;
                        	   swap2= true;
                           }
                           if(!ro){
                                if(arr[l]<=arr[i+1]){
                                	swap2= true;
                           }
                           }
                           if(swap1 && swap2){
                        	   int temp = arr[l];
                               arr[l] = arr[i];
                                arr[i] = temp;
                               r = i;
                           }
                       }
                   }
               }
           }
               if(range){
                    arr = reverse(l,r,arr);
               }
               if(sorted(arr)){
                   System.out.println("yes");
                   if(range){
                       System.out.print("reverse ");
                   }
                   else{
                       System.out.print("swap ");
                   }
                   l++; r++;
                   System.out.print(l+" "+r);
               }
               else if(n==2){
                   int t = arr[0];
                   arr[0] = arr[1];
                   arr[1] = t;
                   if(sorted(arr)){
                       l = 0; r =1;
                       System.out.println("yes");
                   if(range){
                       System.out.print("reverse ");
                   }
                   else{
                       System.out.print("swap ");
                   }
                   l++; r++;
                   System.out.print(l+" "+r);
                   }
               }
               else
                   System.out.println("no");
               
           }
           
       }


