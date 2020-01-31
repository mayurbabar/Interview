
public class ArmstrongNumber {

	public static void main(String[] args) {
		int num1 = 153;
		int num2 = 0;
		int num3 = 1;
		int num4 = 370;
		int num5 = 15;
		int num6 = 57;
		int num7 = 371;
		int num8 = 407;
		
		System.out.println(isArmstrong(num1));  //true
		System.out.println(isArmstrong(num2));  //true
		System.out.println(isArmstrong(num3));  //true
		System.out.println(isArmstrong(num4));  //true
		System.out.println(isArmstrong(num5));  //false
		System.out.println(isArmstrong(num6));  //false
		System.out.println(isArmstrong(num7));  //true
		System.out.println(isArmstrong(num8));  //true

	}
	
	public static boolean isArmstrong(int num)
	{
		boolean result = false;
		int digit=0, armstrongNumber = 0;
				
		int originalNumber = num;
		
		while(num>0)  
	    {  
			digit = num % 10;  
			num = num / 10;  
			armstrongNumber = armstrongNumber + (digit * digit * digit);  
	    }
		
	    if(originalNumber == armstrongNumber)
	    	result = true;
	    else
	    	result = false;
	    
		return result;
	}

}
