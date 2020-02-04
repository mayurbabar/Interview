// https://leetcode.com/discuss/interview-question/398035/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class MinDeleteUniqueFreq {

	public static void main(String[] args) {
		System.out.println("Please take a look at 'Solution2' method");
		System.out.println(solution2("eeeeffff"));      // 1
		System.out.println(solution2("aabbffddeaee"));  // 6
		System.out.println(solution2("llll"));          // 0
		System.out.println(solution2("example"));       // 4
		System.out.println(solution2(""));              // 0
		System.out.println(solution2(null));            // 0
	}

	public static int solution(String S) {
		if(S == null || S.length() == 0)
			return 0;
		
		Map<Character, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();
		
		// Max Heap
		PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
		boolean foundLast = false;
		int result=0;
		
		// Calculate the count of each character in the string
		for(char c: S.toCharArray())
			map.put(c, map.getOrDefault(c, 0)+1);
		
		for(char c: map.keySet())
			pq.offer(c);
		
		while(!pq.isEmpty()) {
			char c = pq.poll();
			int freq = map.get(c);
			
			if(!set.contains(freq))
				set.add(freq);
			else {
				if(!foundLast) {
					while(freq > 0 && set.contains(freq)) {
						freq--;
						result++;
					}
					if(freq == 1)
						foundLast = true;
					
					set.add(freq);
				}
				else
					result += freq;
					
			}
		}
		
		return result;
	}
	
	
	public static int solution2(String S) {
		if(S == null || S.length() == 0)
			return 0;
		
		HashMap<Character, Integer> map = new HashMap<Character,Integer>();
		
		// Calculate the count of each character in the string
		for(char c: S.toCharArray())
		        map.put(c,map.getOrDefault(c, 0)+1);

		int result = 0;
		HashSet<Integer> set = new HashSet<>();
		
		for(int count : map.values()){
		    
		    if(!set.contains(count)){
		        set.add(count);
		    }else{
		    	// character count is present in the set then delete char until the frequency is not in the set or freq = 0
		    	int n = count;
		        while(set.contains(n) && n>0){
		        	n=n-1;
		        	result=result+1;
		        } 
		        if(n>0){
		        	set.add(n);
		        }
		    }
		}

		return result;
	}
}
