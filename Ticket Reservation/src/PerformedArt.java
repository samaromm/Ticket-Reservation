import java.util.*;

public class PerformedArt extends Event{
	ArrayList<Integer> seats;
	Map<Integer,registered> seatsOwners;

	PerformedArt(String name, String date, String place, int capacity, double price, eventHolder holder, Admin admin) {
		super(name, date, place, capacity, price, holder, admin);
		// TODO Auto-generated constructor stub
		seats= new ArrayList<Integer>();
		seatsOwners = new HashMap<Integer,registered>();
	}
	public boolean reserveSeat(registered buyer, int seatNum) {
		if(!compareDate(this.date)) {
			System.out.print("The event is already over, choose another one with upcoming date\n list of upcoming events:");
			this.printDetailes();
			return false;
		}	
		else if(this.capacity<1) {
			System.out.println("Failed! The available seats are not enough for your order");
			return false;
		}
				

		else if(this.seats.contains(seatNum)) {
			System.out.println("This seat isn't available");
			return false;
		}
		
		else {
					Tickets t =new Tickets();
					Lists.ticketHolders.put(t,buyer);
					reservedTickets.put(Tickets.getId(),t);
					this.seatsOwners.put(seatNum, buyer);
					System.out.println("Ticket with id "+Tickets.getId()+" reserved by "+buyer.name+" with price "+this.price+ " in seat "+seatNum);
					this.seats.add(seatNum);
					this.capacity--;
					System.out.println(buyer.name+" reserved seat number "+ seatNum+" for the event "+this.name+ " and the total price is "+ (this.price));
					return true;
			}
		}
	
	public boolean cancelSeat(registered buyer,int seatNum) {
		if(!this.seats.contains(seatNum)) {
			System.out.println("Seat number isn't found among the reserved seats");
			return false;
		}
		else {
			boolean check = false;
			for(int i=0; i<this.seats.size(); i++) {
				if(this.seats.get(i)==seatNum) {
					registered b = this.seatsOwners.get(seatNum);
					if(b==buyer) {
					this.seats.remove(i);
					this.seatsOwners.remove(seatNum);
					System.out.println(buyer.name+" cancelled the reservation of seat number "+seatNum);
					check= true;
					return true;
				}}
			}
			if(!check)System.out.println("You don't have this seat registered under your name");
			return false;
			
		}
	}
	
	public void buySeat(registered buyer, int seatNum) {
		if(reserveSeat(buyer, seatNum)) Lists.earned+=this.price;
	}
	
	public void returnSeat(registered buyer, int seatNum) {
		if(cancelSeat(buyer, seatNum)) Lists.earned-=this.price;
	}

}
