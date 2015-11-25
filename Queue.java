public class Queue//kurwa
{
	Node first;
	Node last;
	int length;
	
	public Queue()
	{
		first = null;
		last = null;
		length = 0;
	}
	
	
	//Constructorn för Queue, skapar en tom kö
	
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
			length = current_length;
			return (length);
		}	
	
	//Ställer en Customer sist i Queue
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
			}
			length++;
		
		}
		
	
	//Tar bort första Customer i queue
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
					last = null;
				}
				else
				{
					first = first.next;
				}
				length--;
			}
		}
	
	//returnerar första Customer i Queue
	
		public Customer first()
		{
			return first.element;
		}
	
		//printar hur många groceries Customers i Queue:n har
		public void printQueue()
		{
			int i = 0;
			Node cursor = new Node(null); 
			cursor = first;
			while(cursor != null)
			{
				System.out.printf("kund nummer: %d har såhär många varor:", i);
				System.out.println(cursor.element.groceries);
				cursor = cursor.next;
				i++;
			}	
		}
		
		
		public void printValueOfFirst()
		{
			System.out.printf("värde för First", first);
			System.out.printf("värde för Last", last);
		}
		
		class Node {
			Node next;
			Customer element;
			
			public Node(Customer new_customer)
			{
				element = new_customer;
				next = null;
			}
			
		public Node getNext()
		{
			return next;
		}
	}
}
