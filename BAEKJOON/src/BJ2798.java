import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ2798 {
    private static int[] inputs;
    private static int[] outputs;
    private static int result;
    private static boolean[] isVisits;
    private static Function<String, Integer> toInt = Integer::parseInt;
    private static final int CARD_PICK_COUNT = 3;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = toInt.apply(stringTokenizer.nextToken());
        int goal = toInt.apply(stringTokenizer.nextToken());
        inputs = new int[n];
        isVisits = new boolean[n];
        outputs = new int[CARD_PICK_COUNT];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; ++i) {
            inputs[i] = toInt.apply(stringTokenizer.nextToken());
        }
        dfs(n, CARD_PICK_COUNT, 0, 0, goal);
        System.out.println(result);
    }

    private static void dfs(int n, int m, int index, int count, int goal) {
        if (count == m) {
            if (Arrays.stream(outputs).sum() <= goal && Arrays.stream(outputs).sum() > result) {
                result = Arrays.stream(outputs).sum();
            }
            return;
        }

        for (int i = index; i < n; ++i) {
            if (isVisits[i]) {
                continue;
            }
            isVisits[i] = true;
            outputs[count] = inputs[i];
            dfs(n, m, i, count + 1, goal);
            isVisits[i] = false;
        }
    }
}
