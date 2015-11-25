public class Customer //kurwa
{
	int bornTime;
	int groceries;
	
	//Constructor:n för Customer, man sätter in bornTime(vet inte vad det används till), och hur många Groceries den ska betala för=) med jämna pengar
	public Customer(int init_bornTime, int init_groceries)
	{
		bornTime = init_bornTime;
		groceries = init_groceries;
	}
	
	//sätter ett nytt värde på en Customer:s groceries
	public void setGroceries(int new_groceries){
		groceries = new_groceries;
	}
	
	//Returnerar Customer:s variabel groceries
	public int getGroceries(){
		return groceries;
	}
	
	//Om Customer har groceries så -1 på groceries.
	public void serve()
	{
		if (groceries > 0)
		{
			groceries--;
			System.out.println("Customers varor minskar med en från serve i customer");
		}
		else
		{
			System.out.println("Customer har inga varor kvar FRÅN SERVE i customer");
		}
	}
	
	//Kollar om Customer har 0 groceries, alltså är klar och ska ut ur fucking butiken
	public boolean isDone()
	{
		if(groceries == 0)
		{
			System.out.println("Customer har inga varor kvar från ISDONE i customer");
			return true;
		}
		System.out.println(groceries);
		System.out.println("Customer har varor kvar, fortsätter serva från isdone i customer");
		return false;
	}
	
	public int getAmountOfDoneCustomers(Customer[] done_customers)
	{
		int i = 0;
		for(Customer c : done_customers)
		{
				System.out.println(c.groceries);
				i++;
		}
		return i;
	}
	
}
