public class Queue {
	Node first;
	Node last;
	int length;
	
	//Constructorn f�r Queue, skapar en tom k�
	public Queue()
	{
		first = null;
		last = null;
		length = 0;
	}
	
	// Uppdaterar och returnerar Queues length variabel.
	public int length()
	{
		int current_length = 0;
		Node cursor = first;
		while(cursor != null)
		{
			current_length++;
			cursor = cursor.next;
		}
		current_length++;
		length = current_length;
		return (length);
	}
	
	//printar hur m�nga groceries Customers i Queue:n har
	public void printQueue()
	{
		Node cursor = first;
		while(cursor != null)
		{
			System.out.println(cursor.element.groceries);
			cursor = cursor.next;
		}	
	}
	
	//St�ller en Customer sist i Queue
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
	
	//Tar bort f�rsta Customer i queue
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
	
	//returnerar f�rsta Customer i Queue
	
	public Customer first()
	{
		return first.element;
	}
}
