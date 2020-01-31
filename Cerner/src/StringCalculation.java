public class StringCalculation {

	public static void main(String[] args) {
		String str1 = "123456 abc+efg";
		String str2 = "456123 abc-efg";
		String str3 = "4123 a+efg";  
		
		System.out.println(calculate(str1));  //579
		System.out.println(calculate(str2));  //333
		System.out.println(calculate(str3));  //127
	}

	public static int calculate(String str)
	{
		int result = 0;
		char operation = 0;
		String number1 = "", number2 = "";
		
		String[] numStr = str.split(" ");
		
		String numbers = numStr[0];
		String alphabets = numStr[1];
		
		for (int i = 0; i < alphabets.length(); i++) {
			if(alphabets.charAt(i) == '+' ||  alphabets.charAt(i) == '-')
			{
				operation = alphabets.charAt(i);
				number1 = numbers.substring(0, i);
				number2 = numbers.substring(i, numbers.length());
			}
		}
		
		if (operation == '+')
			result = Integer.parseInt(number1) + Integer.parseInt(number2);
		else if(operation == '-')
			result = Integer.parseInt(number1) - Integer.parseInt(number2);
		else
			result = -1;
		
		return result;
	}
}
