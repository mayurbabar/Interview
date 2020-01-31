// https://leetcode.com/discuss/interview-question/398047/

import java.util.HashMap;
import java.util.Map;

public class DayOfWeek {

	public static void main(String[] args) {
		System.out.println(solution("Mon", 2));  // Wed
		System.out.println(solution("Sat", 23)); // Mon
		System.out.println(solution("Fri", 7));  // Fri
		System.out.println(solution("Tue", 0));  // Tue
	}

	public static String solution(String S, int K) {
		String[] days = new String[] {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		Map<String, Integer> dayToIndex = new HashMap<>();
		
		for(int i=0; i < days.length; i++)
			dayToIndex.put(days[i], i);
		
		int index = (dayToIndex.get(S) + K) % 7;
		return days[index];
	}
}
