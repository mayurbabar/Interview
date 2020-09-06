// https://leetcode.com/discuss/interview-question/654921/

// Time Complexity: O(N*N) Where N is the length of input array.
// Space Complexity: O(N) Recursion stack space.

public class AladdinChackersGame {

	public static void main(String[] args) {

		System.out.println(solution(new String[] {"..X...", "......", "....X.", ".X....", "..X.X.", "...O.."}) == 2);
		System.out.println(solution(new String[] {"X....", ".X...", "..O..", "...X.", "....."}) == 0);
	}

	public static int solution(String[] B) {
		
		for(int i=0; i<B.length; i++) {
			for(int j=0; j<B[i].length(); j++) {
				if(B[i].charAt(j) == 'O')
					return getMaxMoves(B, i, j); 
			}
		}
		return 0;
	}
	
	private static int getMaxMoves(String[] B, int r, int c) {
		int moves=0;
		int[][] directions = new int[][] {{-2,2},{-2,-2}};
		
		for(int d[] : directions) {
			// next move coordinates
			int nextR = r + d[0];
			int nextC = r + d[1];
			
			// coordinates to check for Aladdin piece
			int r1 = r + d[0]/2;
			int c1 = c + d[1]/2;
			
			if (isValid(B, nextR, nextC) && B[nextR].charAt(nextC) == '.' && B[r1].charAt(c1) == 'X') {
				// Eat the Aladdin piece to avoid see it again in the recursion.
				StringBuilder oldRow = new StringBuilder(B[r1]);
				oldRow.setCharAt(c1, '.');
				B[r1] = oldRow.toString();
				
				moves = Math.max(moves, 1 + getMaxMoves(B, nextR, nextC));
				
				// Backtrack the change
				oldRow.setCharAt(c1, 'X');
				B[r1] = oldRow.toString();
			}
		}
		return moves;
	}
	
	// check if coordinates are inside the check limits
	private static boolean isValid(String[] B, int r, int c) {
		int row = B.length;
		int col = B[0].length();
		
		return (r >= 0 && r <= row) && (c >=0 && c <= col);
	}
}
