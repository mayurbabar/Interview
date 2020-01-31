// Given two graph points determine in what direction (N, NE, NW, E, W, S, SE, SW) 
// the second point is from the first and display. If points are the same display here.

public class GraphPoints {

	public static void main(String[] args) {
		System.out.println(getRelativeDirection(1,2,3,4)); //NE
		System.out.println(getRelativeDirection(4,2,5,1)); //SE
		System.out.println(getRelativeDirection(0,0,0,1)); //N
		System.out.println(getRelativeDirection(3,2,1,1)); //SW
		System.out.println(getRelativeDirection(0,1,2,1)); //E
		System.out.println(getRelativeDirection(0,0,0,0)); //HERE
	}
	
	public static String getRelativeDirection(int x1, int y1, int x2, int y2) {
		if (x1 == x2 && y1 == y2) 
			return "HERE";
	    else if (x2 < x1) 
	    {
	    	if (y1 == y2) 
	    		return "W";
	    	else if (y2 < y1) 
	    		return "SW";
	    	else 
	    		return "NW";
	    } 
	    else if (x1 < x2) 
	    {
	    	if (y1 == y2) 
	    		return "E";
	    	else if (y2 < y1) 
	    		return "SE";
	    	else 
	    		return "NE";
	    } 
	    else if (x1 == x2) 
	    {
	    	if (y2 < y1) 
	    		return "S";
	    	else if (y1 < y2) 
	    		return "N";
	    }
	    return "ERROR";
	}
}

