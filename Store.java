public class Store extends Register
{
	Register registers[];

	//h�r initieras Kassa-arrayen Store. Man st�ller in med quantity_of_registers hur m�nga kassor Store ska ha
	public Store(int quantity_of_registers)
	{
		registers = new Register[quantity_of_registers];
		registers[0] = new Register();	
	}
	
	
	//L�gger ihop antalet Customers i varje kassa-k� i Kassa-arrayen(Store) och delar det p� antalet kassor som �r �ppna.
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
	
	
	//L�gger en Customer i den kassa-k� som �r kortast. Den g�r allts� igenom Kassa-arrayen(Store)
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
		//H�r aumenterar vi kassans k�s variabel length
		registers[index_of_shortest_queue].queue.length++;
	}
	
	
	//G�r igenom Kassa-Arrayen(store) och l�gger alla Customers som har 0 groceries i en array och returnerar dom
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
	
	//G�r igenom Kassa-arrayen(Store) och �ppnar f�rsta b�sta kassa som �r st�ngd.
	public void openNewRegister()
	{
		int i = 0;
		while(registers[i].isOpen())
		{
			i++;
		}
		registers[i].open();
	}
	
	//utf�r step fr�n klassen Register p� alla �ppna kassor.
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
	
	//ska lista alla kassor med index-nummer och printa hur m�nga som �r i k�n och om den �r �ppen. Den g�r de tv� sista grejerna.
	public void print_registers_in_store()
	{
		for(Register r : registers)
		{
			if(r != null)
			{
				if(r.isOpen())
				{
				//h�r vill jag printa ut vilket index i Kassa-arrayen(Store) kassan jag printar ut har.
				r.printRegister();
				}
			}
		}
	}
}
