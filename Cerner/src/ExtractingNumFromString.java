//import java.util.Scanner;

public class ExtractingNumFromString {

	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a sequence");
		String input = sc.nextLine();
		*/
		String str1 = "Abcd8732sa1";  // 87321
		String str2 = "Abcd8732+sa1";  // 87321
		
		System.out.println(getNumbers(str1));
		System.out.println(getNumbers(str2));
	}
	
	public static String getNumbers(String str)
	{
		//String result = str.replaceAll("[a-z]|[A-Z]", "");
		String result = str.replaceAll("[^0-9]", "");
		
		return result;
	}

}
