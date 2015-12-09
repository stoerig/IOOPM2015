/**
 * <p> This class consists of methods that are called upon our representation of a customer in the simulation. 
 * A customer holds an integer {@link Customer#groceries} that represents the amount of groceries the customer is holding.
 * {@link Customer#bornTime} is a timestamp given to the <tt>Customer</tt> when it is spawned.
 * 
 * @author Edvin Wahlberg
 * @author David Edehult
 *
 */

public class Customer
{
	private final int bornTime;
	protected int groceries;
	
	/**
	 * 
	 * @param init_bornTime a timestamp to represent when the customer was spawned
	 * @param init_groceries the amount of groceries the spawned customer will have
	 */
	public Customer(int init_bornTime, int init_groceries)
	{
		bornTime = init_bornTime;
		groceries = init_groceries;
	}
	
	
	/**
	 * 
	 * @param new_groceries sets a new value to the called upon Customer's element {@link Customer#groceries}
	 */
	
	public void setGroceries(int new_groceries)
	{
		groceries = new_groceries;
	}
	
	/**
	 * 
	 * @return the amount of {@link Customer#groceries} that the <tt>Customer</tt> is holding.
	 */
	
	public int getGroceries()
	{
		return groceries;
	}
	
	/**
	 * 
	 * @return the <tt>Customer's</tt> {@link Customer#bornTime}
	 */
	
	public int getBornTime()
	{
		return bornTime;
	}
	
	/**
	 * decrements the <tt>Customer's</tt> variable {@link Customer#groceries}
	 */

	public void serve()
	{
		if (groceries > 0)
		{
			groceries--;
		}
	}
	
	/**
	 * 
	 * @return true if {@link Customer#groceries} == 0, else false
	 */
	
	public boolean isDone()
	{
		if(groceries == 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param done_customers an array of customers
	 * @return an int that represents the amount of customers in <tt>done_customers</tt> that have {@link Customer#groceries} set to 0
	 */
	
	public int getAmountOfDoneCustomers(Customer[] done_customers)
	{
		int i = 0;
		for(@SuppressWarnings("unused") Customer c : done_customers)
		{
				i++;
		}
		return i;
	}
}
