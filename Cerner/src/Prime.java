
public class Prime {

	public static void main(String[] args) {
		System.out.println(isPrime(2));
		System.out.println(isPrime(3));
		System.out.println(isPrime(7));
		System.out.println(isPrime(21));
		System.out.println(isPrime(212));
	}
	
	public static boolean isPrime(int num)
	{
		if(num == 0 || num == 1)
		{
			return false;
		}
		else
		{
			for (int i = 2; i < num/2; i++) 
			{
				if(num % i == 0)
					return false;
			}
		}
		return true;
	}

}
