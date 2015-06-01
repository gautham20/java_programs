package gud;

import java.util.Scanner;
import java.util.Vector;
public class cubesummation {
	  public static void main(String[] args) {
	       Scanner s = new Scanner(System.in);
	        int t = s.nextInt();
	        long start = System.nanoTime();
	        while(t>0){
	        	int n = s.nextInt();
	            long arr[][][] = new long[n][n][n];
	            boolean rows[] = new boolean[100];
	            boolean cols[] = new boolean[100];
	            boolean deps[] = new boolean[100];
	            
	            int m = s.nextInt();s.nextLine();
	            while(m>0){
	            	String op = s.next();
	            	//System.out.println(op+m);
	                if(op.compareTo("UPDATE")==0){
	                	//System.out.println("here");
	                    int x = (s.nextInt()-1);
	                    rows[x] = true;
	                    int y = (s.nextInt()-1);
	                    cols[y] = true;
	                    int z = (s.nextInt()-1);
	                    deps[z] = true;
	                    long w = s.nextLong();
	                    arr[x][y][z] = w;
	                    System.out.println("updated"+w);
	                   
	                }
	                else {
	                    int x1 = (s.nextInt()-1);
	                     int y1 = (s.nextInt()-1);
	                     int z1 = s.nextInt()-1;
	                     int x2 = s.nextInt()-1;
	                     int y2 = s.nextInt()-1;
	                     int z2 = s.nextInt()-1;
	                    long sum=0;
	                    for(int i=x1;i<=x2 ;i++){
	                    	if(rows[i]){
	                        for(int j=y1;j<=y2;j++){
	                        	if(cols[j]){
	                            for(int k=z1;k<=z2;k++){
	                            	if(deps[k]){
	                                sum = sum+arr[i][j][k];
	                            	}
	                            }
	                        	}
	                        }
	                    	}
	                    }
	                    System.out.println(sum);
	                }
	                m--;
	            }
	           
	            t--;
	        }
	        long time = System.nanoTime() - start;
	        System.out.printf("Time to compute: %5.2f seconds.%n", time / 1.0e9);
	    }
	}