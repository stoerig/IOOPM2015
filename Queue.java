public class Queue
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
		
	
		public void dequeue()
		{
			if(first == null)
			{
				throw new NullPointerException();
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
	
		public Customer first()
		{
			return first.element;
		}
	
		
		public void queueToString()
		{
			String queue = "";
			String customer = "@";
			for(int i = 0; i < length; i++)
			{
				queue = queue + customer;
			}
			
			System.out.println(queue);
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
