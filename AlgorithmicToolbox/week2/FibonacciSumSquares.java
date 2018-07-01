import java.util.*;

public class FibonacciSumSquares {

    private final static int[][] F = { {1, 1}, {1, 0}};
    private final static int c = 10;

    private static int[][] modPow(int a[][], long n) {

        int result[][] = new int[a.length][a[0].length];
        Arrays.fill(result[0], 1);
        Arrays.fill(result[1], 1);
        result[1][1] = 0;
        int A[][] = new int[a.length][a[0].length];
        A[0][0] = a[0][0];
        A[0][1] = a[0][1];
        A[1][0] = a[1][0];
        A[1][1] = a[1][1];
        while (n > 0) {
            while ((n & 1) == 0) {
                square(A);
                n /= 2;
            }
            multiply(result, A);
            n--;
        }
        return result;
    }

    private static void multiply(int a[][], int b[][]) {
        int w = a[0][0] * b[0][0] + a[0][1] * b[1][0];
        w %= c;
        int x = a[0][0] * b[0][1] + a[0][1] * b[1][1];
        x %= c;
        int y = a[1][0] * b[0][0] + a[1][1] * b[1][0];
        y %= c;
        int z = a[1][0] * b[0][1] + a[1][1] * b[1][1];
        z %= c;
        a[0][0] = w;
        a[0][1] = x;
        a[1][0] = y;
        a[1][1] = z;
        // System.out.println(a[0][0] + " " + a[0][1]);
        // System.out.println(a[1][0] + " " + a[1][1]);
        // System.out.println();
    }

    private static void square(int a[][]) {
        multiply(a, a);
    }

    private static int getLargeFibonacciNumber(long n) {
        if(n == 1) {
            return 1;
        }
        else if (n == 0) {
            return 0;
        }
        else {
            return modPow(F, n - 2)[0][0];
        }
    }

    private static long getFibonacciSumSquaresNaive(long n) {
        int num1 = getLargeFibonacciNumber(n - 1);
        int num2 = getLargeFibonacciNumber(n);
        return (num2 * (num2 + num1)) % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresNaive(n);
        System.out.println(s);
    }
}

