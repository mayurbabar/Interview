
public class StringNumber {

	public static void main(String[] args) {
		String str1 = "abcdefg";
		String str2 = "xyz";
		String str3 = "macxz";
		
		System.out.println(getNumber(str1)); //0123456
		System.out.println(getNumber(str2)); //232425
		System.out.println(getNumber(str3)); //12022325
	}

	public static String getNumber(String str)
	{
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			if(c < 97 || c > 122) {
				return "none";
				//System.out.println("none");
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (char c : str.toCharArray()) {
		    //sb.append((int)(c - 'a' + 1));
		    sb.append((int)(c - 'a' + 0));
		}

		return sb.toString();
		
		
		/*
		char[] arr = {'a','b','c','d','e','f','g','h',
					  'i','j','k','l','m','n','o','p',
					  'q','r','s','t','u','v','w','x','y','z'};
		ArrayList alphabets = new ArrayList<>(Arrays.asList(arr));
		
		for (int i=0; i< alphabets.size(); i++) {
			System.out.print(alphabets.get(i));
		}
		
		StringBuilder result = new StringBuilder();
		
		for(int i=0; i<str.length(); i++){
			//result.append(alphabets.indexOf(str.charAt(i)));
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == str.charAt(i))
					result.append(j);
			}
		}
		
		String finalstr = result.toString();
		System.out.println(finalstr);
		return finalstr;
		*/
	}
}
