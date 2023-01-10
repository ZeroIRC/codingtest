import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ1182 {

    private static Function<String, Integer> toInt = Integer::parseInt;
    private static int[] numbers;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = toInt.apply(stringTokenizer.nextToken());
        int s = toInt.apply(stringTokenizer.nextToken());
        numbers = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; ++i) {
            numbers[i] = toInt.apply(stringTokenizer.nextToken());
        }

        solve(0, 0, n, s);
        if (s == 0) {
            System.out.println(count - 1);
        } else {
            System.out.println(count);
        }

    }

    static void solve(int pos, int sum, int n, int s) {
        if (pos == n) {
            if (sum == s) {
                count++;
            }
            return;
        }
        solve(pos + 1, sum + numbers[pos], n, s);
        solve(pos + 1, sum, n, s);

    }
}
