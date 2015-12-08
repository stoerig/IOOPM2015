/**
 * <p> This class is a representation of Queues that are held in registers within the store. 
 * 
 * @author Edvin Wahlberg
 * @author David Edehult
 *
 */

public class Queue
{
	/**
	 * @variable first points to the first element in the queue
	 * @variable last points to the last element of the queue
	 * @variable length an int representing the amount of groceries in the queue
	 */
	
	Node first;
	Node last;
	int length;
	
	/**
	 * <p> Spawns a new Queue, with <tt>first, last</tt> set to <tt>null</tt>. <tt>length</tt> set to 0.
	 */
	
	public Queue()
	{
		first = null;
		last = null;
		length = 0;
	}
	
	/**
	 * <p> iterates through the queue and counts how many elements that it holds
	 * @return int that represents the amount of element in the queue
	 */
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
		
		/**
		 * <p>Enqueues the input customer
		 * @param new_customer customer to be held in <tt>last</tt>
		 */
	
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
		
		/**
		 * <p> dereferences the head of the Queue
		 */
		
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
		
		/**
		 * 
		 * @return element held in <tt>first</tt>
		 */
	
		public Customer first()
		{
			return first.element;
		}
	
		/**
		 * <p> Prints out a graphic representation of a Queue. Prints out a <tt> @ </tt> For each customer. 
		 * 
		 */
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
		
		/**
		 *<p> Each Customer in the Queue are held in a Node that points to the <tt> next </tt> Node in the Queue.
		 *
		 */
		class Node {
			Node next;
			Customer element;
			
			public Node(Customer new_customer)
			{
				element = new_customer;
				next = null;
			}
			
		/**
		 * 
		 * @return The Node's <tt> next-pointer </tt>
		 */
			
		public Node getNext()
		{
			return next;
		}
	}
}
