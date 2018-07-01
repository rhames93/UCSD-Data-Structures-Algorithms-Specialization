import java.util.*;

public class FibonacciHuge {
    static List<Integer> primes;
    private static long getFibonacciHugeNaive(long n, long m) {
        if(m == 1) {
            return 0;
        }
        int pisonPeriod = pisonPeriod(m);
        //System.out.println(pisonPeriod);
        long indexLong = n % pisonPeriod;
        int index = (int) indexLong;
        int fib[] = new int[index + 1];
        fib[0] = 0;
        if(fib.length > 1)
            fib[1] = 1;
        for(int i = 2 ; i < fib.length ; ++i) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % (int)m;
        }
        return fib[index];
    }

    private static List<Integer> primes(int n) {
        boolean isPrime[] = new boolean[n + 1];
        List<Integer> prime = new LinkedList<>();
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i <= n ; ++i) {
            if(isPrime[i]) {
                for(int j = 2 * i ; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int i = 2 ; i <= n ; ++i) {
            if(isPrime[i]) {
                prime.add(i);
            }
        }
        return prime;
    }

    private static int lcm(int a, int b) {
        int result = a / gcd(a, b);
        return result * b;
    }
    
    private static int gcd(int a, int b) {
        while( b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private static int pisonPeriod(long m) {
        if (primes == null) {
            primes = primes(1000);
        }
        int pisonPeriod = 1;
        if(m == 1) {
            return pisonPeriod;
        }
        for(int prime : primes) {
            if(m % prime == 0) {
                if( prime == 2) {
                    int power = 0;
                    while( m % 2 == 0) {
                        m /= 2;
                        power++;
                    }
                    pisonPeriod = lcm(pisonPeriod, (int)(3 * Math.round(Math.pow( 2, power - 1))));
                }
                else if(prime == 5) {
                    if( m > 0) {
                        int power = 0;
                        while( m % 5 == 0) {
                            m /= 5;
                            power++;
                        }
                        pisonPeriod = lcm(pisonPeriod, (int)(4 * Math.round(Math.pow( 5, power))));
                    }
                }
                else {
                    int power = 0;
                    while(m % prime == 0) {
                        m /= prime;
                        power++;
                    }
                    int raised = (int) Math.round(Math.pow(prime, power - 1));
                    if(prime % 10 == 1 || prime % 10 == 9) {
                        pisonPeriod = lcm(pisonPeriod , (prime - 1) * raised); 
                    }
                    else {
                        pisonPeriod = lcm(pisonPeriod , raised * 2 * (prime + 1));
                    }
                }
            }
            if(m == 1 || m == 0) {
                return pisonPeriod;
            }
        }
        return pisonPeriod;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        //for(int i = 1; i <= 20; ++i)
            System.out.print(getFibonacciHugeNaive(n, m) + " ");
    }
}

