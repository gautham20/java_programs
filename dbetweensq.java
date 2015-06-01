package gud;

import java.util.Scanner;

public class dbetweensq {
	public static void main(String args[]){
		 Scanner s = new Scanner(System.in);
		 long L = s.nextLong();
		 double stdd = L*Math.sqrt(2);
		 long s1 = s.nextLong();
		 long s2 = s.nextLong();
		 int q = s.nextInt();
		 while(q>0){
			 long qi = s.nextLong();
			 Double dd = Math.sqrt(qi)*Math.sqrt(2);
			 dd = stdd - dd;
			 Double time = dd/Math.abs(s1-s2);
			 System.out.println(time);
			 q--;
		 }
	}
}
