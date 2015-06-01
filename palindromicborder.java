package gud;

import java.util.ArrayList;
import java.util.Scanner;

public class palindromicborder {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String st = s.nextLine();
        char arr[] = st.toCharArray();
       ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> b = new ArrayList<Integer>();
        ArrayList<Integer> c = new ArrayList<Integer>();
        ArrayList<Integer> d = new ArrayList<Integer>();
        ArrayList<Integer> e = new ArrayList<Integer>();
        ArrayList<Integer> f = new ArrayList<Integer>();
        ArrayList<Integer> g = new ArrayList<Integer>();
        ArrayList<Integer> h = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            switch(arr[i]){
                case 'a' : a.add(i);break;
                case 'b' : b.add(i);break;
                case 'c' : c.add(i);break;
                case 'd' : d.add(i);break;
                case 'e' : e.add(i);break;
                case 'f' : f.add(i);break;
                case 'g' : g.add(i);break;
                case 'h' : h.add(i);
            }
        } 
            int al = a.size();
            int bl = b.size();
            int cl = c.size();
            int dl = d.size();
            int el = e.size();
            int fl = f.size();
            int gl = g.size();
            int hl = h.size();
            
            long sum = 0;
            sum+= nc2(al);
            sum+= nc2(bl);
            sum+= nc2(cl);
            sum+= nc2(dl);
            sum+= nc2(el);
            sum+= nc2(fl);
            sum+= nc2(gl);
            sum+= nc2(hl);
            sum+= ss(a,al,arr);
            sum+= ss(b,bl,arr);
            sum+= ss(c,cl,arr);
            sum+= ss(d,dl,arr);
            sum+= ss(e,el,arr);
            sum+= ss(f,fl,arr);
            sum+= ss(g,gl,arr);
            sum+= ss(h,hl,arr);
            System.out.println(sum);
        }
        
    
    
    public static long nc2(int len){
        long l2 = (long)len;
        return (l2*(l2-1))/2;
        
    }
    
    public static long ss(ArrayList<Integer> temp,int len, char[] arr){
    	long count=0;
        for(int i=0;i<(len-1);i++){
        	for(int j=i+1 ; j<len; j++){
        		int t1,tt1,tt2,t2;
        		t1=tt1=temp.get(i);
        		t2=tt2=temp.get(j);
        		//System.out.println(t1+" "+t2);
        			//if((t2-t1)!=(arr.length)){ count++; }
        			ArrayList<Character> t = new ArrayList<Character>();
        			t.add(arr[tt1]);
        			while(t1<(tt2-1) && t2>(tt1+1)){
        				if(arr[++t1]==arr[--t2]){
        					t.add(arr[t1]);
        					if(isPalin(t)){
        					count++;
        					}
        					}
        					else
        						break;
        				
        			}

        	}
        }
        return count;
    }
    
    public static boolean isPalin(ArrayList<Character> t){
    	boolean flag=true;
    	for(int i=0,j = (t.size()-1);i<j;i++,j--){
    		if(t.get(i)!=t.get(j)){
    			flag = false;
    			break;
    		}
    	}
    	//System.out.println(flag+t.toString());
    	return flag;
    }
    
}