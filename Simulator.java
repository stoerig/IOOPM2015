import java.util.*;

public class Simulator
{	
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
    			System.out.println("INPUT YOUR DESIRED VALUE OF INTENSITY: ");
    			user_intensity = in.nextInt();
    			System.out.println("INPUT YOUR DESIRED VALUE OF MaxGroceries: ");
    			user_maxgroceries = in.nextInt();
    			System.out.println("INPUT YOUR DESIRED VALUE OF TRESHOLDFORNEWREGISTER: ");
    			user_tresholdfornewregister = in.nextInt();
    			System.out.println("HOW MANY STEPS WOULD YOU LIKE THE SIM TO RUN?: ");
    			steps = in.nextInt();
    			System.out.println("How many registers does your store have?: ");
    			amount_of_registers = in.nextInt();
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
    			System.out.println("\n********** INPUT MUST BE OF TYPE INTEGER!!! **********\n");
    		
    		}
 
    	}while(error_flag);
    	System.out.println("");
    	System.out.println("Simulation finished!");
    	in.close();
    }
}