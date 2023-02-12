import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ1806 {
    private static Function<String, Integer> toInt = Integer::parseInt;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = toInt.apply(stringTokenizer.nextToken());
        int S = toInt.apply(stringTokenizer.nextToken());
        array = new int[N + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = toInt.apply(stringTokenizer.nextToken());
        }

        int sum = 0;
        int low = 0;
        int high = 0;
        int answer = Integer.MAX_VALUE;
        while (high <= N) {
            if (sum >= S) {
                sum -= array[low++];
                int length = high - low + 1;
                if (answer > length) {
                    answer = length;
                }
            }
            if (sum < S) {
                sum += array[high++];
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
