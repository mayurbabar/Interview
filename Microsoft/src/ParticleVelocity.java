// https://leetcode.com/discuss/interview-question/428272/Microsoft-or-count-stable-particles
// https://leetcode.com/discuss/interview-question/428272/

public class ParticleVelocity {

	public static void main(String[] args) {
		System.out.println(countStableInstances(new int[] {-1,1,3,3,3,2,3,2,1,0}));
		System.out.println(countStableInstances(new int[] {-1,1,3,3,3,2,3,2,1,0,-1}));
	}
	
	public static int countStableInstances(int[] nums) {
		int result =0;
		
		for(int i=0; i<nums.length-2; i++) {
			if(nums[i+2] - nums[i+1] == nums[i+1] - nums[i]) {
				result++;
				
				for(int j=i+3; j<nums.length; j++) {
					if(nums[j] - nums[j-1] == nums[i+2] - nums[i+1]) 
						result++;
				}
			}
		}
		
		return result < 1_000_000_000 ? result : -1;
	}
}
