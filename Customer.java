public class Customer
{
	private final int bornTime;
	private int groceries;
	
	//Constructor:n f�r Customer, man s�tter in bornTime(vet inte vad det anv�nds till), och hur m�nga Groceries den ska betala f�r=) med j�mna pengar
	public Customer(int init_bornTime, int init_groceries)
	{
		bornTime = init_bornTime;
		groceries = init_groceries;
	}
	
	//s�tter ett nytt v�rde p� en Customer:s groceries
	public void setGroceries(int new_groceries)
	{
		groceries = new_groceries;
	}
	
	//Returnerar Customer:s variabel groceries
	public int getGroceries()
	{
		return groceries;
	}
	
	
	public int getBornTime()
	{
		return bornTime;
	}
	//Om Customer har groceries s� -1 p� groceries.
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
	
	//Kollar om Customer har 0 groceries, allts� �r klar och ska ut ur fucking butiken
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
		for(Customer c : done_customers)
		{
				i++;
		}
		return i;
	}
	
}
