
public class StackAsList<T> implements Stack<T>{

	Node first;
	
	public void push(T elem) {
		newNode(elem);
	}
	
	public T pop() {
		if(isEmpty()) throw new 
		T elem= first.element;
		first=first.next;
		return elem;
	}
	public boolean isEmpty() {
		if (first.equals(null))return true;
		else return false;
	}
	public T peek() {
		if (first!=null)return first.element;
		else return null;
		
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
	

	public String toString() {
		Node node=first;
		String string="";
		while(node!=null) string+=node.element+" ";
		return string;
	}	

	public Node getNext(Node node) {
		return node.next;
	}
}
