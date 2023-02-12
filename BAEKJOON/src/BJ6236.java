import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ6236 {
    private static int[] array;
    private static int low = 0;
    private static int result = 0;
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = toInt.apply(stringTokenizer.nextToken());
        int M = toInt.apply(stringTokenizer.nextToken());
        array = new int[N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            array[i] = toInt.apply(stringTokenizer.nextToken());
            low = Math.max(low, array[i]);
        }
        int high = 10000 * 100000;;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (M >= getCount(mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(result);


    }

    private static int getCount(int withdrawal) {
        int count = 1;
        int money = withdrawal;
        for (int i : array) {
            money -= i;
            if (money < 0) {
                count++;
                money = withdrawal - i;
            }
        }
        return count;
    }
}
