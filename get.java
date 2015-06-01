package gud;
import java.util.Scanner;

public class get { 
	public static void main(String args[])
	{

		Scanner s = new Scanner(System.in);
		int t= s.nextInt();s.nextLine();
		while(t>0){
		String rk = s.nextLine();
		char[] rkarr = rk.toCharArray();
		int len = rk.length();
		int[] arr = new int[len];
		for(int i=0;i<len;i++){
			if(rk.charAt(i)=='R'){
				arr[i]=-1;
			}
			else
				arr[i]=1;
		}
	
		
		int[] region = maxsubarray(arr,0,len-1);
		
		
		System.out.println(region[0]+"  "+region[1]);
		
		
		for(int i=region[0];i<=region[1];i++){
			if(rkarr[i]=='K'){
				rkarr[i]='R';
			}
			else
				rkarr[i]='K';
		
		
		}
		int count=0;
		for(int i=0;i<len;i++){
			if(rkarr[i]=='R'){
				count++;
			}
		}
		
		System.out.println(count);
		
		t--;
		}
	}
	
	static int[] maxsubarray(int[] arr, int low, int high){
		int[] region=new int[3];
		int[] lregion=new int[3];
		int[] rregion=new int[3];
		int[] mregion=new int[3];
		if(low==high){
			region[0]=region[1]=low;
			region[2]=arr[low];
			return region;
		}
		else{
			int mid = (low+high)/2;
			lregion = maxsubarray(arr,low,mid);
			rregion = maxsubarray(arr,mid+1,high);
			mregion = crossmaxsubarray(arr,low,mid,high);
			if(lregion[2]>rregion[2]&&lregion[2]>mregion[2])
				return lregion;
			if(rregion[2]>lregion[2]&&rregion[2]>mregion[2])
				return rregion;
			else
				return mregion;
		}
	}
	
	static int[] crossmaxsubarray(int[] arr,int low,int mid,int high){
		int sum=0,leftsum=-1111111,rightsum=-1111111;
		int[] mregion = new int[3];
		for(int i=mid;i>=low;i--){
			sum+=arr[i];
			if(sum>leftsum){
				leftsum = sum;
				mregion[0]=i;
			}
		}
		sum=0;
		for(int i=mid;i<=high;i++){
			sum+=arr[i];
			if(sum>rightsum){
				rightsum = sum;
				mregion[1]=i;
			}
		}
		mregion[2]=leftsum+rightsum;
		return mregion;
	}

}
	
	
