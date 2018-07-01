import java.util.*;

public class FibonacciLastDigit {
    static int arr[];
    private static int getFibonacciLastDigitNaive(int n) {
        if(arr == null) {
            arr = new int[10000001];
            arr[0] = 0;
            arr[1] = 1;
            for(int i = 2 ; i < arr.length ; ++i) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 10;
            }
        }
        return arr[n];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}

