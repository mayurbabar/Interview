package calender;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
	private List<AlarmListener> alarmListenerList = new ArrayList<>();
	
	public void addListener(AlarmListener alarmlistener){
		alarmListenerList.add(alarmlistener);
	}
	
	public void notifyListener(Frequency.PartofDay time){
		for(AlarmListener a: alarmListenerList){
			a.notify(time);
		}
	}
}
