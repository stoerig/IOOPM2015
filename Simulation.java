import java.util.Random;
public class Simulation {
	Store store;
	private int time;
	private int intensity;
	private int maxGroceries;
	private int tresholdForNewRegister;
	private int averageWaitTime;
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
	
	public void step()
	{
		time++;
		Random generator = new Random();
		int random_int_0_to_100 = generator.nextInt(((100 - 0) + 1) + 0);
		int random_int_1_to_maxGroceries = generator.nextInt(((maxGroceries - 1) + 1) + 1);
		
	}
	
}
