package gud;

import java.util.Scanner;

public class triangle_nums {
	
	public static int arr[];
	public static int sum;
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = s.nextInt();
		}
		sum = arr[0];
		maxsum(0,1);
		System.out.println(sum);
		
	}
	
	public static void maxsum(int index,int row){
		int left = index+row;
		int right = index+row+1;
		
		if(left<arr.length && right<arr.length){
			if(arr[left]>arr[right]){
				sum+=arr[left];
				maxsum(left,row+1);		
			}
			else if(arr[right]>arr[left]){
				sum+=arr[right];
				maxsum(right,row+1);
			}
			else{
				int temp = sum;
				maxsum(right,row+1);
				int if_right = sum;
				sum = temp;
				maxsum(left,row+1);
				int if_left = sum;
				if(if_right>if_left){
					sum = if_right;
					sum += arr[right];
				}
				else{
					sum = if_left;
					sum += arr[left];
				}
			}
		}
		else if(left<arr.length){
			sum+= arr[left];
		}
		
	}


}
