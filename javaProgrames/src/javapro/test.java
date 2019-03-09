package javapro;

import java.util.Scanner;

public class test {
	 // A utility method that returns true if x is perfect square 
	    static  boolean isPerfectSquare(int x) 
	    { 
	        int s = (int) Math.sqrt(x); 
	        return (s*s == x); 
	    } 
	       
	    // Returns true if n is a Fibonacci Number, else false 
	    static boolean isFibonacci(int n) 
	    { 
	        // n is Fibonacci if one of 5*n*n + 4 or 5*n*n - 4 or both 
	        // is a perfect square 
	        return isPerfectSquare(5*n*n + 4) || 
	               isPerfectSquare(5*n*n - 4); 
	    } 
	  
	    static boolean isPrime(int n)
	    {
	    	int temp;
	    	boolean isPrime=true;
	    	Scanner scan= new Scanner(System.in);
	    	//System.out.println("Enter any number:");
	    	//capture the input in an integer
	    	//int num=scan.nextInt();
	          //  scan.close();
	    	for(int i=2;i<=n/2;i++)
	    	{
	               temp=n%i;
	    	   if(temp==0)
	    	   {
	    	      isPrime=false;
	    	      break;
	    	   }
	    	  // return isPrime;
	    	}
	    	
	    	
	    	return isPrime;
	    	
	    }
	    // Driver method  
	    public static void main(String[] args) 
	    { 
	    	System.out.println("please enter the range");
	    	Scanner sc=new Scanner(System.in);
	    	int num=sc.nextInt();
	    	boolean b=isFibonacci(num);
	    	boolean isPrime=isPrime(num);
	    	
	    	
	    	//If isPrime is true then the number is prime else not
	    	if(isPrime && b) {
	    /*	   System.out.println(num + " is a Prime Number");
	    	System.out.println("Given number is fibonic");  */
	    	System.out.println("0");
	    	}
	    	else {
	    	/*   System.out.println(num + " is not a Prime Number");
	    	System.out.println("Given number is not fibonic");   */
	    	System.out.println("1");
	    	
	    	
	    		    }
	} 
}