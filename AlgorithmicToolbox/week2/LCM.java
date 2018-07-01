import java.util.*;

public class LCM {
private static int gcd(int a, int b) {
  while(b > 0) {
    int temp = a % b;
    a = b;
    b = temp;
  }
  return a;
}

  private static long lcm_naive(int a, int b) {
    long ans = a / gcd(a,b);
    ans *= b;
    return ans;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}
