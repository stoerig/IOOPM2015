import java.util.Random; //kurwa
public class Simulation {
	Store store;
	public int time;
	public int intensity;
	public int maxGroceries;
	public int tresholdForNewRegister;
	public int averageWaitTime;
	public int maxWaitTime;
	public int customersServed;
	public Customer newcustomer;
	
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
			born_times[i] = c.bornTime;
			i++;
		}
		return born_times;
	}
	
	public void checkifNewMax(int[] born_times)
	{
		for(int i : born_times)
		{
			if(time - i > maxWaitTime)
			{
				i = maxWaitTime;
			}
		}
		
	}
	
	public void step()
	{
		System.out.println("hej");
		time++;
		Random generator = new Random();
		int random_int_0_to_100 = generator.nextInt(((100 - 0) + 1) + 0);
		int random_int_1_to_maxGroceries = generator.nextInt(((maxGroceries - 1) + 1) + 1);
		if(random_int_0_to_100 < 101) //ska vara mindre än intensity sen
		{
			newcustomer = new Customer(time, random_int_1_to_maxGroceries);
			store.newCustomer(newcustomer);
		}
		if(store.getAverageQueueLength() > tresholdForNewRegister)
		{
			store.openNewRegister();
		}
		
		Customer[] customers_for_statistics = cleanupCustomerArray(store.getDoneCustomers());
		
		customersServed = customersServed + customers_for_statistics.length;
		
		int[] born_times = new int[customers_for_statistics.length];
		
		born_times = getBornTimes(customers_for_statistics); 
		
		checkifNewMax(born_times);
		
	}

	
	
}
