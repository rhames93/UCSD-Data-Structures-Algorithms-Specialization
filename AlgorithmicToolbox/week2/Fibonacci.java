import java.util.Scanner;

public class Fibonacci {
  private static long fib[];
  
  private static long calc_fib(int n) {
    if(fib == null) {
      fib = new long[46];
      fib[0] = 0;
      fib[1] = 1;
      for(int i = 2 ; i < fib.length ; ++i) {
        fib[i] = fib[i - 1] + fib[i - 2]; 
      }
    }
    return fib[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(calc_fib(n));
  }
}
