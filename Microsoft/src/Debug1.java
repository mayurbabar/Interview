import java.util.ArrayList;
import java.util.Arrays;

public class Debug1 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(2, 4))); 
		System.out.println(Arrays.toString(solution(1, 4))); 
		System.out.println(solution(2, 0).length);
		System.out.println(Arrays.toString(solution(2, 0))); 
		System.out.println(Arrays.toString(solution(3, 20)));
		System.out.println(Arrays.toString(solution(5, 6))); 
		System.out.println(Arrays.toString(solution(5, 2))); 
	}

	public static String[] solution(int N, int K) {
		if (N ==0)
			return new String[] {""};
		
		ArrayList<String> result = new ArrayList<String>();
//		for(String p : solution(N-1, K-1)) {
		for(String p : solution(N-1, K)) {
			for(char l : new char[] {'a', 'b', 'c'}) {
				int pLen = p.length();
				
				if(pLen ==0 || p.charAt(pLen - 1) != l)
					result.add(p+l);
			}
		}
		
		int prefSize = Math.min(result.size(), K);
		return result.subList(0, prefSize).toArray(new String[prefSize]);
	}
}
