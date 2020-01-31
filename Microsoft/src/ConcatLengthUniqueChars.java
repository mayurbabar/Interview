// https://leetcode.com/discuss/interview-question/401826/

import java.util.ArrayList;
import java.util.List;

public class ConcatLengthUniqueChars {

	public static void main(String[] args) {
		System.out.println("");

		System.out.println(solution(new String[] { "co", "dil", "ity" }));         // 5
		System.out.println(solution(new String[] { "abc", "kkk", "def", "csv" })); // 6
		System.out.println(solution(new String[] { "abc", "ade", "akl" }));        // 0
		System.out.println(solution(new String[] { "abc", "def", "jkl" }));        // 9

	}

	public static int solution(String[] A) {
        // write your code in Java SE 8
        int maxConcatlength = 0;
        
		for (int i = 0; i < A.length; i++) {
			String curr = A[i];
			
			if (!isUnique(curr))
				continue;
				
			int lo = i + 1;
			while (lo < A.length) {
				String result = "";
				result = result + curr;
				
				for (int j = lo; j < A.length; j++) {
					String nextCurr = A[j];
					if (!isUnique(nextCurr))
						continue;
						
					String concatStr = result + nextCurr;
					
					result = isUnique(concatStr) ? concatStr : "";
					if (result.length() > maxConcatlength)
						maxConcatlength = result.length();
						
					result = result.length() == 0 ? curr:concatStr;
				}
				lo++;
			}
		}
		return maxConcatlength;
    }
    
    private static boolean isUnique(String str) {
		int[] charArr = new int[256];

		for (char c : str.toCharArray()) {
			charArr[c]++;

			if (charArr[c] > 1)
				return false;
		}

		return true;
	}
    
	public int maxLength(List<String> arr) {
		if (arr == null || arr.size() == 0)
			return 0;

		List<String> list = new ArrayList<>();
		list.add("");

		for (String str : arr) {
			if (!isUnique(str))
				continue;

			List<String> tempList = new ArrayList<>();

			for (String candidate : list) {
				String temp = candidate + str;
				// System.out.println(temp);

				if (isUnique(temp))
					tempList.add(temp);
			}
			list.addAll(tempList);
		}

		int maxLen = 0;
		for (String str : list)
			maxLen = Math.max(maxLen, str.length());

		return maxLen;
	}

}
