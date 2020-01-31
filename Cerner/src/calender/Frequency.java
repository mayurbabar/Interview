package calender;

public class Frequency {
	
	public enum PartofDay{
		Hourly,
		Daily,
		EveryFourHours
	}
	
	public PartofDay part;
	
	public PartofDay getPart() {
		return part;
	}

	public void setPart(PartofDay part) {
		this.part = part;
	}

	public Frequency (PartofDay part){
		this.part = part;
	}
}
