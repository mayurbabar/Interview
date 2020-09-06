// https://leetcode.com/discuss/interview-question/651142/Microsoft-Online-Assesment-Question (Q1)

// In binary, right shift will divide the number by 2. We are excluding leading zeros as no operation need to be performed on them.
// If the last digit of a binary number is zero that means the number is even and if it is 1 then it's a odd number.
// For even number we can do right shift(divide by 2) and increment the steps counter. 
// For odd number we need to subtract 1 so that number will become even and then divide that number so total 2 steps are needed for odd number (last digit 1).
// The edge case here is for binary number 1. It's a odd number but if you subtract 1 it will become zero and we can stop the processing. 
// so only 1 step is required, that's why we subtract 1 from final answer.

// Time Complexity: O(N) Where N is the length of binary string
// Space Complexity: O(1)

public class StepsToConvertBinaryNumberTo0 {

	public static void main(String[] args) {
		System.out.println("Number of steps required to convert a binary number to zero: ");
		System.out.println(solution("011100"));        // 7
		System.out.println(solution("111"));           // 5
		System.out.println(solution("1111010101111")); // 22
		System.out.println(solution("00011100"));      // 7
		System.out.println(solution(null));            // 0
		System.out.println(solution(""));              // 0

	}
	
	public static int solution(String S) {
		if(S == null || S.length() == 0)
			return 0;
		
		int leadingZero=0, zeros=0, ones=0;
		
		// Count leading zeros so that we can ignore them
		for(int i=0; i<S.length(); i++) {
			if(S.charAt(i) == '1')
				break;
			
			leadingZero++;
		}
		
		// count total number of zeros and ones in binary string excluding leading zeros
		for(int i=S.length()-1; i>=leadingZero; i--) {
			if(S.charAt(i) == '0') 
				zeros++;
			else
				ones++;
		}
		
		return ones*2 + zeros - 1;
	}

}
