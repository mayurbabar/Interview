package temperature;

public enum Location {
	Mouth(1),
	Ear(2),
	Armpit(3);
	
	private int value = 0;
	
	Location (int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
}
