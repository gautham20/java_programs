package gud;
import java.util.Scanner;
public class maxXor {
  public static void main(String args[]){
	  Scanner s = new Scanner(System.in);
	  int l = s.nextInt();s.nextLine();
	  int j = s.nextInt();s.nextLine();
	  int diff = j^l;
	  double power = Math.ceil((Math.log(diff)/Math.log(2)));
	  int result = (int)Math.pow(2, power) - 1;
	  System.out.println(result);
  }
}
