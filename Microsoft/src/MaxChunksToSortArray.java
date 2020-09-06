// https://leetcode.com/discuss/interview-question/524146/

// Basically we maintain 2 arrays rightMin and leftMax. Traverse through the left max if the current max is less than rightMin of 
// next index then we can make a split as all the number in left are smaller than right. 
// Time Complexity: O(N) Where N is the length of input array.
// Space Complexity: O(N)

public class MaxChunksToSortArray {

	public static void main(String[] args) {
		System.out.println("Max Chunks to Sort Array...");
		System.out.println(solution(new int[] {2,4,1,6,5,9,7}));  // 3
		System.out.println(solution(new int[] {4,3,2,6,1}));      // 1
		System.out.println(solution(new int[] {2,1,6,4,3,7}));    // 3
		System.out.println(solution(new int[] {1,0,2,3,4}));      // 4

	}

	private static int solution(int[] A) {
        int n = A.length;
        int[] rightMin = new int[n];
        
        // Calculate and store minimum value from the end (right side)
        rightMin[n-1] = A[n-1];
        for(int i=n-2;i>=0;i--){
            rightMin[i] = Math.min(A[i], rightMin[i+1]);
        }
        
        int count = 0, max = A[0];
        for(int i=0;i<n;i++){
        	// Calculate max till index i
            max = Math.max(max, A[i]);
            
            // If all the elements in left are smaller than right, increment count
            if(i==n-1 || max <= rightMin[i+1]) 
            	count++;
        }
        
        return count;
	}
}
