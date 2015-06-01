package gud;

import java.util.ArrayList;

public class Allpermutation {
	static int length,count=0;
	static public void permutate(ArrayList<Integer> arr,int start,int size){
		int j;
		if(start==size){
			for(int i=0;i<4;i++){
				System.out.print(arr.get(i));
			}
			System.out.println();
		}
		else{
			for(j = start;j<size;j++){
				int t = arr.get(start);
				arr.set(start, arr.get(j));
				arr.set(j, t);
				permutate(arr,start+1,size);
				t = arr.get(start);
				arr.set(start, arr.get(j));
				arr.set(j, t);
			}
		}
	}
	
		public static void main(String args[]){
			ArrayList<Integer> arr = new ArrayList<Integer>();
			ArrayList<Integer> arr2 = new ArrayList<Integer>();
			length = 4;
			arr.add(1);
			arr.add(2);
			arr.add(3);
			arr.add(4);
			permutate(arr,0,arr.size());
		}
}
