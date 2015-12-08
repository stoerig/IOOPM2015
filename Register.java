/**
 * <p> This class is a representation of a Register within the Store 
 * 
 * @author Edvin Wahlberg
 * @author David Edehult
 *
 */


public class Register
{
	/**
	 * @see Queue
	 * open is true if register is open for insertion to Queue, else false
	 */
	
	Queue queue;
	private boolean open;
	
	/**
	 * spawned Register has <tt> open </tt> set to <tt> false </tt>
	 */
	
	public Register()
	{
		queue = new Queue();
		open = false;
	}
	
	/**
	 * sets <tt> open </tt> to <tt> true </tt>
	 */
	
	public void open()
	{
		open = true;
	}
	
	/**
	 * sets <tt> open </tt> to <tt> false </tt>
	 */
	
	public void close()
	{
		open = false;
	}
	
	/**
	 * 
	 * @return true if open == true, else false
	 */
	
	public boolean isOpen()
	{
		return open;
	}
	
	/**
	 * <p> if the register's queue has customers in it, the first customer in the queue is served(i.e groceries is decremented by 1)
	 */
	
	public void step()
	{
		if(hasCustomers())
		{
			if(queue.first != null)
			{
			queue.first().serve();
			}
		}
	}
	
	/**
	 * 
	 * @return true if @see Queue#length is 0, else false
	 */
	
	public boolean hasCustomers()
	{
		if (queue.length > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * 
	 * @return true if first customer in queue has groceries set to 0
	 */
	
	public boolean currentCustomerIsDone()
	{
		if(queue.first != null)
		{
			if (queue.first().isDone() == true)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;	
	}
	
	/**
	 * <p> Adds input customer to the registers queue
	 * @param c Customer to be added to queue
	 */
	
	public void addToQueue(Customer c)
	{
		queue.enqueue(c);
	}
	
	/**
	 * <p> dequeue's the first customer in the queue and returns it.
	 * @return customer first in queue
	 */
	
	public Customer removeCurrentCustomer()
	{
		Customer done_customer = queue.first();
		queue.dequeue();
		return done_customer;
	}
	
	/**
	 * 
	 * @return int representing length of queue
	 */
	
	public int getQueueLength()
	{
		return queue.length;
	}
	
	/**
	 * <p> Prints out a graphic representation of the Register. <tt> O </tt> if Register is open. Then <tt> "@" </tt> For each customer in queue. <tt> X </tt> is a closed register.
	 */
	
	public void registerToString()
	{
		if(isOpen())
		{
			System.out.println("O");
			queue.queueToString();
		}
		else
		{
			System.out.println("X");
		}
	}
}