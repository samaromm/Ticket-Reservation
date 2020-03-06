import java.text.*;
import java.time.LocalDate;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		eventHolder exhHolder = new eventHolder("Ali",567);
		Admin exhAdmin = new Admin("Sara",678);
		Event exhibition = new Exhibition("ANALYTECH 2020", "2020-04-15", "Lutfi Kirdar Center", 4, 50, exhHolder, exhAdmin);
		registered buyer = new registered("Noor",898);
		exhibition.buy(buyer, 5);
		exhHolder.addEvent(exhibition);
		exhHolder.modifyPlace(exhibition, "Ankara");
	}
	
	
}
