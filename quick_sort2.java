package gud;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class quick_sort2 {

	
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
	q_sort(a,p,(q-1));
	q_sort(a,(q+1),r);
	for(int i=p;i<=r;i++){
		System.out.print(a[i]+" ");
	}
	System.out.println();
	}
}

static int partition(int[] a,int p,int r){
	int key=a[p];
	
	int lc = 0;
	int uc = 0;
	ArrayList<Integer> l = new ArrayList(r-p);
	ArrayList<Integer> u = new ArrayList(r-p);
	for(int i=p+1;i<=r;i++){
		if(a[i]<=key){ l.add(a[i]); }
		else { u.add(a[i]); }
	}
	int count=p;
	for(int c=0;c<l.size();c++){
		a[count] = l.get(c);
		count++;
	}
	a[count]=key;
	int ans = count++;
	for(int c=0;c<u.size();c++){
		a[count] = u.get(c);
		count++;
	}
	
	return ans;
	
}
}


