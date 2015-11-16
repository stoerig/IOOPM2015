
public class QueueTest {

	public static void main(String args[])
	{
		Customer first = new Customer(0,1);
		Customer second = new Customer(0,2);
		Customer third = new Customer(0,3);
		Customer fourth = new Customer(0,4);
		Queue q = new Queue(0);
		
		q.enqueue(first);
		q.enqueue(second);
		q.enqueue(third);
		q.enqueue(fourth);
		q.printQueue();
		q.length();
		
		q.dequeue();
		q.printQueue();
		q.length();

		q.dequeue();
		q.printQueue();
		q.length();
		
		q.dequeue();
		q.printQueue();
		q.length();
		
		q.dequeue();
		q.printQueue();
		q.length();
		
		q.dequeue();
		
		}
}
