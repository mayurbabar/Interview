package temperature;

public class Temperature implements ITemperature, IConvertTemp{
	private double defaultTemp=0.0;
	private Location location;

	public Temperature(){}
	
    public Temperature(double defaultTemp){
        this.defaultTemp=defaultTemp;
    }
    
    public Temperature(double defaultTemp, Location location){
        this.defaultTemp = defaultTemp;
        this.setLocation(location);
    }
    
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

    public boolean hasFever(double defaultTemp){
        return (defaultTemp > 36) ? true : false;
    }

    @Override
    public double getTempInFarenheit(double celcius) {
        return ((double)9/5*(celcius+32.0));
    }

    @Override
    public double getTempInCelcius(double farenheit) {
        return ((double)5/9*(farenheit-32.0));
    }

    @Override
    public double getCurrentTemp() {
        return defaultTemp;
    }

    @Override
    public double setDefaultTemp(double defaultCelcius){
        return this.defaultTemp = defaultCelcius;
    }

	@Override
	public double getTempInKelvin(double farenheit) {
		return ((double)(5/9*(farenheit-32.0))+273);
	}


}
