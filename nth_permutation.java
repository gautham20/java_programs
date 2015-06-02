package gud;

import java.util.Scanner;

public class nth_permutation {
	
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		int fact[] = new int[n];
		fact[0]=1;
		for(int i=1;i<n;i++){
			fact[i] = fact[i-1]*(i+1);
 		}
		for(int i=0;i<n;i++){
			arr[i]=s.nextInt();
		}
		int perm = s.nextInt();
		int pre_num = -1;
		int pre_num_c = 1;
		while(0!=perm){
			int num;
			for(num=n-1;num>0;num--){
				//System.out.println(fact[num]);
				if(fact[num]<=perm){
					perm-=fact[num];
					//System.out.println(fact[num]+" "+perm);
					break;
				}
			}
				num = (n-num)-2;
				if(pre_num==num){
					pre_num_c++;
				}
				else{
					pre_num = num;
					pre_num_c=1;
				}
				int temp = arr[num];
				arr[num] = arr[num+pre_num_c];
				arr[num+pre_num_c] = temp;
				
			}
		
		
		for(int f:arr){
			System.out.print(f+" ");
		}
		
	}

}

