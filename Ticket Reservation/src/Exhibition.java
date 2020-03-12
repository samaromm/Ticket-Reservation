
public class Exhibition extends Event{

	Exhibition(String name, String date, String place, int capacity, double price, eventHolder holder, Admin admin) {
		super(name, date, place, capacity, price, holder, admin);
		// TODO Auto-generated constructor stub
	}
	
	public void reserveTickets(registered buyer, int tickets) {
		System.out.println("You can not reserve in Exhibition");
	}
	
	public void cancelTickets(registered buyer,int id) {
		System.out.println("You can not cancel in Exhibition");
	}

}
