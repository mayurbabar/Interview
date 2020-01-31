/*
The length of the repeating substring must be a divisor of the length of the input string
Search for all possible divisor of str.length, starting for 1 to length/2
If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
If the repeated substring is equals to the input str return true
*/

public class RepeatingString {

	public static void main(String[] args) {
		String str1 = "abcabcabc";  //3
		String str2 = "bcbcbcbcbcbcbcbcbcbcbcbcbcbc";  //14
		String str3 = "dddddddddddddddddddd";  //20
		String str4 = "adcdefg";  //1
		String str5 = "bcbdbcbcbdbc";  //2
		String str6 = "hellohell";  //1

		System.out.println(getRepeatNum(str1)); //3
		System.out.println(getRepeatNum(str2)); //14
		System.out.println(getRepeatNum(str3)); //20
		System.out.println(getRepeatNum(str4)); //1
		System.out.println(getRepeatNum(str5)); //2
		System.out.println(getRepeatNum(str6)); //1
	}
	
	public static int getRepeatNum(String str)
	{
		int length = str.length();
		for(int i=1;i<=length/2; i++) 
		{
			if(length%i==0) 
			{
				int m = length/i;
				
				String subS = str.substring(0,i);
				StringBuilder sb = new StringBuilder();
				
				for(int j=0;j<m;j++) 
				{
					sb.append(subS);
				}
				
				if(sb.toString().equals(str)) 
					return m;       //for number of smallest string repetition.
					//return i;     //for length of smallest repeated string.
			}
		}
		return 1;
	}

}
