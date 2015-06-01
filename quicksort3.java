package gud;

import java.util.ArrayList;
import java.util.Scanner;

public class quicksort3 {
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();s.nextLine();
		int a[] = new int[n];
		for(int x=0;x<n;x++){
			a[x] = s.nextInt();
		}
		q_sort(a,0,(n-1));
	}


static void q_sort(int[] a,int p,int r){
	if(p<r){
	int q=partition(a,p,r);
	for(int i=0;i<a.length;i++){
		System.out.print(a[i]+" ");
	}
	System.out.println();
	q_sort(a,p,(q-1));
	q_sort(a,(q+1),r);
	
	}
}

static int partition(int[] a,int p,int r){
	int key=a[r];
	int i = p;
	int j = p;
	while(true){
		 while(a[i]>key){ i=i+1; }
		 if(i==p){
		 while(a[j]<key){ j=j+1; }
		 }
		if(i>j){
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
		else{
			i++;
		}
		if(i>j){
			 while(a[j]<key){ j=j+1; }
			 }
		if(a[j]==key){
			return j;
		}
	}
}
}



