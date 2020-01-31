package temperature;

public interface ITemperature {
	public double getCurrentTemp();
    public double setDefaultTemp(double defaultCelcius);
    public boolean hasFever(double defaultTemp);
    public Location getLocation();
	public void setLocation(Location location);
}
