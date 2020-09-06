// https://leetcode.com/discuss/interview-question/546703/

// Time Complexity  - O(N) - Each node in the tree is traversed exactly once.
// Space Complexity - O(N) - Stack space for recursion.

class CountVisibleNodesInBT {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(21);
		root.right.left = new TreeNode(1);
		System.out.println("Root 1: " + solution(root));  // 4
		
		TreeNode root2 = new TreeNode(-10);
		root2.right = new TreeNode(-15);
		root2.right.right = new TreeNode(-1);
		System.out.println("Root 2: " + solution(root2));  // 2
	}
	
	public static int solution(TreeNode root) {
		return helper(root, Integer.MIN_VALUE);
	}
	
    public static int helper(TreeNode root, int maxSoFar) {
    	if(root == null)
    		return 0;
    	
    	int count=0;
    	
    	if(root.val >= maxSoFar) {
    		maxSoFar = root.val;
    		count++;
    	}

    	return count + helper(root.left, maxSoFar) + helper(root.right, maxSoFar);
    }
}
