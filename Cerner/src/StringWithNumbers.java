
public class StringWithNumbers {

	public static void main(String[] args) {
		String str1 = "a,1,b,2,c,3,d,4,e,5";
		String str2 = "x,11,y,22,z,33";
		
		seperate(str1);
		seperate(str2);
	}

	public static void seperate(String str)
	{
		String[] stringArray = str.split(",");
		//str = str.replaceAll(",", "");
		
		StringBuilder alphabets = new StringBuilder();
		StringBuilder numbers = new StringBuilder();
		
		//char[] charArr = str.toCharArray();
		
		for(String s: stringArray) {
			if(isInteger(s)) {
				numbers.append(s + " ");
			}
			else {
				alphabets.append(s + " ");
			}
		}
		
		System.out.println("Alphabet: "+ alphabets.toString().trim());
		System.out.println("num: "+ numbers.toString().trim());
	}
	
	public static boolean isInteger( String input )
	{
	   try
	   {
	      Integer.parseInt( input );
	      return true;
	   }
	   catch(Exception e)
	   {
	      return false;
	   }
	}
}
