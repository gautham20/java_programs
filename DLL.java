package gud;

class DLLNode<T> {
	T element;
	public DLLNode<T> next,prev;
	public DLLNode(){
		next = null;
		prev = null;
	}
	public DLLNode(T element){
		this.element = element;
	    next = null;
	    prev = null;
	}
	public DLLNode(T element, DLLNode next, DLLNode prev){
		this.element = element;
		this.next = next;
		this.prev = prev;
	}
}

public class DLL<T> {
	private DLLNode<T> head,tail;
	public DLL(){
		head = tail = null;
	}
	
	public boolean isEmpty(){
		return head==null;	
	}
	
	public int getSize(){
		DLLNode<T> temp;
		int size = 0;
		for(temp = head ; temp!= null ; temp = temp.next ){
			size++;
		}
		return size;
	}
	
	public boolean addAtHead(T element){
		if(!isEmpty()){
		head = new DLLNode<T>(element,head,null);
		head.next.prev = head;
		return true;
		}
		else{
			head = tail = new DLLNode<T>(element,null,null);
			return true;
		}
		
	}
	
	public boolean addAtTail(T element){
		if(!isEmpty()){
			tail = new DLLNode<T>(element,null,tail);
			tail.prev.next = tail;
			return true;
		}
		else{
			head = tail = new DLLNode<T>(element,null,null);
			return true;
		}
	}
	
	public boolean addAtPos(int pos,T element){
		if(pos == 1){
			 return addAtHead(element);
		}
		else if(getSize()==pos){
			return addAtTail(element);
		}
		else if(getSize()>pos){
		DLLNode<T> new_node,temp;
		int count;
		for(temp = head, count = 1 ; count<(pos-1) && temp!= null ; temp = temp.next){
			count++;
		}
		new_node = new DLLNode<T>(element,temp.next,temp);
		temp.next = new_node;
		new_node.next.prev = new_node;
		return true;
		}
		else
			return false;
	}
	
	public T deleteAtHead(){
		if(!isEmpty()){
			T temp = head.element;
			if(head==tail){
				head = tail =null;
				return temp;
			}
			else{
			head = head.next;
			head.prev = null;
			return temp;
			}
		}
		else{
			return null;
		}
	}
	
	public T deleteAtTail(){
		if(!isEmpty()){
			T temp = tail.element;
			if(head==tail){
				head=tail=null;
				return temp;
			}
			else{
				tail = tail.prev;
				tail.next = null;
				return temp;
			}
		}
		else
			return null;
	}
	
	public boolean delete(T key){
		if(!isEmpty()){
			DLLNode<T> temp;
			for(temp = head; temp.element!=key && temp!= null ; temp = temp.next);
			if(temp==null){
				return false;
			}
			else if(temp==head){
				T temp_ele = deleteAtHead();
				return true;
			}
			else if(temp==tail){
				T temp_ele = deleteAtTail();
				return true;
			}
			else{
				temp.prev.next = temp.next;
				temp.next.prev = temp.prev;
				return true;
			}	
		}
		else
			return false;
	}
	
	public int find ( T key){
		DLLNode<T> temp;
		int pos = 1;
		for(temp = head ; temp.element != key && temp!=null ; temp = temp.next ){
			pos++;
		}
		if(temp==null){
			return -1;
		}
		else
			return pos;
	}
	
	public void printAll(){
		DLLNode<T> temp;
		for(temp = head; temp!= null ; temp= temp.next){
			System.out.print(temp.element+" ");
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		DLL<Integer> dllo = new DLL<Integer>();
		System.out.println("isEmpty()" + dllo.isEmpty());
		for(int i=3 ; i<7 ; i++){
		dllo.addAtTail(i);
		}
		//System.out.println("size "+dllo.getSize());
		dllo.addAtPos(2, 10);
		dllo.addAtPos(1,20);
		dllo.addAtPos(6, 50);
		System.out.println("size "+dllo.getSize());
		dllo.printAll();
		System.out.println(dllo.delete(50));
		System.out.println(dllo.deleteAtHead());
		System.out.println(dllo.deleteAtTail());
		System.out.println(dllo.find(4));
		dllo.printAll();
		
	}
}
