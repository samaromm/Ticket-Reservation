
public class Admin extends Person {
	
	Admin(String name, int idNumber){
		super(name,idNumber);
		Lists.admins.add(this);
	}
	
	public void acceptEvents(Event event) {
		Lists.addedEvents.add(event);
		System.out.println("The event "+ event.name+" have been accepted by the admin "+ this.name);
	}
	
	public void rejectEvents(Event event) {
		Lists.addedEvents.remove(event);
		System.out.println("The event "+ event.name+" have been rejected by the admin "+ this.name);
	}
	
	public void cancelEvent(Event event) {
		if(Lists.addedEvents.remove(event)) {
			System.out.println("The event "+ event.name+" have been canceled by the admin "+ this.name);
			for(int i=0; i<Lists.registeredUsers.size(); i++) {
				Lists.registeredUsers.get(i).notifyUsers(" cancel of the event ",event);
			}
		}
			
		else {
				System.out.println("The event not found");
		}
	}
	
	public void dailyReport() {
		//write in a file how many events, how many tickets sold or returned, and money earned 
	}
	
}
