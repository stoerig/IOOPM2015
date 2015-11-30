public class Store //kurwa
{
	Register registers[];

	//här initieras Kassa-arrayen Store. Man ställer in med quantity_of_registers hur många kassor Store ska ha
	public Store(int quantity_of_registers)
	{
		registers = new Register[quantity_of_registers];
		for(int i = 0; i<quantity_of_registers; i++)
		{
			registers[i] = new Register();
		}
		registers[0].open();
	}
	
	
	public Register[] getRegisters() {
		return registers;
	}


	public void printOpenRegisters()
	{
		int i = 0;
		for(Register r : registers)
		{
			if(r.isOpen())
			{
				System.out.println(i);
				i++;
			}
		}
	}
	
	
	//Lägger ihop antalet Customers i varje kassa-kö i Kassa-arrayen(Store) och delar det på antalet kassor som är öppna.
	public float getAverageQueueLength()
	{
		float customers_in_store = 0;
		float number_of_registers = 0;
		for(Register r : this.registers)
		{
			if(r.isOpen())
			{
			customers_in_store = customers_in_store + r.getQueueLength(); 
			number_of_registers++;
			}
		}
		
		return customers_in_store/number_of_registers;
	}
	
	
	//Lägger en Customer i den kassa-kö som är kortast. Den går alltså igenom Kassa-arrayen(Store)
	public void newCustomer(Customer c)
	{
		int min = registers[0].getQueueLength();
		int index_of_shortest_queue = 0;
		for(int i = 1; i < this.registers.length; i++)
		{
			if(registers[i].isOpen())
			{
				if(registers[i].getQueueLength() < min)
				{
				min = registers[i].getQueueLength();
				index_of_shortest_queue = i;
				}
			}
		}
		registers[index_of_shortest_queue].addToQueue(c);
	}
	
	
	//Går igenom Kassa-Arrayen(store) och lägger alla Customers som har 0 groceries i en array och returnerar dom
	public Customer[] getDoneCustomers()
	{
		Customer[] done_customers = new Customer[registers.length];
		int i = 0;
		for(Register r : this.registers)
		{
			if(r.currentCustomerIsDone())
			{
				done_customers[i]= r.removeCurrentCustomer();
				i++;
			}
		}
		return done_customers;
	}
	
	//Går igenom Kassa-arrayen(Store) och öppnar första bästa kassa som är stängd.
	//Jag funderar på att om när man skapar en Store så kanske man borde Skapa kassor och ha dom som closed alla förutom den första(index 0)
	
	public boolean allRegistersOpen()
	{
		int i = 0;
		for(Register r : this.registers)
		{
			if(r.isOpen())
				{
					i++;
				}
		}
		if(i == this.registers.length)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void openNewRegister()
	{
		if(!allRegistersOpen())
		{
			int i = 0;
			while(this.registers[i].isOpen() == true)
			{
				i++;
			}
			registers[i].open();
		}
			else
			{
			System.out.println("All registers alreadya opened");
			
			}
	}
	
	//utför step från klassen Register på alla öppna kassor.
	public void step()
	{
		for(Register r : this.registers)
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
		int kassanummer = 0;
		for(Register r : this.registers)
		{
			if(r != null)
			{
				if(r.isOpen())
				{
				System.out.println("______________");
				System.out.println("\nKassanummer");
				System.out.println(kassanummer);
				System.out.println(r.getFirstPointer());
				//här vill jag printa ut vilket index i Kassa-arrayen(Store) kassan jag printar ut har.
				r.printRegister();
				kassanummer++;
				}
			}
		}
	}
	
	
	public void fill_Store(Customer[] test_customers)
	{
		for(Customer c : test_customers)
		{
			this.newCustomer(c);
		}
	}
	
}
