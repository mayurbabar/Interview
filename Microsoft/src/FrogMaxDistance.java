// https://leetcode.com/discuss/interview-question/651142/Microsoft-Online-Assesment-Question (Task 2)

// Time Complexity: O(N) Where N is the length of the input arrays
// Space Complexity: O(N)
// We will pre-compute 2 arrays
// Left: left[i] will indicate that starting from index i, till what index frog can jump to left
// Right: Right[i] will indicate that starting from index i, till what index frog can jump to right.
// Then we will calculate the difference between right and left to find the maximum distance at each index and our answer will be 
// the max distance of all the differences.

public class FrogMaxDistance {

	public static void main(String[] args) {

		System.out.println("Use solution2. Remember it will return abs difference between the index");
		System.out.println(solution(new int[] {2,6,8,5}, 4) == 3);
		System.out.println(solution(new int[] {1,5,5,2,6}, 5) == 4);
		System.out.println(solution(new int[] {5,5,5,5}, 4) == 4);
		System.out.println(solution2(new int[] {5,5}));
		System.out.println(solution2(new int[] {5}));
		
		System.out.println(solution2(new int[] {2,6,8,5}) == 2);
		System.out.println(solution2(new int[] {1,5,5,2,6}) == 3);
		System.out.println(solution2(new int[] {5,5,5,5}) == 3);
		System.out.println(solution2(new int[] {5,5}) == 1);
		System.out.println(solution2(new int[] {5}) == 0);

	}
	
	public static int solution(int[] blocks, int N) {
		int ans=0, left=1, right=1;
	    
	    for(int i=1; i<blocks.length; i++){

	        left = (blocks[i-1] >= blocks[i]) ? left+1 : 1;
	        right = (blocks[i-1] <= blocks[i]) ? right+1 : 1;
	        
	        right = Math.max(right, left);    
	        ans = Math.max(ans, right);
	    }
	    return ans;
	}
	
	public static int solution2(int[] blocks) {
		int n=blocks.length;
		int[] left = new int[n];
		int[] right = new int[n];
		right[n-1] = n-1;
	    
	    for(int i=1; i<n; i++){
	    	if(blocks[i-1] >= blocks[i])
	    		left[i] = left[i-1];
	    	else
	    		left[i] = i;
	    }
	    
	    for(int i=n-2; i>=0; i--){
	    	if(blocks[i] <= blocks[i+1])
	    		right[i] = right[i+1];
	    	else
	    		right[i] = i;
	    }
	    
	    int result=0;
	    for(int i=0; i<n; i++){
	    	result = Math.max(result, right[i] - left[i]);
	    }
	    return result;
	}
}
