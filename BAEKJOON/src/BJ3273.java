import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ3273 {
    private static int[] array;
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = toInt.apply(stringTokenizer.nextToken());
        array = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = toInt.apply(stringTokenizer.nextToken());
        }
        Arrays.sort(array);
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int X = toInt.apply(stringTokenizer.nextToken());
        int low = 0;
        int high = N - 1;
        int count = 0;
        while (low < high) {
            int sum = array[low] + array[high];
            if (sum == X) {
                count++;
                high--;
            }
            if (sum > X) {
                high--;
            }
            if (sum < X) {
                low++;
            }
        }
        System.out.println(count);

    }
}
