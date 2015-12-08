public class Store
{
	Register registers[];

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
	

	public void fill_Store(Customer[] test_customers)
	{
		for(Customer c : test_customers)
		{
			this.newCustomer(c);
		}
	}
	
	
	public void storeToString()
	{
		for(Register r : registers)
		{
			r.registerToString();
		}
	}
	
}
