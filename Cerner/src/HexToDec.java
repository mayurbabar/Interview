
public class HexToDec {

	public static void main(String[] args) {
		System.out.println("Hex to Decimal: ");
		System.out.println(HtoD("121"));
		System.out.println(HtoD("a"));
		System.out.println(HtoD("f"));
		
		System.out.println("Hex to Decimal using custom logic: ");
		System.out.println(getDecimal("121"));
		System.out.println(getDecimal("a"));
		System.out.println(getDecimal("f"));

	}
	
	public static int HtoD(String Hex)
	{
		int result = 0;
		try {
			result = Integer.parseInt(Hex, 16);
		} catch (Exception e) {
			System.out.println("Cannot convert the given hex string to integer");
		}
		return result;
	}
	
	public static int getDecimal(String hex){  
	    String digits = "0123456789ABCDEF";  
	    hex = hex.toUpperCase();  
        int val = 0;  
        for (int i = 0; i < hex.length(); i++)  
        {  
            char c = hex.charAt(i);  
            int d = digits.indexOf(c);  
            val = 16*val + d;  
        }  
        return val;  
	}

}
