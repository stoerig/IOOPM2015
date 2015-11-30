public class Simulator
{
	
	
    public static void main(String[] args) throws InterruptedException{
        int steps = 200;
        Store simStore = new Store(4);
        Simulation s = new Simulation(simStore, 2, 10, 10);
        for(int i = 0; i < steps; i++){
            s.step();
            Thread.sleep(500);
        }
        System.out.println("");
        System.out.println("Simulation finished!");
    }
}