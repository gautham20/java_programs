package gud;

import java.util.Scanner;

public class Insertion_sort {
	public static void main(String args[]){
		 Scanner s = new Scanner(System.in);
		 int n = s.nextInt();
		 int a[] = new int[n];
		 for(int i=0;i<n;i++){
			 a[i]=s.nextInt();
		 }
		 for(int i=1;i<n;i++){
			 int key = a[i];
			 int j = i-1;
			 while(j>=0 && a[j]>key){
				 a[j+1]=a[j];
				 j--;
			 }
			 a[j+1]=key;
			 for(int k=0;k<n;k++){
				 System.out.print(a[k]+" ");
			 }
			 System.out.println();
		 }
	}

}
