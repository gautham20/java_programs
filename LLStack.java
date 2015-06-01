package gud;
import java.util.Queue;
import java.util.LinkedList;

class StackX<T>{
	private LinkedList<T> stack = new LinkedList<T>();
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	public int getSize(){
		return stack.size();
	}
	
	public T peek(){
		return stack.getLast();
	}
	
	public void push(T element){
		stack.addLast(element);
	}
	
	public T pop(){
		return stack.removeLast();
	}
	
	public String toString(){
		return stack.toString();
	}
	
}

public class LLStack {
	public static void main(String args[]){
	
	StackX<Integer> s1 = new StackX<Integer>();
	for(int i=0;i<10;i++){
		s1.push(i);
	}
	System.out.println(s1.getSize());
	System.out.println(s1.pop());
	System.out.println(s1.toString());
	}
}
