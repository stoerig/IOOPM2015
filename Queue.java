public class Queue {
	Node first;
	Node last;
	int length;
	
	public Queue(int init_length)
	{
		first = null;
		last = null; 
		length = init_length;
	}
	
	public int length()
	{
		int length = 0;
		for(Node cursor = first; cursor.next != null; cursor = cursor.next)
		{
			length++;
		}
		System.out.println("Length of the queue is currently: \n");
		System.out.println(length);
		return length;
	}
	
	public void printQueue()
	{
		System.out.println(first.element.groceries);
		System.out.println(first.next.element.groceries);
		System.out.println(last.element.groceries);
		
	}
	
	public void enqueue(Customer new_customer)
	{
		if (first == null)
		{
			first = new Node(new_customer);
			last = first.next;
		}
		else
		{
			if(last == null)
			{				
				last = new Node(new_customer);
				first.next = last;
			}
			else
			{
				last.next = new Node(new_customer);
				last = last.next;		
			}
		}
		
	}
	
	public void dequeue()
	{
		if(first == null && last == null){
			System.out.println("Trying to dequeue already empty queue LOL");
		}
		else
		{
			if(first.next == last)
			{
				first = last;
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
