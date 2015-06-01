package gud;

import java.util.Random;
import java.util.Scanner;

public class randomized_quicksort {
static Random rn = new Random();
	
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();s.nextLine();
		int a[] = new int[n];
		for(int x=0;x<n;x++){
			a[x] = s.nextInt();
		}
		randamized_q_sort(a,0,(n-1));
		for(int y:a)
		{
			System.out.print(y+" ");
		}
	}


static void randamized_q_sort(int[] a,int p,int r){
	if(p<r){
	int q=randamized_partition(a,p,r);
	randamized_q_sort(a,p,(q-1));
	randamized_q_sort(a,(q+1),r);
	}
}

static int randamized_partition(int[] a,int p,int r){
	int ran = rn.nextInt((r-p)+1)+p;
	int t = a[p];
	a[p]= a[ran];
	a[ran]=t;
	return partition(a,p,r);
}

static int partition(int[] a,int p,int r){
	int key=a[p];
	int i = p;
	int j = r;
	while(true){
		 while(a[i]<key){ i=i+1; }
		 while(a[j]>key){ j=j-1; }
		if(i<j){
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
		else
			return j;
	}
}
}



