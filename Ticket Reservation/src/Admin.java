import java.io.*;
import java.util.Scanner; 



public class Admin extends Person {
	
	Admin(String name, int idNumber){
		super(name,idNumber);
		Lists.admins.add(this);
	}
	
	public void acceptEvents(Event event) {
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
	
	public void dailyReport() throws Exception {
		//write in a file how many events, how many tickets sold or returned, and money earned 
		File report = new File("Report2.txt");
		/*if (report.exists()){
			System.out.println("File Already exist");
			System.exit(0);
		} */
		PrintWriter output = new PrintWriter(report);
		output.println("**Report: ");
		output.println("The created events are:");
		for(int i=0; i<addedEvents.size();i++){
    	    output.println((i+1)+"- "+addedEvents.get(i).name); 
		}
		output.println();
		output.print("The number of Tickets had been reserved:");
		output.println(reservedTickets.size());
		output.print("The number of Tickets had been sold: ");
		output.println(soldTickets.size());
		output.print("The number of Tickets had been returned: ");
		output.println(returnedTickets.size());
		output.println();
		output.print("Total earnings: ");
		output.println(earned);

		output.close();


		Scanner input = new Scanner(report);
		while(input.hasNextLine()){
			System.out.println(input.nextLine());
		}
		input.close();
    
	}
	
}
