import static org.junit.Assert.*;

public class Test
{

	/**
	 * 
	 * @param amount_of_customers amount of customers to be spawned in the return array
	 * @return an array of test_customers
	 */
	
	public Customer[] spawnTestCustomers(int amount_of_customers)
	{
		Customer[] test_customers = new Customer[amount_of_customers];
		
		for(int i = 0; i < amount_of_customers; i++)
		{
			test_customers[i] = new Customer(0, i);
		}
		return test_customers;
	}
	
	@SuppressWarnings("unused")
	@org.junit.Test
	public void test() 
	{
		Queue test_empty_queue = new Queue();
		Customer test_done_customer = new Customer(0,0);
		Customer test_not_done_customer = new Customer(0,1);
		Customer[] test_customers = spawnTestCustomers(20);
		Customer[] test_customers2 = spawnTestCustomers(10);
		Store test_store = new Store(4);
		test_store.fill_Store(test_customers);
		test_store.openNewRegister();
		test_store.fill_Store(test_customers2);
		
		assertEquals("isDone works: ", test_done_customer.isDone(), true);
		assertEquals("isDone works: ", test_not_done_customer.isDone(), false);
		assertEquals("Does averageQueueLength work?:", test_store.getAverageQueueLength() == 15.0, true);
		assertEquals("First register queue length: ", test_store.registers[0].getQueueLength() == 20, true);
		assertEquals("First register queue length: ", test_store.registers[1].getQueueLength() == 10, true);
		assertNull(test_empty_queue.first);
		assertNull(test_empty_queue.last);
		assertTrue(!test_store.allRegistersOpen());
	}

}
