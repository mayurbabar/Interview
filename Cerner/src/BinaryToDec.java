import java.util.ArrayList;
import java.util.List;

public class BinaryToDec {

	public static void main(String[] args) {
		System.out.println("Binary To Integer:");
		System.out.println(BtoD("1010"));
		System.out.println(BtoD("10101"));
		System.out.println(BtoD("11111"));
		System.out.println(BtoD("101sa"));
		System.out.println();
		
		System.out.println("Binary To Integer using custom logic:");
		System.out.println(getDecimal(1010));
		System.out.println(getDecimal(10101));
		System.out.println(getDecimal(11111));
		System.out.println();
		
		System.out.println("Integer to Binary :");
		System.out.println(DtoB(10));
		System.out.println(DtoB(21));
		System.out.println(DtoB(31));
		System.out.println(DtoB(101));
		System.out.println();
		
		System.out.println("Integer To Binary using custom logic:");
		System.out.println(getBinary(10));
		System.out.println(getBinary(21));
		System.out.println(getBinary(31));
		System.out.println(getBinary(101));
		System.out.println();
	}
	
	public static int BtoD (String Binary)
	{
		int result = 0;
		try {
			result = Integer.parseInt(Binary,2);
		} catch (Exception e) {
			System.out.println("Cannot convert the given binary string to integer");
		}
		
		return result;
	}
	
	public static String DtoB (int num)
	{
		String result = "";
		result = Integer.toBinaryString(num);
		
		return result;
	}

	public static int getDecimal(int binary){  
	    int decimal = 0;  
	    int n = 0;  
	    while(true){  
	      if(binary == 0){  
	        break;  
	      } else {  
	          int temp = binary%10;  
	          decimal += temp*Math.pow(2, n);  
	          binary = binary/10;  
	          n++;  
	       }  
	    }  
	    return decimal;  
	}
	
	public static String getBinary(int num){  
	    List<Integer> binary = new ArrayList<Integer>();
	    StringBuilder result = new StringBuilder();
	    int k = 0;

	    while(num > 0){    
	    	binary.add(num%2);
	    	result.append(Integer.toString(num%2));
	    	num = num/2;
	    }  
	    
	    Integer[] arr = new Integer[binary.size()];
	    
        // ArrayList to Array Conversion
        for (int i = binary.size()-1; i >= 0; i--)
            arr[k++] = binary.get(i);
        
	    String BinaryString = result.reverse().toString();
	    
	    return BinaryString;  
	}
	
}
