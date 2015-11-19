public class Node {
	Node next;
	Customer element;
	
	//Konstruktorn för Noder
	public Node(Customer init_Customer)
	{
		element = init_Customer;
		next = null;
	}
	