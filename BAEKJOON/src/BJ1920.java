import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ1920 {
    private static int[] array;
    private static StringBuilder stringBuilder = new StringBuilder();
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
        int M = toInt.apply(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            int target = toInt.apply(stringTokenizer.nextToken());

            if (binarySearch(target)) {
                stringBuilder.append("1").append("\n");
            } else {
                stringBuilder.append("0").append("\n");
            }
        }
        System.out.println(stringBuilder);
    }

    private static boolean binarySearch(int target) {
        int low = 0;
        int high = array.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == array[mid]) {
                return true;
            }
            if (target < array[mid]) {
                high = mid - 1;
            }
            if (target > array[mid]) {
                low = mid + 1;
            }

        }
        return false;
    }


}
