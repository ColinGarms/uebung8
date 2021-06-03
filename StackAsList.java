
public class StackAsList<T> implements Stack<T>{

	Node first;
	
	public void push(T elem) {
		newNode(elem);
	}
	
	public T pull() {
		T elem= first.element;
		first=first.next;
		return elem;
	}
	public boolean isEmptly() {
		if (first.equals(null))return true;
		else return false;
	}
	public T peek() {
		return first.element;
	}
	
	public void newNode(T elem) {
		Node newNode= new Node();
		newNode.element= elem;
		newNode.next= first;
		first= newNode;
				
	}
	
	
	class Node{
		T element;
		Node next;
	}
	
}
