public class Register 
{
	
	boolean open;
	//Queue queue;
	
	public void registerOpen(){
		open = true;
	}
	
	public void registerClosed(){
		open = false;
	}
	
	
	public boolean isOpen(){
		if (open == true){
		return true;
			}		
		return false;
	}
	
	//public void step(){
		//time++;
		//groceries--;
		
//	}
	
	//public boolean hasCustomers(){
		
	//}
	
}