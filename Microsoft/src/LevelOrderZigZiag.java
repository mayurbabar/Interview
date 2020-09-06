import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderZigZiag {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(9);
		root1.left.left = new TreeNode(17);
		root1.left.left.left = new TreeNode(8);
		root1.left.left.right = new TreeNode(21);
		root1.right = new TreeNode(20);
		root1.right.left = new TreeNode(15);
		root1.right.right = new TreeNode(7);
		
//		zigzagLevelOrder(root1);  // Wrong Answer
//		zigzagLevelOrder2(root1); // Using Queue BFS
		zigzagLevelOrder3(root1); // Using 2 stacks
		// 3
		// 20 9
		// 17 15 7
		// 21 8

	}
	
	public static void zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return;
        
        Deque<TreeNode> q = new LinkedList<>();
        int level =1;
        
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                
                System.out.print(node.val + " ");
                
                if(level%2 == 0){
                	if(node.left != null)
                        q.offer(node.left);
                    if(node.right != null)
                        q.offer(node.right);
                }
                else{
                	if(node.right != null)
                        q.offer(node.right);
                	if(node.left != null)
                        q.offer(node.left);
                }
            }
            System.out.println();
            level++;
        }
    }
	
	public static void zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root == null)
            return;
        
        Deque<TreeNode> q = new LinkedList<>();
        int level =0;
        
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> levelList = new ArrayList<>();
            
            level++;
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                
                if(level%2 == 0)
                    levelList.add(0,node.val);
                else
                    levelList.add(node.val);
                
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
            result.add(levelList);
        }
        
        for(List<Integer> row: result) {
        	for(int val: row) {
        		System.out.print(val + " ");
        	}
        	System.out.println();
        }
    }
	
	public static void zigzagLevelOrder3(TreeNode root) {
        if(root == null)
            return;
        
        Deque<TreeNode> evenStack = new LinkedList<>();
        Deque<TreeNode> oddStack = new LinkedList<>();
        
        oddStack.push(root);
        while(!evenStack.isEmpty() || !oddStack.isEmpty()) {
        	while(!oddStack.isEmpty()){
        		TreeNode node = oddStack.pop();
        		if(node == null)
        			continue;
        		
        		System.out.print(node.val + " ");
        		
        		evenStack.push(node.left);
        		evenStack.push(node.right);
            }
        	System.out.println();
        	
        	while(!evenStack.isEmpty()){
        		TreeNode node = evenStack.pop();
        		if(node == null)
        			continue;
        		
        		System.out.print(node.val + " ");
        		
        		oddStack.push(node.right);
        		oddStack.push(node.left);
            }
        	System.out.println();
        }
    }

}
