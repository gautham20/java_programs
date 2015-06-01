package gud;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class heapSortfull {
    static class order{
        public int atime = 0;
        public int dur = 0;
        public order(int a,int b){
            atime = a;
            dur = b;
        }
    }
    
    static void minheapify(int i){
        int smallest = heap[i].dur;
        int pos = i;
        if(((2*i)+1)<heapsize){
            int lkey = heap[(2*i)+1].dur;
            if(lkey<smallest){ smallest = lkey; pos = (2*i)+1; }
        }
        if(((2*i)+2)<heapsize){
            int rkey = heap[(2*i)+2].dur;
            if(rkey<smallest){ smallest = rkey; pos = (2*i)+2; }
        }
        if(smallest!=heap[i].dur){
            order temp = heap[i];
            heap[i] = heap[pos];
            heap[pos] = temp;
            minheapify(pos);
        }
    }
    
    static void maxheapify(int i){
    int largest = input[i].atime;
        int pos = i;
        if(((2*i)+1)<heapsize2){
            int lkey = input[(2*i)+1].atime;
            if(lkey>largest){ largest = lkey; pos = (2*i)+1; }
        }
        if(((2*i)+2)<heapsize2){
            int rkey = input[(2*i)+2].atime;
            if(rkey>largest){ largest = rkey; pos = (2*i)+2; }
        }
        if(largest!=input[i].atime){
            order temp = input[i];
            input[i] = input[pos];
            input[pos] = temp;
            maxheapify(pos);
        }
    }
    
    
    static order extractmin(){
        if(heapsize==0){ return null;}
        order min = heap[0];
        heap[0] = heap[heapsize-1];
        heapsize--;
        minheapify(0);
        return min;
    }
    
    static void insert(order in){
        heap[heapsize] = new order(0,Integer.MAX_VALUE);
        heapsize++;
        decreasekey(heapsize-1,in.atime,in.dur);
    }
    
    static void decreasekey(int pos,int atime,int dur){
        heap[pos].atime = atime;
        heap[pos].dur = dur;
        while(pos>=0 && heap[(pos-1)/2].dur>heap[pos].dur){
            order cur = heap[pos];
            heap[pos] = heap[(pos-1)/2];
            heap[(pos-1)/2] = cur;
            pos = (pos-1)/2;
        }
    }
    
    static void buildmaxheap(order[] input){
        int cond = heapsize2%2==0? (heapsize2-1)/2 : (heapsize)/2;
        for(int i=cond+1;i>=0;i--){
            maxheapify(i);
        }
    }
    
    static void heapsort(order[] input){
        heapsize2 = input.length;
        buildmaxheap(input);
        for(int i = (heapsize2-1);i>=1;i--){
            order min = input[0];
            input[0] = input[i];
            input[i] = min;
            heapsize2--;
            maxheapify(0);
        }
    }
    
    static order heap[];
    static order input[];
    static int heapsize = 0;
    static int heapsize2 = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        input = new order[n];
        heap = new order[n];
        long ans = 0;
        long tt = 0;
        for(int i=0;i<n;i++){
            int a = s.nextInt();
            int b = s.nextInt();
            input[i] = new order(a,b); 
        }
        heapsort(input);
        int count = 0;
        int hcount = 0;
        while(count<n || hcount<n){
            if(count < n ){
            if(count == 0) { tt = input[count].atime; }
            while(count<n){
                if(input[count].atime <= tt){
                    insert(input[count]);
                    count++;
                }
                else
                    break;
            }
            }
            if(hcount<n){
            order min = extractmin();
            ans = ans + (tt - min.atime) + min.dur;
            tt = tt + min.dur;
            hcount++;
            }
           
        }
         System.out.println(ans/n);
}
    }