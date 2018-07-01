import java.util.*;

public class FibonacciSumLastDigit {
    private final static int pisonPeriod = 60;
    private static long getFibonacciSumNaive(long n) {
        n++;
        int fib[] = new int[pisonPeriod];
        fib[0] = 0;
        fib[1] = 1;
        long sum = 1;
        for(int i = 2 ; i < fib.length ; ++i) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % 10;
            sum = (sum + fib[i]) % 10;
        }
        long m = n / pisonPeriod;
        sum = (sum * m) % 10;
        long remainder = n % pisonPeriod;
        for(int i = 0 ; i < remainder ; ++i) {
            sum = (sum + fib[i]) % 10;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

