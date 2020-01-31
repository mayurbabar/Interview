// you are given 3 coins of value 1, 3 and 5. You are also given a total which you have to arrive at. 
// Find the minimum number of coins to arrive at it.

public class Coins {

	public static void main(String[] args) {
		calculateCoins(16);
		calculateCoins(100);
		calculateCoins(39);
		calculateCoins(53);

	}
	
	public static void calculateCoins(int num)
	{
		int numOf5Coins = num / 5;
	    int numOf3Coins = (num - (numOf5Coins * 5)) / 3;
	    int numOf1Coins = (num - (numOf5Coins * 5) - (numOf3Coins * 3)) / 1;
	    
	    System.out.println("Number of $5 coins: " + numOf5Coins);
	    System.out.println("Number of $3 coins: " + numOf3Coins);
	    System.out.println("Number of $1 coins: " + numOf1Coins);
	    System.out.println();
	}

}
