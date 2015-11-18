public class Register extends Queue
{
	Queue queue;
	boolean open;
	//Queue queue;
	
	public Register()
	{
		queue = new Queue();
		open = true;
	}
	
	public void open()
	{
		open = true;
	}
	
	public void close()
	{
		open = false;
	}
	
	
	public boolean isOpen()
	{
		if (open == true)
		{
			return true;
		}		
			return false;
	}
	
	public void step()
	{
		Customer customer_to_be_served = first();
		customer_to_be_served.serve();
	}
	
	public boolean hasCustomers()
	{
		if (queue.length() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean currentCustomerIsDone()
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
	
	public void addToQueue(Customer c)
	{
		queue.enqueue(c);
	}
	
	public Customer removeCurrentCustomer()
	{
		Customer done_customer = queue.first();
		queue.dequeue();
		return done_customer;
	}
	
	public int getQueueLength()
	{
		return queue.length();
	}
	
}