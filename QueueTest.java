
public class QueueTest {

	public static void main(String args[])
	{
		Customer first = new Customer(0,1);
		Customer second = new Customer(0,2);
		Customer last = new Customer(0,3);
		Queue q = new Queue(0);
		
		q.enqueue(first);
		q.enqueue(second);
		q.enqueue(last);
		
		q.length();
		q.printQueue();
		q.dequeue();
	    q.length();
	    q.dequeue();
	    q.length();
	    //q.dequeue();
	    //q.length();
		
	}
}
