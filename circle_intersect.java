package gud;
import java.util.Scanner;
import java.text.DecimalFormat;
public class circle_intersect {
	
	Scanner s = new Scanner(System.in);
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();s.nextLine();
		while(t>0){
			int n = s.nextInt();
			int x1 = s.nextInt();
			int y1 = s.nextInt();
			int x2 = s.nextInt();
			int y2 = s.nextInt();s.nextLine();
			
			double d = Math.sqrt(((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)));
			
			int[] ar1 = new int[n];
			for(int x=0;x<n;x++){
				ar1[x] = s.nextInt();
			}
			s.nextLine();
			int[] ar2 = new int[n];
			for(int x=0;x<n;x++){
				ar2[x] = s.nextInt();
			}
			
			int R = getLeast(ar1,n);
			int r = getLeast(ar2,n);
			
			if(R<r){
				int temp = R;
				R = r;
				r = temp;
			}
			
			double ans ;
			
			if((R+r)>d && (R-r)<d){
			double part1 = r*r*Math.acos((d*d + r*r - R*R)/(2*d*r));
			double part2 = R*R*Math.acos((d*d + R*R - r*r)/(2*d*R));
			double part3 = 0.5*Math.sqrt((-d+r+R)*(d+r-R)*(d-r+R)*(d+r+R));
			
			ans = part1 + part2 - part3;
			
			}
			
			else if((R-r)>=d){
				ans = 3.1415926535*(r*r);
			}
			
			else{
				ans = 0.00;
			}
			
			String a = new DecimalFormat("########.##").format(ans);
			
			if(!a.contains(".")){
				a=a+".00";
			}
			
			if(a.charAt(a.length()-2)=='.'){
				
				String anew = a+"0";
				System.out.println(anew);
			}
			else
					System.out.println(a);
			
			
			t--;
		}
		
			
		}
	
		static int getLeast(int[] a, int n){
			int least = a[0];
			for(int i=0;i<n;i++){
				if(a[i]<least){
					least = a[i];
				}
			}
			
			return least;
			
	}
}
