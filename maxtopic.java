package gud;

import java.util.Scanner;

public class maxtopic {
	static Scanner s = new Scanner(System.in);
	 static int n = s.nextInt();
	 static int m= s.nextInt();
	 static int maxto = 0, maxte = 0;
	 public static void main(String args[]){
		 s.nextLine();
		 String mat[] = new String[n];
		 for(int i=0;i<n;i++){
			 mat[i] = s.nextLine();
			 }
		 for(int r=0;r<(n-1);r++){
		 for(int k=r+1;k<n;k++){
			 int to = findto(mat[r],mat[k]);
			 if(to>maxto){
				 maxto = to;
				 maxte = 1;
			 }
			 else if(to == maxto){
				 maxte++;
			 }
			 else{
			 }
		 }

		 }
		 
		 System.out.println(maxto);
		 System.out.println(maxte);
	 }
	 
	 static int findto(String r1, String r2){
		 int count=0;
		 for(int i=0;i<m;i++){
			 if(r1.charAt(i)=='1' ||r2.charAt(i)=='1'){
				 count++;
			 }
		 }
		 return count;
	 }
}
