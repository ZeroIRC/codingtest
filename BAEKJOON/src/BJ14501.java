import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ14501 {
    private static int[] inputA;
    private static int[] inputB;
    private static ArrayList<Integer> result = new ArrayList<>();
    private static int N;
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = toInt.apply(stringTokenizer.nextToken());
        inputA = new int[N];
        inputB = new int[N];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            inputA[i] = toInt.apply(stringTokenizer.nextToken());
            inputB[i] = toInt.apply(stringTokenizer.nextToken());
        }
        solve(0, 0);
        Collections.sort(result, Comparator.reverseOrder());
        System.out.println(result.get(0));
    }

    private static void solve(int pos, int total) {
        if (pos > N) {
            return;
        }
        result.add(total);
        for (int i = pos; i < inputA.length; i++) {
            solve(i + inputA[i], total + inputB[i]);
        }
    }
}
