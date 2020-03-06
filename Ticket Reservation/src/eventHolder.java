import java.time.LocalDate;

public class eventHolder extends Person {
	
	eventHolder(String name, int idNumber){
		super(name,idNumber);
		Lists.eventHolders.add(this);
	}
	
	public void addEvent(Event event) {
		if(Lists.addedEvents.contains(event))
			System.out.println("The event exists");
		else {
			Lists.addedEvents.add(event);
			System.out.println("The event "+ event.name+" have been added by the event holder "+ this.name+" on date "+event.date);
			//System.out.println(Lists.addedEvents.get(0).price);
			sendNotification(" adding the event", event);
		}
		
	}
	
	public void removeEvent(Event event) {
		if(Lists.addedEvents.remove(event)) {
		System.out.println("The event "+ event.name+" have been removed by the event holder "+ this.name);
		sendNotification(" removing of the event", event);}
		
		else {
			System.out.println("The event not found");
		}
		
	}
	
	public void modifyDate(Event event, String d) {
		if(Lists.addedEvents.contains(event)) {
			LocalDate d2 = LocalDate.parse(d);
			event.setDate(d2);
			if(event.date.compareTo(d2)!=0) {
				System.out.println("The event "+ event.name+" date have been changed by the event holder "+ this.name+" to "+d);
				d+=" is the new date of the event";
				sendNotification(d, event);
		}}
		
		else {
			System.out.println("The event not found");
		}
	}
	
	public void modifyPlace(Event event, String place) {
		if(Lists.addedEvents.contains(event)) {
			event.setPlace(place);
			System.out.println("The event "+ event.name+" place have been changed by the event holder "+ this.name+" to "+place);
			place +=" is the new place of the event";
			sendNotification(place, event);}
		
		else {
			System.out.println("The event not found");
		}
	}
	
	public void sendNotification(String message, Event event) {
		for(int i=0; i<Lists.registeredUsers.size(); i++) {
			Lists.registeredUsers.get(i).notifyUsers(message,event);
		}
	}
	
	
	
}
