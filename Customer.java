public class Customer
{
	private final int bornTime;
	private int groceries;
	
	public Customer(int init_bornTime, int init_groceries)
	{
		bornTime = init_bornTime;
		groceries = init_groceries;
	}
	
	public void setGroceries(int new_groceries)
	{
		groceries = new_groceries;
	}
	
	public int getGroceries()
	{
		return groceries;
	}
	
	
	public int getBornTime()
	{
		return bornTime;
	}

	public void serve()
	{
		if (groceries > 0)
		{
			groceries--;
		}
		else
		{
		}
	}
	
	public boolean isDone()
	{
		if(groceries == 0)
		{
			return true;
		}
		return false;
	}
	
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
