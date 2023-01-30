import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ2512 {
    private static int[] array;
    private static int N;
    private static int result = 0;
    private static int max = 0;
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = toInt.apply(stringTokenizer.nextToken());
        array = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = toInt.apply(stringTokenizer.nextToken());
            max = Math.max(array[i], max);
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int M = toInt.apply(stringTokenizer.nextToken());
        int low = 0;
        int high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = 0;
            for (int i : array) {
                if (i > mid) {
                    sum += mid;
                } else {
                    sum += i;
                }
            }
            if (sum > M) {
                high = mid - 1;
            } else {
                low = mid + 1;
                result = Math.max(mid, result);
            }
        }
        System.out.println(result);

    }


}
