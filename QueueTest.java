
public class QueueTest {

	public static void main(String args[])
	{
		//skapar tio kunder vi utf�r testerna med
		Customer first = new Customer(0,1);
		Customer second = new Customer(0,2);
		Customer third = new Customer(0,3);
		Customer fourth = new Customer(0,4);
		Customer fifth = new Customer(0,5);
		Customer sixth = new Customer(0,6);
		Customer seventh = new Customer(0,7);
		Customer eight = new Customer(0,8);
		Customer nineth = new Customer(0,9);
		Customer tenth = new Customer(0,10);
		
		//fantasin var p� topp s� jag d�pte aff�ren till vad en riktig aff�r heter
		Store Ica_Luthis = new Store(4);
		
		//s�tter f�rst in sex nya customers, sen �ppnar den en ny kassa. sen s�tter den in fyra nya customers.
		Ica_Luthis.newCustomer(first);
		Ica_Luthis.newCustomer(second);
		Ica_Luthis.newCustomer(third);
		Ica_Luthis.newCustomer(fourth);
		Ica_Luthis.newCustomer(fifth);
		Ica_Luthis.newCustomer(sixth);
		Ica_Luthis.openNewRegister();
		Ica_Luthis.newCustomer(seventh);
		Ica_Luthis.newCustomer(eight);
		Ica_Luthis.newCustomer(nineth);
		Ica_Luthis.newCustomer(tenth);
		System.out.println("Kassa 0 har s�h�r m�nga i Queue");
		System.out.println(Ica_Luthis.registers[0].queue.length);
		System.out.println("Kassa 1 har s�h�r m�nga i Queue");
		System.out.println(Ica_Luthis.registers[1].queue.length);
		System.out.println("Kassa 0:s Queue ser ut s�h�r:\n");
		Ica_Luthis.registers[0].queue.printQueue();
		System.out.println("Kassa 1:s Queue ser ut s�h�r:\n");
		Ica_Luthis.registers[1].queue.printQueue();
		
		
		}
}
