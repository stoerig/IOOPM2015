public class Register
{
	Queue queue;
	private boolean open;
	
	public Register()
	{
		queue = new Queue();
		open = false;
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
		return open;
	}
	
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
		return queue.length;
	}
	
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