package temperature;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

	public static void main(String[] args) {
		ITemperature temp = new Temperature();
		IConvertTemp convertTemp = new Temperature();

		/*
		Location loc = Location.Armpit;
		System.out.println(loc.getValue());
		Location.Mouth.getValue();
		*/
		boolean valid = true;
        while(valid){
            System.out.println("Default temperatures: "+temp.getCurrentTemp()+"C OR "+convertTemp.getTempInFarenheit(temp.getCurrentTemp())+"F");
            System.out.println("1.Convert Celcius to Fareiheit");
            System.out.println("2.Convert Fareiheit to Celcius");
            System.out.println("3.Record default temperature");
            System.out.println("4.Record location of temperature");
            System.out.println("5.Do I have Fever");
            System.out.println("6.Schedule to record temperature every hour");
            System.out.println("7.Exit");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            
            switch (input) 
            {
            	case 1: System.out.println("Enter temperature in Celcius to convert into Farenheit");
                	double celcius = sc.nextDouble();
                	System.out.println(celcius+"C = "+convertTemp.getTempInFarenheit(celcius)+"F");
                	break;
            	case 2: System.out.println("Enter temperature in Farenheit to convert into Celcius");
            		double fareinheit = sc.nextDouble();
            		System.out.println(fareinheit+"F = "+convertTemp.getTempInCelcius(fareinheit)+"C");
            		break;
            	case 3: System.out.println("Record temperature in celcius");
            		temp.setDefaultTemp(sc.nextDouble());
            		break;
            	case 4: System.out.println("Record location (Armpit, Mouth, Ear)");
        			temp.setLocation(Location.valueOf((sc.nextLine())));
        			break;
            	case 5: System.out.println("Enter your current temperature in celcius");
            		boolean fever = temp.hasFever(sc.nextDouble());
            		if (fever)
            			System.out.println("Yes, you have Fever");
            		else
            			System.out.println("No, you don't have fever");
    				break;
            	case 6: 
	        		Timer hourlyTimer = new Timer();
	        		TimerTask hourlyTask = new TimerTask() {
						
						@Override
						public void run() {
							System.out.println("Enter your current temperature in celcius");
			        		temp.setDefaultTemp(sc.nextDouble());
						}
					};
					hourlyTimer.schedule(hourlyTask, 1000*60*60);
					break;
            	case 7: System.out.println("Thank you for using");
            		valid = false;
	        		break;
            	default:	
            		System.out.println("Invalid input.");;
            }
            //sc.close();
        }

	} 

}
