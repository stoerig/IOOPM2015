public class Store extends Register
{
	Register registers[];

	//här initieras Kassa-arrayen Store. Man ställer in med quantity_of_registers hur många kassor Store ska ha
	public Store(int quantity_of_registers)
	{
		registers = new Register[quantity_of_registers];
		registers[0] = new Register();	
	}
	
	
	//Lägger ihop antalet Customers i varje kassa-kö i Kassa-arrayen(Store) och delar det på antalet kassor som är öppna.
	public float getAverageQueueLength()
	{
		float customers_in_store = 0;
		float number_of_registers = 0;
		for(Register r : registers)
		{
			if(r.isOpen())
			{
			customers_in_store = customers_in_store + r.queue.length(); 
			number_of_registers++;
			}
		}
		
		return customers_in_store/number_of_registers;
	}
	
	
	//Lägger en Customer i den kassa-kö som är kortast. Den går alltså igenom Kassa-arrayen(Store)
	public void newCustomer(Customer c)
	{
		int min = registers[0].length();
		int index_of_shortest_queue = 0;
		for(int i = 1; i < registers.length; i++)
		{
			if(registers[i] != null)
			{
				if(registers[i].length() < min)
				{
				min = registers[i].length();
				index_of_shortest_queue = i;
				}
			}
		}
		registers[index_of_shortest_queue].enqueue(c);
		//Här aumenterar vi kassans kös variabel length
		registers[index_of_shortest_queue].queue.length++;
	}
	
	
	//Går igenom Kassa-Arrayen(store) och lägger alla Customers som har 0 groceries i en array och returnerar dom
	public Customer[] getDoneCustomers()
	{
		Customer[] done_customers = new Customer[registers.length];
		int i = 0;
		for(Register r : registers)
		{
			if(currentCustomerIsDone())
			{
				done_customers[i]= r.first();
				i++;
			}
		}
		return done_customers;
	}
	
	//Går igenom Kassa-arrayen(Store) och öppnar första bästa kassa som är stängd.
	public void openNewRegister()
	{
		int i = 0;
		while(registers[i].isOpen())
		{
			i++;
		}
		registers[i].open();
	}
	
	//utför step från klassen Register på alla öppna kassor.
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
	
	//ska lista alla kassor med index-nummer och printa hur många som är i kön och om den är öppen. Den gör de två sista grejerna.
	public void print_registers_in_store()
	{
		for(Register r : registers)
		{
			if(r != null)
			{
				if(r.isOpen())
				{
				//här vill jag printa ut vilket index i Kassa-arrayen(Store) kassan jag printar ut har.
				r.printRegister();
				}
			}
		}
	}
}
