
public class ReverseWords {

	public static void main(final String[] args) {
		final String str1 = "This is a long string";
		final String str2 = "  This    is a Palindrome a is this  ";
		final String str3 = "123 456 789";
		final String str4 = "   A   B ";
		
		System.out.println(getReverse(str1));
		System.out.println(getReverse(str2));
		System.out.println(getReverse(str3));
		System.out.println(getReverse(str4));
	}

	public static String getReverse(String str)
	{
		if (str == null || str.isEmpty()) {
            return str;
        }
		
		final StringBuilder result = new StringBuilder();
		
		str = str.trim();
		final String[] words = str.split(" ");
		
		for (int i=words.length-1; i>=0; i--) {
			String word = words[i];
			if(!(word.length()==0 || word.equals(null)))
				result.append(word + " ");
		}
		
		return result.toString().trim();
	}
}
