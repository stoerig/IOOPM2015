/**
 * <p> This class is a representation of a Store that are used in the simulation. It holds a specified by the user amount of registers. The registers are held in an array.
 * 
 * @author Edvin Wahlberg
 * @author David Edehult
 *
 */

public class Store
{
	Register registers[];
	
	/**
	 * 
	 * @param quantity_of_registers amount of registers to be held in spawned Store
	 */
	
	public Store(int quantity_of_registers)
	{
		registers = new Register[quantity_of_registers];
		for(int i = 0; i<quantity_of_registers; i++)
		{
			registers[i] = new Register();
		}
		registers[0].open();
	}
	
	/**
	 * 
	 * @return array of Registers that are in the Store
	 */
	
	public Register[] getRegisters() {
		return registers;
	}
	
	/**
	 * <p> Calculates the average length of the Queues at the registers in the Store
	 * @return the average length of the queues
	 */
	
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
	
	/**
	 * <p> Enqueues the input customer at the shortest queue of the store
	 * @param c Customer to be added to the Store
	 */
	
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
	
	/**
	 * <p> Creates an array of customers, in which all done customers are put and returned 
	 * @return array of done customers
	 */
	
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
	
	/**
	 * 
	 * @return true if all registers are open, else false
	 */
	
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
	
	/**
	 * <p> if there is an available register in the store that has <tt> open </tt> set to <tt> false </tt>. That Register's <tt> open </tt> is set to <tt> true </tt>
	 */
	
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
	
	/**
	 * <p> Calls step from Register upon all Registers in Store that have <tt> open </tt> set to <tt> true </tt>
	 */
	
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
	
	/**
	 * <p> used for testing, fills a store with input array of customers
	 * 
	 * @param test_customers input customer array
	 */

	public void fill_Store(Customer[] test_customers)
	{
		for(Customer c : test_customers)
		{
			this.newCustomer(c);
		}
	}
	
	/**
	 * <p> Uses registerToString and queueToString to print out a graphical representation of the store
	 */
	
	public void storeToString()
	{
		System.out.println("________________________________________\n");
		for(Register r : registers)
		{
			r.registerToString();
		}
	}
	
}
