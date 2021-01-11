package omar.problems.recursion;

import java.util.Scanner;

public class FibonacciNumbers {
    public static int fibonacci(int n) {
        Integer[] dp = new Integer[31];
        dp[0]=0;
        dp[1]=1;
        return fib(n, dp);
    }

    public static int fib(int n, Integer[] dp){

        if(dp[n]==null){

            dp[n] = fib(n-1,dp) + fib(n-2,dp);
        }

        return dp[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
