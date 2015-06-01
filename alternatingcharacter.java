package gud;

import java.util.Scanner;

public class alternatingcharacter {
	 public static void main(String args[]){
		 Scanner s = new Scanner(System.in);
		 int t = s.nextInt();s.nextLine();
		 while(t>0){
			 int count=0;
			 String str = s.nextLine();
			 char[] sa = str.toCharArray();
			 for(int i=1;i<str.length();i++){
				 if(sa[i-1]==sa[i]){
					 count++;
				 }
			 }
			 System.out.println(count);
			 t--;
		 }
	 }
}
