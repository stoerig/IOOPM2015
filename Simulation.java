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
	
	
	
}
