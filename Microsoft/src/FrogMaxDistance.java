// https://leetcode.com/discuss/interview-question/651142/Microsoft-Online-Assesment-Question (Task 2)

// Time Complexity: O(N) Where N is the length of the input arrays
// Space Complexity: O(1)

public class FrogMaxDistance {

	public static void main(String[] args) {

		System.out.println(solution(new int[] {2,6,8,5}, 4) == 3);
		System.out.println(solution(new int[] {1,5,5,2,6}, 5) == 4);
		System.out.println(solution(new int[] {5,5,5,5}, 4) == 4);

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

}
