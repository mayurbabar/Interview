package temperature;

public interface IConvertTemp {
	public double getTempInFarenheit(double celcius);
    public double getTempInCelcius(double farenheit);
    public double getTempInKelvin(double farenheit);
}
