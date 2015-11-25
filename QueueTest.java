import java.util.*; //kurwa
public class QueueTest {
	
	
	public static Customer[] spawnCustomers(int amount_of_customers_to_spawn)
	{
	
		Customer[] test_customers = new Customer[amount_of_customers_to_spawn];
		
		for(int i = 0; i < amount_of_customers_to_spawn; i++)
		{
		
			test_customers[i] = new Customer(0, i);
		}
		
		return test_customers;
	}
	
	public static Customer[] concat_CustomerArrays(Customer[] a, Customer[] b)
	{
		Customer[] return_array = new Customer[a.length + b.length];
		 
		System.arraycopy(a, 0, return_array, 0, a.length);
	    System.arraycopy(b, 0, return_array, a.length, b.length);
	    
	    return return_array;
	}
	
	public static int getAmountOfDoneCustomers(Customer[] messy_array)
	{
		int i = 0;
		for(Customer c : messy_array)
		{
			if(c != null)
			{
				if(c.getGroceries() == 0)
				{
					i++;
				}
			}
		}
		return i;
	}
	
	public static Customer[] cleanupCustomerArray(Customer[] messy_array)
	{
		Customer[] tidy_array = new Customer[getAmountOfDoneCustomers(messy_array)];
		int i = 0;
		for(Customer c : messy_array)
		{
			if(c != null)
			{
				tidy_array[i] = c;
				i++;
			}
		}
		return tidy_array;
	}
	
	
	public static void printCustomerArray(Customer[] done_customers)
	{
		if(done_customers.length > 0)
		{
			for(Customer c : done_customers)
			{
				if(c != null)
				{
				//System.out.println(c.getGroceries());
				}
			}
		}
	}
	
	public static void main(String args[])
	{
		
		Store Ica_Luthis = new Store(4);
		Customer[] test_customers = spawnCustomers(6);
		//Customer[] test_customers2 = spawnCustomers(4);
		Customer[] done_customers = new Customer[0];
		Ica_Luthis.fill_Store(test_customers);
		Ica_Luthis.openNewRegister();
		//Ica_Luthis.fill_Store(test_customers2);
		Ica_Luthis.getAverageQueueLength();
		System.out.println("Kassa 0 har såhär många i Queue");
		System.out.println(Ica_Luthis.registers[0].getQueueLength());
		//System.out.println("Kassa 1 har såhär många i Queue");
		//System.out.println(Ica_Luthis.registers[1].getQueueLength());
		
		System.out.println("Average queue length in the store is currently:");
		System.out.println(Ica_Luthis.getAverageQueueLength()); 
		Ica_Luthis.print_registers_in_store();
		Ica_Luthis.step();
		done_customers = concat_CustomerArrays(Ica_Luthis.getDoneCustomers(), done_customers);
		printCustomerArray(done_customers);
		
		
		
		Ica_Luthis.step();
		done_customers = concat_CustomerArrays(Ica_Luthis.getDoneCustomers(), done_customers);
		printCustomerArray(done_customers);
		Ica_Luthis.step();
		done_customers = concat_CustomerArrays(Ica_Luthis.getDoneCustomers(), done_customers);
		printCustomerArray(done_customers);
		Ica_Luthis.step();
		done_customers = concat_CustomerArrays(Ica_Luthis.getDoneCustomers(), done_customers);
		printCustomerArray(done_customers);
		Ica_Luthis.step();
		done_customers = concat_CustomerArrays(Ica_Luthis.getDoneCustomers(), done_customers);
		printCustomerArray(done_customers);
		Ica_Luthis.step();
		done_customers = concat_CustomerArrays(Ica_Luthis.getDoneCustomers(), done_customers);
		printCustomerArray(done_customers);
		Ica_Luthis.step();
		done_customers = concat_CustomerArrays(Ica_Luthis.getDoneCustomers(), done_customers);
		printCustomerArray(done_customers);
		Ica_Luthis.step();
		done_customers = concat_CustomerArrays(Ica_Luthis.getDoneCustomers(), done_customers);
		printCustomerArray(done_customers);
		
		Ica_Luthis.step();
		done_customers = concat_CustomerArrays(Ica_Luthis.getDoneCustomers(), done_customers);
		printCustomerArray(done_customers);
		Ica_Luthis.step();
		done_customers = concat_CustomerArrays(Ica_Luthis.getDoneCustomers(), done_customers);
		printCustomerArray(done_customers);
		Ica_Luthis.step();
		done_customers = concat_CustomerArrays(Ica_Luthis.getDoneCustomers(), done_customers);
		printCustomerArray(done_customers);

		Ica_Luthis.step();
		done_customers = concat_CustomerArrays(Ica_Luthis.getDoneCustomers(), done_customers);
		printCustomerArray(done_customers);
		Ica_Luthis.step();
		done_customers = concat_CustomerArrays(Ica_Luthis.getDoneCustomers(), done_customers);
		printCustomerArray(done_customers);
		Ica_Luthis.step();
		done_customers = concat_CustomerArrays(Ica_Luthis.getDoneCustomers(), done_customers);
		printCustomerArray(done_customers);
		Ica_Luthis.step();
		done_customers = concat_CustomerArrays(Ica_Luthis.getDoneCustomers(), done_customers);
		printCustomerArray(done_customers);
		Ica_Luthis.step();
		done_customers = concat_CustomerArrays(Ica_Luthis.getDoneCustomers(), done_customers);
		printCustomerArray(done_customers);
		
		
		Ica_Luthis.print_registers_in_store();
		System.out.println("HORAHORAHORA");
		cleanupCustomerArray(done_customers);
		printCustomerArray(done_customers);
		
		}
}
