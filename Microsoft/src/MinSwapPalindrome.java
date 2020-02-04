// https://leetcode.com/discuss/interview-question/351783/

import java.util.HashMap;
import java.util.Map;

public class MinSwapPalindrome {

	public static void main(String[] args) {
		System.out.println(solution("mamad"));  // 3
		System.out.println(solution("asflkj")); // -1
		System.out.println(solution("aabb"));   // 2
		System.out.println(solution("ntiin"));  // 1
		System.out.println(solution("nitin"));  // 0
		System.out.println(solution(""));       // -1
		System.out.println(solution(null));     // -1
	}

	public static int solution(String S) {
		// Assuming null and empty string are not a valid input strings.
		if(S == null || S.length() == 0 || !canFormPalindrome(S))
			return -1;
		
		char[] word = S.toCharArray();
		int i=0, j= word.length-1, result=0;
		
		while(i<j) {
			int k=j;
			
			// find the character k from end(j) matching with start character(i)
			while(word[i] != word[k] && k > i)
				k--;
			
			if(word[i] == word[k] && i != k) {
				// if matching character(k) is other than end character, swap until it becomes end character(j)
				while(k < j) {
					swap(word, k, k+1);
					k++;
					result++;
				}
				i++;
				j--;
			}
			else {
				swap(word, i, i+1);
				result++;
			}
		}
		
		return result;
	}
	
	// Return true if permutation of string can form palindrome.
	private static boolean canFormPalindrome(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        int oddCount = 0;
        
        for(char c: s.toCharArray())
            chars.put(c, chars.getOrDefault(c,0)+1);
        
        for(char c: chars.keySet()){
            if(chars.get(c)%2 == 1)
                oddCount++;
        }
        return (oddCount <= 1) ? true : false;
    }
	
	private static void swap(char[] word, int i, int j) {
		char temp = word[i];
		word[i] = word[j];
		word[j] = temp;
	}

}
