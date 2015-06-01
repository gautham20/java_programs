package gud;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
public class boardcutting {
	 static int m,n,marr[],narr[];
	    
	    static void maxheapify(int i,int[] input,int size){
	        int largest = input[i];
	        int pos = i;
	        if(((2*i)+1)<size){
	            int lkey = input[(2*i)+1];
	            if(lkey>largest){ largest = lkey; pos = (2*i)+1; }
	        }
	        if(((2*i)+2)<size){
	            int rkey = input[(2*i)+2];
	            if(rkey>largest){ largest = rkey; pos = (2*i)+2; }
	        }
	        if(largest!=input[i]){
	            int temp = input[i];
	            input[i] = input[pos];
	            input[pos] = temp;
	            maxheapify(pos,input,size);
	        }
	    }
	    
	    static void buildmaxheap(int[] input,int size){
	        if(size>1){
	        int cond = size%2==0? (size-1)/2 : (size)/2;
	        for(int i=cond+1;i>=0;i--){
	            maxheapify(i,input,size);
	        }
	        }
	    }
	    
	    static void heapsort(int[] input,int size){
	        buildmaxheap(input,size);
	        for(int i = (size-1);i>=1;i--){
	            int min = input[0];
	            input[0] = input[i];
	            input[i] = min;
	            size--;
	            maxheapify(0,input,size);
	        }
	    }
	    
	    public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
	        int t = s.nextInt();
	        while(t>0){
	            m = s.nextInt();m--;
	            n = s.nextInt();n--;
	            int m1=m-1,n1=n-1;
	            int mcut=1,ncut=1;
	            marr = new int[m];
	            narr = new int[n];
	            for(int i=0;i<m;i++){
	                marr[i] = s.nextInt();
	            }
	            for(int j=0;j<n;j++){
	                narr[j] = s.nextInt();
	            }
	            heapsort(marr,m);
	            heapsort(narr,n);   
	            BigInteger ans = new BigInteger("0");
	            while(m1>=0 || n1>=0){
	           
	              
	                if(m1==-1){
	                    //ans = ans+((long)narr[n1]*(long)mcut);
	                    ans = ans.add((new BigInteger(Integer.toString(narr[n1]))).multiply((new BigInteger(Integer.toString(mcut)))));
	                    n1--;
	                    ncut++;
	                }
	                else if(n1==-1){
	                    //ans = ans+(((long)marr[m1])*((long)ncut));
	                    ans = ans.add((new BigInteger(Integer.toString(marr[m1]))).multiply((new BigInteger(Integer.toString(ncut)))));
	                    m1--;
	                    mcut++;
	                }
	                else if(marr[m1]<narr[n1]){
	                    //ans = ans+(((long)narr[n1])*((long)mcut));
	                    ans = ans.add((new BigInteger(Integer.toString(narr[n1]))).multiply((new BigInteger(Integer.toString(mcut)))));
	                    n1--;
	                    ncut++;
	                }
	                else if(marr[m1]==narr[n1]){
	                    if(mcut>ncut){
	                        //ans = ans+(((long)marr[m1])*((long)ncut));
	                        ans = ans.add((new BigInteger(Integer.toString(marr[m1]))).multiply((new BigInteger(Integer.toString(ncut)))));
	                        m1--;
	                        mcut++;
	                    }
	                    else{
	                        //ans = ans+(((long)narr[n1])*((long)mcut));
	                        ans = ans.add((new BigInteger(Integer.toString(narr[n1]))).multiply((new BigInteger(Integer.toString(mcut)))));
	                    n1--;
	                    ncut++;
	                    }
	                        
	                }
	                else{
	                    //ans = ans+(((long)marr[m1])*((long)ncut));
	                    ans = ans.add((new BigInteger(Integer.toString(marr[m1]))).multiply((new BigInteger(Integer.toString(ncut)))));
	                    m1--;
	                    mcut++;
	                }
	                
	            }
	           
	                 System.out.println(ans.mod(new BigInteger("1000000007"))) ;
	                  t--;
	     
	    }
	}
	}