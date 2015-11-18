public class Store extends Register
{
	Register registers[];

	public Store(int quantity_of_registers)
	{
		registers = new Register[quantity_of_registers];
		registers[0].open();	
	}
	
	public float getAverageQueueLength()
	{
		float customers_in_store = 0;
		float number_of_registers = 0;
		for(Register r : registers)
		{
			customers_in_store = customers_in_store + r.queue.length(); 
			number_of_registers++;
		}
		
		return customers_in_store/number_of_registers;
	}
	
	
	public void newCustomer(Customer c)
	{
		int min = registers[0].length();
		int index_of_shortest_queue = min;
		for(int i = 1; i < registers.length; i++)
		{
			if(registers[i].length() < min)
			{
				min = registers[i].length();
				index_of_shortest_queue = i;
			}
		}
		registers[index_of_shortest_queue].enqueue(c);
	}
	
	public Customer[] getDoneCustomers()
	{
		Customer[] done_customers = new Customer[registers.length];
		int i = 0;
		for(Register r : registers)
		{
			if(r.first().isDone())
			{
				done_customers[i]= r.first();
				i++;
			}
		}
		return done_customers;
	}
	
	public void openNewRegister()
	{
		int i = 0;
		while(registers[i].isOpen())
		{
			i++;
		}
		registers[i].open();
	}
	
	public void step()
	{
		for(Register r : registers)
		{
			if(r.isOpen())
			{
			r.step();
			}
		}
		
	}
}
