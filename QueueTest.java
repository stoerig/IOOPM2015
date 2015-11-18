
public class QueueTest {

	public static void main(String args[])
	{
		Customer first = new Customer(0,1);
		Customer second = new Customer(0,2);
		Customer third = new Customer(0,3);
		Customer fourth = new Customer(0,4);
		Customer fifth = new Customer(0,5);
		Customer sixth = new Customer(0,6);
		
		/*
		q.enqueue(first);
		q.enqueue(second);
		q.enqueue(third);
		q.enqueue(fourth);
		q.printQueue();
		q.length();
		*/
		
		Store Ica_Luthis = new Store(4);
		Ica_Luthis.newCustomer(first);
		Ica_Luthis.newCustomer(second);
		Ica_Luthis.newCustomer(third);
		Ica_Luthis.newCustomer(fourth);
		Ica_Luthis.newCustomer(fifth);
		Ica_Luthis.newCustomer(sixth);
		Ica_Luthis.registers[0].printQueue();
		System.out.println("HUR MÅNGA SOM ÄR I KÖN");
		Ica_Luthis.print_registers_in_store();
		
		}
}
