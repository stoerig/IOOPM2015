public class Queue {
	Node first;
	Node last;
	int length;
	
	public Queue()
	{
		first = null;
		last = null;
		length = 0;
	}
	
	public int length()
	{
		int current_length = 0;
		Node cursor = first;
		while(cursor != null)
		{
			current_length++;
			cursor = cursor.next;
		}
		System.out.println("Length of the queue is currently:");
		System.out.println(current_length);
		System.out.println("xxxxxxx");
		length = current_length;
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
		if (first == null)
		{
			first = new Node(new_customer);
			last = first;
		}
		else
		{
			
			last.next = new Node(new_customer);
			last = last.next;
			
			/*
			while(cursor.next != null)
			{
				cursor = cursor.next;
			}
			cursor.next = new Node(new_customer);
			*/
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
