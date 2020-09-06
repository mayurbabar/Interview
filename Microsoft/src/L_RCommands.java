import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/discuss/interview-question/555715/Microsoft-or-Online-Codility-Assessment-or-L-and-R-Commands-(Task-3)

// Time Complexity:
// Space Complexity:

public class L_RCommands {

	public static void main(String[] args) {

		System.out.println(solution(-11) == 4);
	}
	
	public static int solution(int N) {
		int[] nums = new int[]{0, 1};
		int result = 0;
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(nums);
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0;i<size;i++) {
				int[] cur = q.poll();
				
				if(cur[0] == N || cur[1] == N)
					return result;
				
				q.offer(new int[] {2*cur[0] - cur[1], cur[1]});
				q.offer(new int[] {cur[0], 2*cur[1] - cur[0]});
			}
			result++;
		}
		return -1;
	}
}
