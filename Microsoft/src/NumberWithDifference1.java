import java.util.HashSet;
import java.util.Set;

// Missing leetcode link

// Time Complexity  - O(N) - N is the Number of integers in the input array.
// Space Complexity - O(N) - Used HashMap to store visited numbers, so at max HashMap will contain N numbers.

class NumberWithDifference1 {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {0,1,3,5,7,2}));  // true
		System.out.println(solution(new int[] {1,3,5,7,10}));   // false
		System.out.println(solution(new int[] {10,1,2,2,2,2})); // true
		System.out.println(solution(new int[] {0,10,8,4,1}));   // true
		System.out.println(solution(new int[] {0,10,8,4,2}));   // false
		System.out.println(solution(new int[] {1,2}));          // true
		System.out.println(solution(new int[] {1,3,-1,-3}));    // false
		System.out.println(solution(new int[] {0,2,4,-1,-3}));  // true
		
	}
	
    public static boolean solution(int[] A) {
        //Keep the visited numbers for faster lookup
    	Set<Integer> visited = new HashSet<>();
    	
    	for(int num : A) {
    		if(visited.contains(num+1) || visited.contains(num-1))
    			return true;
    		
    		visited.add(num);
    	}
    	
    	return false;
    }
}
