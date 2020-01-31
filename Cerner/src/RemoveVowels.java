//import java.util.Arrays;
//import java.util.List;

public class RemoveVowels {

	public static void main(String[] args) {
		String str1 = "welcome to geeksforgeeks";
		String str2 = "what is your name ?";

		System.out.println(remVowel(str1));
		System.out.println(remVowel(str2));
	}
	
	static String remVowel(String str)
    {
		String vowels = "[aeiouAEIOU]";
		
		return str.replaceAll(vowels, "");
		
		/*
         Character vowels[] = {'a', 'e', 'i', 'o', 'u','A','E','I','O','U'};
          
         List<Character> al = Arrays.asList(vowels);
          
         StringBuffer sb = new StringBuffer(str);
          
         for (int i = 0; i < sb.length(); i++) {
             
             if(al.contains(sb.charAt(i))){
                sb.replace(i, i+1, "") ;
                i--;
             }
        }
        
        return sb.toString();
        */
    }

}
