public class Register extends Queue
{
	Queue queue;
	boolean open;
	
	//Constructor:n f�r Register, vet inte om man ska l�ta Register vara Open n�r man skapar den.
	public Register()
	{
		queue = new Queue();
		open = false;
	}
	
	// �ppnar Register
	public void open()
	{
		open = true;
	}
	
	//St�nger Register
	
	public void close()
	{
		open = false;
	}
	
	//Kollar om Register �r �ppen
	public boolean isOpen()
	{
		if (open == true)
		{
			return true;
		}		
			return false;
	}
	
	//Tar ut den f�rsta Customer i Queue och s�nker groceries med -1.
	public void step()
	{
		if(hasCustomers())
		{
			queue.first().serve();
		}
	}
	
	//kollar om Queue �r tom
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
	
	//Kollar om Customer som �r f�rst i Queue �r klar.
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
	
	//l�gger Customer C sist i Queue
	public void addToQueue(Customer c)
	{
		queue.enqueue(c);
	}
	
	//Returnerar f�rsta Customer i Queue och tar bort Customer fr�n Queue
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
	
	// printar hurvida Register �r open/closed och hur Register:s Queue �r.
	public void printRegister()
	{
		System.out.println("Register �r open?");
		System.out.println(open);
		System.out.println("Register har hur m�nga i Queue?");
		System.out.println(queue.length);
	}
	
}