public class Node {
	Node next;
	Customer element;
	
	//Konstruktorn f�r Noder
	public Node(Customer init_Customer)
	{
		element = init_Customer;
		next = null;
	}
	