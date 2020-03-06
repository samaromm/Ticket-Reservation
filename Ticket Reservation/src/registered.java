
public class registered extends Person{

	registered(String name, int idNumber){
		super(name,idNumber);
		Lists.registeredUsers.add(this);
	}
	
	public void notifyUsers(String message, Event event) {
		System.out.println("buyer "+this.name+" has been notified about the "+message +" "+event.name);
	}
}
