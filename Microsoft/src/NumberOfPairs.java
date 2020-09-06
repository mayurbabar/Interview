import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/discuss/interview-question/651142/Microsoft-Online-Assesment-Question (Task 3)

// Time Complexity: O(N) Where N is the length of the input arrays
// Space Complexity: O(N) hashMap + O(N) recursion

public class NumberOfPairs {

	public static void main(String[] args) {

		System.out.println(solution(new int[] {3,5,6,3,3,5}) == 4);
		System.out.println(solution(new int[] {5,5,5,5,5}) == 10);

	}
	
	public static int solution(int[] A) {
		Map<Integer, Integer> map = new HashMap<>();
		
	    for(int num : A)
	    	map.put(num, map.getOrDefault(num, 0)+1);
	    
	    int ans=0;
	    for(int key : map.keySet()) {
	    	if(map.get(key) > 1)
	    		ans += getcount(map.get(key)) % 1000000000;
	    }
	    
	    return ans;
	}
	
	public static int getcount(int num) {
		if(num == 1)
			return 0;
		
		return num-1 + getcount(num-1);
	}

}
