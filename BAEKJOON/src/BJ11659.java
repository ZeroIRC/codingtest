import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ11659 {

    private static Function<String, Integer> toInt = Integer::parseInt;
    private static int[] array;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = toInt.apply(stringTokenizer.nextToken());
        int M = toInt.apply(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        array = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            array[i] = array[i - 1] + toInt.apply(stringTokenizer.nextToken());
        }

        for (int k = 0; k < M; k++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = toInt.apply(stringTokenizer.nextToken());
            int j = toInt.apply(stringTokenizer.nextToken());
            stringBuilder.append(array[j] - array[i - 1]).append("\n");
        }

        System.out.println(stringBuilder);
    }

}
