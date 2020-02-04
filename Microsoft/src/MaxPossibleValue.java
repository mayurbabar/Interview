// https://leetcode.com/discuss/interview-question/398050/

public class MaxPossibleValue {

	public static void main(String[] args) {
		System.out.println("Max Possible Value: ");
		System.out.println(solution(268));  // 5268
		System.out.println(solution(670));  // 6750
		System.out.println(solution(0));    // 50
		System.out.println(solution(552));  // 5552
		System.out.println(solution(-999)); // -5999

	}
	
	public static int solution(int N) {
		boolean isNegative = false;
		
		if(N < 0) {
			isNegative = true;
			N = N * (-1);
		}
		StringBuilder sb = new StringBuilder(String.valueOf(N));
		
		if(isNegative) {
			int i=0;
			
			// Find the index of first number greater than 5
			for(; i< sb.length(); i++) {
				if ((sb.charAt(i) - '0') > 5)
					break;
			}
			sb.insert(i, 5);
		}
		else {
			int i=0;
			
			// Find the index of first number less than 5
			for(; i< sb.length(); i++) {
				if ((sb.charAt(i) - '0') < 5)
					break;
			}
			sb.insert(i, 5);
		}
		
		int result = Integer.parseInt(sb.toString());
		
		if(isNegative)
			result = (-1) * result;
		
		
		return result;
	}

}
