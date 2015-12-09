/**
 * <p> This Class extends Customer creating a specific type of Customer called VIP. VIP Customers will have queue priority and get more groceries served per
 *  <tt>serve()</tt>
 * 
 * @author Edvin Wahlberg
 * @author David Edehult
 *
 */

public class VIP extends Customer{
	
	public enum Level{
		SILVER, GOLD, PLATINUM
	}
	
	/**
	 * <p> @param serviceLevel the level of VIP-treatment the customer will get
	 */
	
	private Level serviceLevel;
	
	/**
	 * 
	 * @param bornTime bornTime like in the Customer class
	 * @param groceries groceries lie in the Customer class
	 * @param serviceLevel represents the level of VIP-treatment the VIP will get
	 */
	
	public VIP(int bornTime, int groceries, Level serviceLevel)
	{
		super(bornTime, groceries);
		this.serviceLevel = serviceLevel;
	}
	
	
	/**
	 * <p> decrements <tt>groceries</tt> by 2. 1 if <tt>groceries == 1 </tt>
	 */
	
	public void serve()
	{
		super.serve();
		if(groceries > 0)
		{
			groceries--;
		}
	}
	
	/**
	 * 
	 * @return VIP's serviceLevel SILVER GOLD OR PLATINUM
	 */
	
	public Level getserviceLevel()
	{
		return serviceLevel;
	}
	
	/**
	 * 
	 * @param serviceLevel input VIP serviceLevel
	 */
	
	public void setserviceLevel(Level serviceLevel)
	{
		this.serviceLevel = serviceLevel;
	}
}
