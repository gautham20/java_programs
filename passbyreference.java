package gud;

class value{
	int v = 0;
	value(int n){
		v = n;
	}
}

public class passbyreference {
	
	public static void incr(value vo){
		vo.v++;
	}
	
	public static void incr_int(int v){
		v++;
	}
	
	public static void main(String args[]){
		value v = new value(5);
		int n = 6;
		System.out.println(v.v+" "+n);
		incr(v);
		incr_int(n);
		System.out.println(v.v+" "+n);
	}

}
