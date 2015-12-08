/**
 * <p> This class takes input positives integers from the user that are used in the simulation. The variables that are requested from the user are <tt> tresholdForNewRegister, 
 * intensity, maxAmountOfGroceries, amount_of_registers, steps </tt>
 * 
 * @author Edvin Wahlberg
 * @author David Edehult
 *
 */

import java.util.*;
public class Simulator
{	
    @SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException{
    	Scanner in = new Scanner(System.in);
    	boolean error_flag = true;
    	int user_intensity = 0;
    	int user_maxgroceries = 0;
    	int user_tresholdfornewregister = 0;
    	int steps = 0;
    	int amount_of_registers = 0;
    	
    	do{
    	
    		try
    		{
    			in = new Scanner(System.in);
    			System.out.println("INPUT PERCENTAGE CHANCE OF A CUSTOMER ENTERING THE STORE: ");
    			user_intensity = in.nextInt();
    			System.out.println("INPUT THE MAX AMOUNT OF GROCERIES A CUSTOMER CAN BRING TO THE REGISTER: ");
    			user_maxgroceries = in.nextInt();
    			System.out.println("INPUT WHAT AT WHAT AVERAGE LENGTH OF THE QUEUES IN THE STORE TO SPAWN A NEW REGISTER: ");
    			user_tresholdfornewregister = in.nextInt();
    			System.out.println("HOW MANY STEPS WOULD YOU LIKE THE SIM TO RUN?: ");
    			steps = in.nextInt();
    			System.out.println("HOW MANY REGISTERS DOES YOUR STORE HAVE?: ");
    			amount_of_registers = in.nextInt();
    			if(amount_of_registers < 1)
    			{
    				throw new InputMismatchException();
    			}
    			Store simStore = new Store(amount_of_registers);
    			Simulation s = new Simulation(simStore, user_intensity, user_maxgroceries, user_tresholdfornewregister);
    			error_flag = false;
    			for(int i = 0; i < steps; i++){
    				s.step();
    				Thread.sleep(500);
    			}
    		}
    		catch(InputMismatchException inputError)
    		{
    			System.out.println("\n********** INPUT MUST BE A POSITIVE INTEGER!!! **********\n");
    		
    		}
 
    	}while(error_flag);
    	
    	System.out.println("");
    	System.out.println("Simulation finished!");
    	in.close();
    }
}