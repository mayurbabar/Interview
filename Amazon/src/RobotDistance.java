import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RobotDistance {
	public static void main(final String args[])
	{
		final List<List<Integer>> lot = new ArrayList<List<Integer>>();

		lot.add(Arrays.asList(1,0,0));
		lot.add(Arrays.asList(1,0,0));
		lot.add(Arrays.asList(1,9,0));

		System.out.println("Given Area: " + lot);

		System.out.print("Minimum distance: " + shortestDistance(3, 3, lot));   //3
	}
	
	private static class QNode
	{
		int x;
		int y;
		int distance;
		QNode(final int x,final int y, final int distance)
		{
			this.x=x;
			this.y=y;
			this.distance=distance;
		}
	}
	
	static int shortestDistance(final int numRows, final int numColumns, final List<List<Integer>> lot)
	{
		final int[][] matrix = new int[numRows][numColumns];
		if(matrix.length == 0)
		{
			return 0;
		}
		
		for(int i=0;i<numRows;i++)
		{
			for(int j =0;j<numColumns;j++)
			{
				matrix[i][j] = lot.get(i).get(j);
			}
		}
		
		final int[] rowNeighbours = {0,0,1,-1};
		final int[] colNeighbours = {1,-1,0,0};
		
		final boolean[][] visited = new boolean[numRows][numColumns];
		visited[0][0] = true;
		
			
		final Queue<QNode> qNodes = new LinkedList<>();
		qNodes.add(new QNode(0,0,0));
		
		while(!qNodes.isEmpty())
		{
			final QNode current = qNodes.poll(); 
			if(matrix[current.x][current.y] == 9) 
				return current.distance;
			
			for(int i=0; i<4; i++)
			{
				final int rowPt = current.x + rowNeighbours[i];
				final int colPt = current.y + colNeighbours[i];
				
				if(isValidPoint(matrix, rowPt,colPt) && !visited[rowPt][colPt])
				{
					visited[rowPt][colPt] = true;
					final QNode adjCell = new QNode(rowPt, colPt, current.distance+1);
					qNodes.add(adjCell);
				}
			}
		}
		return -1;
	}
	
	public static boolean isValidPoint(final int[][] matrix,final int x,final int y)
	{
		if(x<0 || x >= matrix.length) return false;
		if(y<0 || y>= matrix[0].length) return false;
		if(matrix[x][y] == 0) return false;
		return true;
	}
}