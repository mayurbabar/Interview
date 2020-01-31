package calender;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class Nurse implements AlarmListener{
	private String name;
	private Set<Frequency.PartofDay> times = new HashSet<Frequency.PartofDay>();
	
	public Nurse(final String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public Set<Frequency.PartofDay> getTimes() {
		return times;
	}
	
	public void setTimes(final Set<Frequency.PartofDay> times) {
		this.times = times;
	}
	
	public void addTime(final Frequency.PartofDay part){
		this.times.add(part);
	}
	
	@Override
	public void notify(final Frequency.PartofDay part){
		if(times.contains(part))
		{
			switch(part)
			{
				case Hourly:
					final Timer hourlyTimer = new Timer();
					final TimerTask hourlyTask = new TimerTask(){
						@Override
						public void run(){
							final Calendar calendar = Calendar.getInstance();
							calendar.add(Calendar.HOUR, 1);
							System.out.println("Nurse " + name + "patient needs medication at " + calendar.getTime());
						}
					};
					//hourlyTimer.schedule(hourlyTask, 1000*60*60);
					hourlyTimer.schedule(hourlyTask, 1000*10);
					break;
				case Daily:
					final Timer dailyTimer = new Timer();
					final TimerTask dailyTask = new TimerTask(){
						@Override
						public void run(){
							final Calendar calendar = Calendar.getInstance();
							calendar.add(Calendar.DAY_OF_WEEK, 1);
							System.out.println("Nurse " + name + "patient needs medication at " + calendar.getTime());
						}
					};
					//dailyTimer.schedule(dailyTask, 1000*60*60*24);
					dailyTimer.schedule(dailyTask, 1000*10);
					break;
				case EveryFourHours:
					final Timer fourHourTimer = new Timer();
					final TimerTask fourHourTask = new TimerTask(){
						@Override
						public void run(){
							final Calendar calendar = Calendar.getInstance();
							calendar.add(Calendar.HOUR, 4);
							System.out.println("Nurse " + name + "patient needs medication at " + calendar.getTime());
						}
					};
					//fourHourTimer.schedule(fourHourTask, 1000*60*60*4);
					fourHourTimer.schedule(fourHourTask, 1000*10);
					break;
				default:
					final SimpleDateFormat sdf = new SimpleDateFormat("dd mm yyyy HH:mm:ss z");
					//sdf.set
					break;
			}
		}
	}
}
