package gud;

import java.util.Scanner;

public class cubesummation2 {
	
	  public static void main(String[] args) {
	       Scanner s = new Scanner(System.in);
	        int t = s.nextInt();
	        
	        //long start = System.nanoTime();
	        while(t>0){
	        	int ucount=0;
	        	int n = s.nextInt();
	            int m = s.nextInt();s.nextLine();
	           
	            element e[] = new element[m];
	            while(m>0){
	            	String op = s.next();
	            	//System.out.println(op+m);
	                if(op.compareTo("UPDATE")==0){
	                	//System.out.println("here");
	                    int x = s.nextInt();
	                    int y = s.nextInt();
	                    int z = s.nextInt();
	                    long w = s.nextLong();
	                    boolean flag = false;
	                    for(int i=0;i<ucount;i++){
	                    	if(e[i].x==x && e[i].y==y && e[i].z==z){
	                    		e[i].val = w;
	                    		flag = true;
	                    		break;
	                    	}
	                    }
	                    if(!flag)
	                    {
	                    e[ucount] = new element(x,y,z,w); 
	                    ucount++;
	                    }
	                   
	                }
	                else {
	                    int x1 = s.nextInt();
	                     int y1 = s.nextInt();
	                     int z1 = s.nextInt();
	                     int x2 = s.nextInt();
	                     int y2 = s.nextInt();
	                     int z2 = s.nextInt();
	                    long sum=0;
	                   
	                    for(int i=0;i<ucount;i++){
	                    	if(e[i].x >= x1 && e[i].x <=x2 &&
                    		   e[i].y >= y1 && e[i].y <=y2 &&
                    		   e[i].z >= z1 && e[i].z <=z2 ){
	                    		sum = sum + e[i].val;
	                    	}
	                    }
	                    System.out.println(sum);
	                    
	                }
	                m--;
	            }
	            
	            t--;
	        }
	        //long time = System.nanoTime() - start;
	       // System.out.printf("Time to compute: %5.2f seconds.%n", time / 1.0e9);
	    }
	}

class element{
	public int x;
	public int y;
	public int z;
	public long val;
	public element(int x,int y,int z,long val){
		this.x = x;
		this.y = y;
		this.z = z;
		this.val = val;
		//System.out.println("updated" + val);
	}
}