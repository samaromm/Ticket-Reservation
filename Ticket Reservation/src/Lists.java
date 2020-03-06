import java.util.*;

public class Lists {
	static ArrayList<Event> addedEvents = new ArrayList<Event>();
	static ArrayList<Admin> admins = new ArrayList<Admin>();
	static ArrayList<eventHolder> eventHolders = new ArrayList<eventHolder>();
	static ArrayList<registered> registeredUsers = new ArrayList<registered>();
	static Map<Tickets,registered> ticketHolders = new HashMap<Tickets,registered>();
	static Map<Integer,Tickets> soldTickets = new HashMap<Integer,Tickets>();
	static Map<Integer,Tickets> reservedTickets = new HashMap<Integer,Tickets>();
	static ArrayList<Tickets> returnedTickets = new ArrayList<Tickets>();
	//ArrayList<Double> payments = new ArrayList<Double>();
	static double earned=0.0;
}
