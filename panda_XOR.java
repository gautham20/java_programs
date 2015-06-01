package gud;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class panda_XOR {
	static HashMap<Integer,Integer> hm = new HashMap();
	static Set set;
	static Iterator i;
	static Map.Entry me;
	static Scanner s = new Scanner(System.in);
	public static void main(String args[]){
		int n = s.nextInt();
		int[] a = new int[n];
		for(int i = 0;i<n;i++)
		{
			a[i]=s.nextInt();
		}
		pandamaxor(a);
			
		}
	
	  public static void pandamaxor(int[] arr) {
		    
		    int powerset_size = (int) Math.pow(2, arr.length);
		    int maxor=0;
		    for(int count = 1 ; count<powerset_size;count++){
		    	maxor = 0;
		    	for(int i=0;i<arr.length;i++){
		    		if((count & (1<<i))!=0){
		    			maxor = maxor^arr[i];
		    		}	
		    	}
		    	if(hm.containsKey(maxor)){
    				int val = hm.get(maxor);
    				val++;
    				hm.put(maxor,val);
    			}
    			else{
    				hm.put(maxor,1);
    			}
		    }
	    	maxorsum();
		  }
	  
	  static void maxorsum(){
		  long sum=0;
		  int val;
		  set = hm.entrySet();
	    Iterator i = set.iterator();
	    	while(i.hasNext())
	    	{
	    		me = (Map.Entry)i.next();
	    		val=(int)me.getValue();
	    		if(val>1){
	    			long nCk=1;
	    			for(int k=0;k<2;k++){
	    				 nCk = nCk * (val-k) / (k+1);
	    			}
	    			sum = sum + nCk;
	    			
	    		}
	    		
	    		}
	    	System.out.println(sum%1000000007);
	  }

}
