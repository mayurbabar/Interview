// Given an initial number, reverse it and add it back to the initial. Check if new number is a palindrome. 
// If not repeat till is. If yes display how many iterations it took and the number.  

public class Palindrome {
	public static void main(String[] args) {
		System.out.println("Number of Iterations: " + ReverseandAdd(1951));
		System.out.println("Number of Iterations: " + ReverseandAdd(2651));
		System.out.println("Number of Iterations: " + ReverseandAdd(265));
		System.out.println("Number of Iterations: " + ReverseandAdd(7325));
	}
	
	public static long reversDigits(long num)
    {
        long rev_num = 0;
        while (num > 0)
        {
            rev_num = rev_num*10 + num%10;
            num = num/10;
        }
        return rev_num;
    }
 
    /* Function to check whether he number is
           palindrome or not */
    public static boolean isPalindrome(long num)
    {
        return (reversDigits(num) == num);
    }
 
    /* Reverse and Add Function */
    public static int ReverseandAdd(long num)
    {
        long rev_num = 0;
        int iterations = 0;
        while (num <= 4294967295l)
        {
            // Reversing the digits of the number
            rev_num = reversDigits(num);
 
            // Adding the reversed number with the original
            num = num + rev_num;
            iterations++;
            
            // Checking whether the number is palindrome or not
            if(isPalindrome(num))
            {
                System.out.println(num);
                return iterations;
            }
            else if (num > 4294967295l)
            {
                System.out.println("No palindrome exist");
                return -1;
            }
        }
        System.out.println("No palindrome exist");
        return -1;
    }

}
