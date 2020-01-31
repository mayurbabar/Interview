package calender;

public class Main {
	public static void main(String[] Args){
		Nurse alice = new Nurse("Alice");
		alice.addTime(Frequency.PartofDay.Daily);
		alice.addTime(Frequency.PartofDay.EveryFourHours); 
		
		Nurse bob = new Nurse("Bob");
		bob.addTime(Frequency.PartofDay.Hourly);
		bob.addTime(Frequency.PartofDay.Daily);
		
		Scheduler scheduler = new Scheduler();
		scheduler.addListener(alice);
		scheduler.addListener(bob);
		
		scheduler.notifyListener(Frequency.PartofDay.Hourly);
		scheduler.notifyListener(Frequency.PartofDay.Daily);
		scheduler.notifyListener(Frequency.PartofDay.EveryFourHours);
	}
}
