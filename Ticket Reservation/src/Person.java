
import java.time.LocalDate;
public class Person extends Lists {
	
	String name; int idNumber; 
	Person(String name, int idNumber){
		this.name=name;
		this.idNumber=idNumber;
	}
	
	public void displayWithDate(String date) {
		LocalDate datee = LocalDate.parse(date);
		for(int i=0; i<Lists.addedEvents.size(); i++) {
			Event e =Lists.addedEvents.get(i);
			if(e.date.compareTo(datee)==0)
			{
				System.out.println("Event Name:"+ e.name);
				System.out.println("Event Date:"+ e.date);
				System.out.println("Event Price:"+ e.price);
				System.out.println("Event Place:"+ e.place);
			}
		}
	}
	
	public void displayWithPlace(String placee) {
		for(int i=0; i<Lists.addedEvents.size(); i++) {
			Event e =Lists.addedEvents.get(i);
			if(e.place==placee)
			{
				System.out.println("Event Name:"+ e.name);
				System.out.println("Event Date:"+ e.date);
				System.out.println("Event Price:"+ e.price);
				System.out.println("Event Place:"+ e.place);
			}
		}
	}
	
}
