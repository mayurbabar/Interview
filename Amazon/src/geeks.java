// Java program to find Minimum steps 
// to reach any of the boundary 
// edges of a matrix 
class geeks 
{ 
static final int r=4,c=5; 

// Function to find out minimum steps 
static int findMinSteps(final int mat[][], final int n, final int m, final int dp[][], final boolean vis[][]) 
{ 
	// boundary edges reached 
	if (n == 0 || m == 0 || n == (r - 1) || m == (c - 1)) { 
		return 0; 
	} 

	// already had a route through this 
	// point, hence no need to re-visit 
	if (dp[n][m] != -1) 
		return dp[n][m]; 

	// visiting a position 
	vis[n][m] = true; 

	int ans1, ans2, ans3, ans4; 

	ans1 = ans2 = ans3 = ans4 = (int)1e9; 

	// vertically up 
	if (mat[n - 1][m] == 0) { 
		if (!vis[n - 1][m]) 
			ans1 = 1 + findMinSteps(mat, n - 1, m, dp, vis); 
	} 

	// horizontally right 
	if (mat[n][m + 1] == 0) { 
		if (!vis[n][m + 1]) 
			ans2 = 1 + findMinSteps(mat, n, m + 1, dp, vis); 
	} 

	// horizontally left 
	if (mat[n][m - 1] == 0) { 
		if (!vis[n][m - 1]) 
			ans3 = 1 + findMinSteps(mat, n, m - 1, dp, vis); 
	} 

	// vertically down 
	if (mat[n + 1][m] == 0) { 
		if (!vis[n + 1][m]) 
			ans4 = 1 + findMinSteps(mat, n + 1, m, dp, vis); 
	} 

	// minimum of every path 
	dp[n][m] = Math.min(ans1, Math.min(ans2, Math.min(ans3, ans4))); 
	return dp[n][m]; 
} 

// Function that returns the minimum steps 
static int minimumSteps(final int mat[][], final int n, final int m) 
{ 
	// index to store the location at 
	// which you are standing 
	int twox = -1; 
	int twoy = -1; 

	// find '2' in the matrix 
	for (int i = 0; i < n; i++) { 
		for (int j = 0; j < m; j++) { 
			if (mat[i][j] == 2) { 
				twox = i; 
				twoy = j; 
				break; 
			} 
		} 
		if (twox != -1) 
			break; 
	} 

	// Initialize dp matrix with -1 
	final int dp[][]=new int[r][r]; 
	for(int j=0;j<r;j++){
		System.out.println();
		for(int i=0;i<r;i++){
			dp[j][i]=-1; 
			System.out.print(dp[j][i]);
		}
	}

	// Initialize vis matrix with false 
	final boolean vis[][]= new boolean[r][r]; 
	for(int j=0;j<r;j++) 
	for(int i=0;i<r;i++)vis[j][i]=false; 

	// Call function to find out minimum steps 
	// using memoization and recursion 
	final int res = findMinSteps(mat, twox, twoy, dp, vis); 

	// if not possible 
	if (res >= 1e9) 
		return -1; 
	else
		return res; 
} 

// Driver Code 
public static void main(final String args[]) 
{ 
	final int mat[][] = { { 1, 1, 1, 0, 1 }, 
						  { 1, 0, 2, 0, 1 }, 
						  { 0, 0, 1, 0, 1 }, 
						  { 1, 0, 1, 1, 0 } }; 

	System.out.println("Answer is: ");
	System.out.println( minimumSteps(mat, r, c)); 
} 
} 
//contributed by Arnab Kundu 
