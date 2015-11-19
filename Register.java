public class Register extends Queue
{
	Queue queue;
	boolean open;
	
	//Constructor:n för Register, vet inte om man ska låta Register vara Open när man skapar den.
	public Register()
	{
		queue = new Queue();
		open = false;
	}
	
	// öppnar Register
	public void open()
	{
		open = true;
	}
	
	//Stänger Register
	
	public void close()
	{
		open = false;
	}
	
	//Kollar om Register är öppen
	public boolean isOpen()
	{
		if (open == true)
		{
			return true;
		}		
			return false;
	}
	
	//Tar ut den första Customer i Queue och sänker groceries med -1.
	public void step()
	{
		if(hasCustomers())
		{
			queue.first().serve();
		}
	}
	
	//kollar om Queue är tom
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
	
	//Kollar om Customer som är först i Queue är klar.
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
	
	//lägger Customer C sist i Queue
	public void addToQueue(Customer c)
	{
		queue.enqueue(c);
	}
	
	//Returnerar första Customer i Queue och tar bort Customer från Queue
	public Customer removeCurrentCustomer()
	{
		Customer done_customer = queue.first();
		queue.dequeue();
		return done_customer;
	}
	
	//Returnerar Queue:s variabel length
	public int getQueueLength()
	{
		return queue.length;
	}
	
	// printar hurvida Register är open/closed och hur Register:s Queue är.
	public void printRegister()
	{
		System.out.println("Register är open?");
		System.out.println(open);
		System.out.println("Register har hur många i Queue?");
		System.out.println(queue.length);
	}
	
}