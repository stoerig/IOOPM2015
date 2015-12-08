/**
 * <p> This is the class that holds the method step() that controls and carries out the simulation of the store.
 * <tt>time</tt>  represents in what step the simulation currently is at.
 * <tt>intensity</tt> is an integer that determines whether or not to spawn a new customer to be inserted into the Store
 * <tt>maxGroceries</tt> is the max amount of groceries a Customer can be spawned with
 * <tt>tresholdForNewRegister</tt> is an integer that determines when to open a new register.
 * <tt>averageWaitTime</tt> the average amount of Customers at each Register in the Store
 * <tt>maxWaitTime</tt> the highest amount of time a customer has had to wait to be served during the simulation
 * <tt>customersServed</tt> the total amount of customers that have been served during the simulation
 * 
 * @author Edvin Wahlberg
 * @author David Edehult
 *
 */
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
	
	/**
	 * <p> Constructor for Simulation
	 * 
	 * @param simStore Store to be used in simulation
	 * @param intensity input value to intensity
	 * @param maxGroceries input value to maxGroceries
	 * @param tresholdForNewRegister input value to tresholdForNewRegister
	 */
	
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
	
	/**
	 * <p> returns an integer that represents the amount of customers in the array that have <tt> groceries </tt> set to <tt> 0 </tt>
	 * @param messy_array array of customers
	 * @return amount of done customers
	 */
	
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
	
	/**
	 * <p> using getAmountOfDoneCustomers() this method returns an array containing all customers in <tt> messy_array </tt> that have <tt> groceries </tt> set to 0
	 * @param messy_array array of customers
	 * @return array of done customers
	 */
	
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

	/**
	 * <p> update class members averageWaitTime, maxWaitTime and customersServed with data collected from done customers
	 * @param done_customers array of done customers
	 */
	
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
	
	/**
	 * <p> Prints out the statistics gathered by updateStatistics in the simulation
	 */
	
	public void statsToString()
	{
		System.out.println("**************** STATS ****************");
		System.out.println("MaxWaitTime: " + maxWaitTime);
		System.out.println("AverageWaitTime: " + averageWaitTime);
		System.out.println("Customers Served: " + customersServed);
		System.out.println("************** STATS DONE *************");
		System.out.println("\n\n\n________________________________________");
	}
	
	/**
	 * <p> Handles the running of one time-step in the Simulation
	 */
	
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
