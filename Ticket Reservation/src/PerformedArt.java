import java.util.*;

public class PerformedArt extends Event{
	ArrayList<Integer> seats;

	PerformedArt(String name, String date, String place, int capacity, double price, eventHolder holder, Admin admin , int seats) {
		super(name, date, place, capacity, price, holder, admin);
		// TODO Auto-generated constructor stub
		this.seats = new ArrayList<Integer>(seats);
	}
	public void reserveSeat(registered buyer, int seatNum) {
		if(!compareDate(this.date)) {
			System.out.print("The event is already over, choose another one with upcoming date\n list of upcoming events:");
			this.printDetailes();
		}	
		else if(this.capacity<1) 
				System.out.println("Failed! The available seats are not enough for your order");
			

		else if(this.seats.contains(seatNum)) {
			System.out.println("This seat isn't available");
		}
		
		else {
					Tickets t =new Tickets();
					Lists.ticketHolders.put(t,buyer);
					Lists.reservedTickets.put(Tickets.getId(),t);
					System.out.println("Ticket with id "+Tickets.getId()+" reserved by "+buyer.name+" with price "+this.price+ " in seat "+seatNum);
					this.seats.add(seatNum);
					this.capacity--;
					System.out.println(buyer.name+" reserved "+ seatNum+" for the event "+this.name+ " and the total price is "+ (this.price));
			}
		}	

}
