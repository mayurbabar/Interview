// https://leetcode.com/discuss/interview-question/548119/

// Time Complexity  - O(N) - N is the Number of characters in the input String
// Space Complexity - O(1) - since both arrays lowerChar and upperChar sizes are fixed (number of alphabets - 26) and does not depend on varying input.

class LargestLetterWithBothLowerAndUpperCase {
	
	public static void main(String[] args) {
		System.out.println(solution("admeDCAB"));  // D
		System.out.println(solution("aaaaaa"));    // No
		System.out.println(solution("BBBBB"));     // No
		System.out.println(solution("aA"));        // A
		System.out.println(solution("AAAbczdseZaaa"));  // Z
	}
	
    public static String solution(String S) {
        // write your code in Java SE 8
        
        //Keep the count of each lower case and upper case letters
        int[] lowerChar = new int[26];
        int[] upperChar = new int[26];
        
        for (int i =0; i< S.length(); i++){
            char c = S.charAt(i);
            
            // Increment counts of each character
            if (Character.isUpperCase(c)) 
            	upperChar[c-'A']++;
            else if (Character.isLowerCase(c)) 
            	lowerChar[c-'a']++;
        }
        
        //Traverse from the end as we need largest letter
        for (int j = 25; j>=0; j--){
            if (lowerChar[j] > 0 && upperChar[j] > 0) {
                //Get the upper case letter which meets the condition
                return String.valueOf((char)(j + 'A'));
            }
            
        }
        // None of the input letters has both upper case and lower case
        return "NO";
    }
}
