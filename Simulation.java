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

	public void updateStatistics(Customer[] done_customers)
	{
		for(Customer c : done_customers)
		{
			if(c.getBornTime() > maxWaitTime)
			{
				maxWaitTime = c.getBornTime();
				
			}
			
			averageWaitTime = ((averageWaitTime * customersServed) + (time - c.getBornTime()))/ (++customersServed);
		}
	}
	
	public void statsToString()
	{
		System.out.println("**************** STATS ****************");
		System.out.println("MaxWaitTime: " + maxWaitTime);
		System.out.println("AverageWaitTime: " + averageWaitTime);
		System.out.println("Customers Served: " + customersServed);
		System.out.println("************** STATS DONE *************");
	}
	
	public void step()
	{
		time++;
		Random generator = new Random();
		int random_0_to_100 = generator.nextInt(((100 - 0) + 1) + 0);
		int random_1_to_maxGroceries = generator.nextInt(maxGroceries - 1 + 1) + 1;
		
		if(random_0_to_100 > intensity)
		{
			Customer newcustomer = new Customer(time, random_1_to_maxGroceries);
			store.newCustomer(newcustomer);
		}
		
		if(store.getAverageQueueLength() > tresholdForNewRegister)
		{
			if(!store.allRegistersOpen())
			{
				store.openNewRegister();
			}
		}
		
		store.step();
		
		Customer[] customers_for_statistics = cleanupCustomerArray(store.getDoneCustomers());
		updateStatistics(customers_for_statistics);
		
		store.storeToString();
		statsToString();
		
	}
	
}
