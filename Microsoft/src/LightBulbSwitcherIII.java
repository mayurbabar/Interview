// https://leetcode.com/discuss/interview-question/502549/

// Time Complexity: O(N)
// Space Complexity: O(1)

public class LightBulbSwitcherIII {

	public static void main(String[] args) {
		System.out.println("Light Bulb Switcher Solution 1: ");
		System.out.println(solution(new int[] {2,1,3,5,4}));    // 3
		System.out.println(solution(new int[] {3,2,4,1,5}));    // 2
		System.out.println(solution(new int[] {4,1,2,3}));      // 1
		System.out.println(solution(new int[] {2,1,4,3,6,5}));  // 3
		System.out.println(solution(new int[] {1,2,3,4,5,6}));  // 6
		
		System.out.println("Light Bulb Switcher Solution 2: ");
		System.out.println(solution2(new int[] {2,1,3,5,4}));    // 3
		System.out.println(solution2(new int[] {3,2,4,1,5}));    // 2
		System.out.println(solution2(new int[] {4,1,2,3}));      // 1
		System.out.println(solution2(new int[] {2,1,4,3,6,5}));  // 3
		System.out.println(solution2(new int[] {1,2,3,4,5,6}));  // 6
	}
	
	public static int solution(int[] A) {
        int indexSum = 0;
        int arrSum = 0;
        int count=0;
        
        // The sum of the positions of the turned on bulbs must be 1+2+3+...+k. 
        // This sum also has to be equal to 1+2+3+ ... +i (1 based index) because no other bulb after 
        // position k must not be turned on according to given condition.
        for(int i=1; i<= A.length; i++){
            arrSum += A[i-1];
            indexSum += i;
            
            if(arrSum == indexSum)
                count++;
        }
        
        return count;
	}

	public static int solution2(int[] A) {
		int right = 0;   // number of the right most lighted bulb.
		int res = 0;
		
        for (int i = 0; i < A.length; ++i) {
        	// Find the right most lighted bulb
            right = Math.max(right, A[i]);
            
            // if right == i + 1, it means that all the previous bulbs (to the left) are turned on too.
            if (right == i + 1) 
            	res++;
        }
        return res;
	}
}
