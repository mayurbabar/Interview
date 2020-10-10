// https://www.geeksforgeeks.org/minimum-number-of-replacements-to-make-the-binary-string-alternating-set-2/

// Time Complexity: O(N) Where N is the length of input array
// Space Complexity: O(1)
public class MinFlipsToAlternate01 {

	public static void main(String[] args) {
		System.out.println("Min Deletion to obtain string in right format: ");
		System.out.println(solution(new int[] {1,0,1,0,1,1})); // 1
		System.out.println(solution(new int[] {1,1,0,1,1}));   // 2
		System.out.println(solution(new int[] {0,1,0}));       // 0
		System.out.println(solution(new int[] {0,1,1,0}));     // 2
		System.out.println(solution(new int[] {0}));           // 0
		System.out.println(solution(new int[] {1}));           // 0
	}
	
	public static int solution(int[] A) {
		return Math.min(getMinFlips(A, 0), getMinFlips(A, 1)); 
	}

	public static int getMinFlips(int[] A, int expected) {
		int flipCount = 0;
		
		for (int i = 0; i < A.length; i++) {
			// if current character is not expected, 
			// increase flip count 
			if (A[i] != expected)
				flipCount++;

			// flip expected character each time 
			expected = (expected == 0) ? 1 : 0;
		}
		
		return flipCount;
	}

}
