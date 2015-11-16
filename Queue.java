public class Queue {
	Node first;
	int length;
	
	public Queue(int init_length)
	{
		first = null;
		length = init_length;
	}
	
	public int length()
	{
		int length = 0;
		Node cursor = first;
		while(cursor != null)
		{
			length++;
			cursor = cursor.next;
		}
		System.out.println("Length of the queue is currently:");
		System.out.println(length);
		System.out.println("xxxxxxx");
		return (length);
	}
	
	public void printQueue()
	{
		Node cursor = first;
		while(cursor != null)
		{
			System.out.println(cursor.element.groceries);
			cursor = cursor.next;
		}
		
	}
	
	public void enqueue(Customer new_customer)
	{
		Node cursor = first;
		if (first == null)
		{
			first = new Node(new_customer);
		}
		else
		{
			while(cursor.next != null)
			{
				cursor = cursor.next;
			}
			cursor.next = new Node(new_customer);
		}
		
	}
	
	public void dequeue()
	{
		if(first == null)
		{
			System.out.println("Trying to dequeue already empty queue LOL");
		}
		else
		{
			if(first.next == null)
			{
				first = null;
			}
			else
			{
				first = first.next;
			}
			
		}
	}
	
	
	public Customer first()
	{
		return first.element;
	}
}
