import java.util.Random;
public class Simulation {
	Store store;
	private int time;
	private int intensity;
	private final int maxGroceries;
	private final int tresholdForNewRegister;
	private float averageWaitTime;
	private int maxWaitTime;
	private int customersServed;
	
	public Simulation(Store simStore, int intensity, int maxGroceries, int tresholdForNewRegister)
	{
		store = simStore;
		this.time = 0;
		this.intensity = intensity;
		this.maxGroceries = maxGroceries;
		this.tresholdForNewRegister = tresholdForNewRegister;
		this.averageWaitTime = 0;
		this.maxWaitTime = 0;
		this.customersServed = 0;
		
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
	
	public Customer[] cleanupCustomerArray(Customer[] messy_array)
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
	
	public int[] getBornTimes(Customer[] done_customers)
	{
		int[] born_times = new int[done_customers.length];
		int i = 0;
		for(Customer c : done_customers)
		{
			born_times[i] = c.getBornTime();
			i++;
		}
		return born_times;
	}
	
	/*public void checkifNewMax(int[] born_times)
	{
		for(int i : born_times)
		{
			if(time - i > maxWaitTime)
			{
				i = maxWaitTime;
			}
		}
		
	}
	*/
	
	public void updateStatistics(Customer[] done_customers)
	{
		//customersServed = customersServed + done_customers.length;
		for(Customer c : done_customers)
		{
			if(c.getBornTime() > maxWaitTime)
			{
				maxWaitTime = c.getBornTime();
				
			}
			System.out.println("före:");
			System.out.println(customersServed);
			averageWaitTime = ((averageWaitTime * customersServed) + (time - c.getBornTime()))/ (++customersServed);
			System.out.println("efter:");
			System.out.println(customersServed);
		}
	}
	
	
	public void step()
	{
		time++;
		Random generator = new Random();
		int random_int_0_to_100 = generator.nextInt(((100 - 0) + 1) + 0);
		int random_int_1_to_maxGroceries = generator.nextInt(maxGroceries) + 1;
		
		if(random_int_1_to_maxGroceries == 0)
		{
			random_int_1_to_maxGroceries++;
		}
		
		if(random_int_0_to_100 > intensity)
		{
			Customer newcustomer = new Customer(time, random_int_1_to_maxGroceries);
			store.newCustomer(newcustomer);
		}
		
		if(store.getAverageQueueLength() > tresholdForNewRegister)
		{
			if(store.allRegistersOpen())
			{
				System.out.println("Följande registers är öppna\n");
				store.printOpenRegisters();
			}
			else
			{
			store.openNewRegister();
			}
		}
		
		store.step();
		
		Customer[] customers_for_statistics = cleanupCustomerArray(store.getDoneCustomers());
		updateStatistics(customers_for_statistics);
		store.print_registers_in_store();
		
		System.out.println("\n*************** STATISTICS ***************");
		System.out.print("MaxWaitTime\n");
		System.out.println(maxWaitTime);
		System.out.print("averageWaitTime\n");
		System.out.println(averageWaitTime);
		System.out.print("customersServed\n");
		System.out.println(customersServed);
		System.out.println("************* STATISTICS OVER *************\n");
		
	}

	
	
}
