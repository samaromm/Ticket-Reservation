import java.util.*;
import java.time.LocalDate;
public class Event extends Lists {

	String name; 
	LocalDate date;
	String place; 
	eventHolder holder;
	int capacity;
	double price;
	Admin admin;
	
	Event(String name, String date, String place, int capacity, double price, eventHolder holder, Admin admin){
		this.name=name;
		this.place=place;
		this.capacity=capacity;
		this.price=price;
		this.admin= admin; 
		this.holder = holder; 
		this.setDate(LocalDate.parse(date)); //users enters the date in string, this method will change it to Date format "YYYY-MM-DD"
	}
	
	
	public void buy(registered buyer, int tickets) {
		
		//the event already ended
	 if(addedEvents.contains(this)) {	
		if(!compareDate(this.date)) {
			System.out.print("The event is already over, choose another one with upcoming date\nlist of upcoming events:");
			printDetailes();
		}
		
		//the empty seats aren't enough
		else if(this.capacity<tickets) 
			System.out.println("Failed! The available seats are less than the number of tickets, choose less number of tickets \n Available seats: "+capacity+" seats");
		
		else {
			for(int i=1;i<=tickets;i++) {
				Tickets t =new Tickets();
				Lists.ticketHolders.put(t,buyer);
				soldTickets.put(Tickets.getId(),t);
				System.out.println("Ticket with id "+Tickets.getId()+" bought by "+buyer.name+" with price "+this.price);
				this.capacity--;
				Lists.earned+=this.price;
			}
			System.out.println(buyer.name+" bought "+ tickets+" tikcets for the event "+this.name+ " and the total price is "+ ((double)this.price*tickets));
		}}
	  else {System.out.println("Event has been removed\nlist of upcoming events:"); printDetailes();}
	}
	
	
	public void returnTicket(registered buyer,int id) {
		boolean check = false;
		for(Map.Entry<Integer, Tickets> entry : Lists.soldTickets.entrySet()) {
		    int key = entry.getKey();
			if(key==id) {
				registered b = Lists.ticketHolders.get(key);
				if(b==buyer) {
				Lists.ticketHolders.remove(Lists.soldTickets.get(key));
				Lists.returnedTickets.add(Lists.soldTickets.get(key));
				Lists.soldTickets.remove(key);
				System.out.println("Ticket number: "+id+ " has been returned");
				Lists.earned-=this.price;
				this.capacity++;
				check=true;
				break;
			} 
		  }
		}
		if(!check) System.out.println("Ticket isn't found");
	}
	
	
	//reservation means you reserve a ticket without paying directly
	public void reserveTickets(registered buyer, int tickets) {
	  if(Lists.addedEvents.contains(this)) {	
		if(!compareDate(this.date)) {
			System.out.print("The event is already over, choose another one with upcoming date\n list of upcoming events:");
			printDetailes();
		}
		
		else if(this.capacity<tickets) 
			System.out.println("Failed! The available seats are less than the number of tickets, choose less number of tickets \n Available seats: "+capacity+" seats");
		
		else {
			for(int i=1;i<=tickets;i++) {
				Tickets t =new Tickets();
				Lists.ticketHolders.put(t,buyer);
				Lists.reservedTickets.put(Tickets.getId(),t);
				System.out.println("Ticket with id "+Tickets.getId()+" reserved by "+buyer.name);
				this.capacity--;
			}
			System.out.println(buyer.name+" reserved "+ tickets+" tikcets for the event "+this.name);
		}}
	  else {System.out.println("Event has been removed\nlist of upcoming events:"); printDetailes();}
	}
	
	
	//cancel for reserved, returned for sold
	public void cancelTickets(registered buyer,int id) {
		boolean check=false;
		for(Map.Entry<Integer, Tickets> entry : Lists.reservedTickets.entrySet()) {
		    int key = entry.getKey();
			if(key==id) {
				registered b = Lists.ticketHolders.get(key);
				if(b==buyer) {
				Lists.ticketHolders.remove(Lists.reservedTickets.get(key));
				Lists.returnedTickets.add(Lists.reservedTickets.get(key));
				Lists.reservedTickets.remove(key);
				System.out.println("Ticket number: "+id+ "has been canceled");
				this.capacity++;
				check=true;
				break;
			}}
		}

		if(!check) System.out.println("Ticket isn't found");
		
	}
	
	
	//check if a date is from the past
	protected boolean compareDate(LocalDate date) {
		LocalDate currentDate = LocalDate.now();
		return(date.compareTo(currentDate)>0);
	}
	
	
	protected void printDetailes() {
		for(int i=0; i<Lists.addedEvents.size(); i++) {
			Event e = Lists.addedEvents.get(i);
			if(compareDate(e.date)) {
				System.out.println("Event Name: "+ e.name);
				System.out.println("Event Date: "+ e.date);
				System.out.println("Event Price: "+ e.price);
				System.out.println("Event Place: "+ e.place);}
		}
	}
	
	
	
	public void setDate(LocalDate d) {
		if(this.compareDate(d)) {
			this.date=d;
			this.holder.addEvent(this);
			this.admin.acceptEvents(this);
		}
		else {
			System.out.println("This date is unavilable, choose another one");
			this.admin.rejectEvents(this);
		}
	}
	
	
	public void setPlace(String place) {
		this.place=place;
	}
	
}
