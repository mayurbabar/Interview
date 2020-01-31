// Given one sentence at a time, return the second last word of the sentence.

public class SecondLast {

	public static void main(String[] args) {
		String str1 = "This is a very long, sentence with last? word.";
		String str2 = "This is a very long, sentence with last word.";
		String str3 = "This is a very long, sentence with last?   word.";
		
		System.out.println("Second Last Word is: " + findWord(str1));
		System.out.println("Second Last Word is: " + findWord(str2));
		System.out.println("Second Last Word is: " + findWord(str3));

	}
	
	public static String findWord(String str)
	{
        String separators = " ";
        
        String[] words = str.split(separators);

        /* //Print the words array 
        for (int i = 0; i < words.length; i++)
        {
        	System.out.println(words[i]);
        }
        */
        
        return words[words.length - 2];
	}

}
