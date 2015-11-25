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
	
	
	//Constructorn f�r Queue, skapar en tom k�
	
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
			}
			length++;
		
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
					last = null;
				}
				else
				{
					first = first.next;
				}
				length--;
			}
		}
	
	//returnerar f�rsta Customer i Queue
	
		public Customer first()
		{
			return first.element;
		}
	
		//printar hur m�nga groceries Customers i Queue:n har
		public void printQueue()
		{
			int i = 0;
			Node cursor = new Node(null); 
			cursor = first;
			while(cursor != null)
			{
				System.out.printf("kund nummer: %d har s�h�r m�nga varor:", i);
				System.out.println(cursor.element.groceries);
				cursor = cursor.next;
				i++;
			}	
		}
		
		
		public void printValueOfFirst()
		{
			System.out.printf("v�rde f�r First", first);
			System.out.printf("v�rde f�r Last", last);
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
