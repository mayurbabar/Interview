
public class PointDistance {

	public static void main(String[] args) {
		                         //x1,y1,x2,y2
		System.out.println(distance(3,4,4,3));  // 1.41421
		System.out.println(distance(3,4,7,7));  // 5

	}
	
	public static double distance(int x1, int y1, int x2, int y2)
	{
		double result = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); 
        return Math.round(result*100000.0)/100000.0;
	}
}
