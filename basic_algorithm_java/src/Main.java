import java.awt.desktop.SystemSleepEvent;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        int[] A = new int[N-1];
        int[] B = new int[N-2];
        for (int i = 0; i < N-1; i++) A[i] = Integer.parseInt(sc.next());
        for (int i = 0; i < N-2; i++) B[i] = Integer.parseInt(sc.next());

        int[] dp = new int[N+1];

        for (int i = 0; i< N-2; i++){
            dp[i+1] = Math.max(dp[i+1], dp[i] + A[i]);
            dp[i+2] = Math.max(dp[i+2], dp[i] + B[i]);
        }
        dp[N] = Math.max(dp[N], dp[N-1] + A[N-2]);
        System.out.println(dp[N]);



    }

    // 右側二分探索
    public static int bisectRight(List<Integer> sortedList, int a) {
        int left = 0;
        int right = sortedList.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (sortedList.get(mid) > a) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    // 左側二分探索
    public static int bisectLeft(List<Integer> sortedList, int a) {
        int left = 0;
        int right = sortedList.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (sortedList.get(mid) >= a) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    // 桁数の取得
    public static int digits(long n) {
        return String.valueOf(n).length();
    }

    // 最小公倍数の取得
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // 最大公約数の取得
    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    // n!の取得
    public static long factorial(long n) {
        return n <= 0 ? 1 : n * factorial(n - 1);
    }

    // 素数判定
    static boolean isPrime(int N) {
        if (N <= 1)
            return false;
        else if (N == 2)
            return true;
        for (int i = 2; i <= Math.sqrt(N); i++)
            if (N % i == 0)
                return false;
        return true;
    }
}