public class Simulator{//kurwa
	
	
    public static void main(String[] args) throws InterruptedException{
        int steps = 1;
        Simulation s = new Simulation(simStore, 100, 10, 2);
        for(int i = 0; i < steps; i++){
            System.out.print("test");
            s.step();
            System.out.println(s);
            Thread.sleep(500);
        }
        System.out.println("");
        System.out.println("Simulation finished!");
    }
}