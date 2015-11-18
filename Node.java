public class Node {
	Node next;
	Customer element;
	
	//Konstruktorn f�r Noder
	public Node(Customer init_Customer)
	{
		element = init_Customer;
		next = null;
	}
	
	public Node get_nextCustomer()
	{
		return next;
	}
	
	public void set_nextNode(Node next_node)
	{
		next = next_node;
	}
}
