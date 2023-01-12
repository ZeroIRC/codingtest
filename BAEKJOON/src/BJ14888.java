import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.function.Function;

import static javax.swing.text.html.HTML.Attribute.N;

public class BJ14888 {
    private static int[] map = new int[4];
    private static int[] inputs;
    private static int max = -1000000000;
    private static int min = 1000000000;
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = toInt.apply(stringTokenizer.nextToken());
        inputs = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            inputs[i] = toInt.apply(stringTokenizer.nextToken());
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 4; i++) {
            map[i] = toInt.apply(stringTokenizer.nextToken());
        }
        solve(1, 0, 0, 0, 0, inputs[0]);
        System.out.println(max);
        System.out.println(min);

    }

    private static void solve(int pos, int p, int s, int m, int d, int total) {
        if (pos == inputs.length) {
            if (total > max) {
                max = total;
            }
            if (total < min) {
                min = total;
            }
            return;
        }


        if (p < map[0]) {
            solve(pos + 1, p + 1, s, m, d, total + inputs[pos]);
        }
        if (s < map[1]) {
            solve(pos + 1, p, s + 1, m, d, total - inputs[pos]);
        }
        if (m < map[2]) {
            solve(pos + 1, p, s, m + 1, d, total * inputs[pos]);
        }
        if (d < map[3]) {
            solve(pos + 1, p, s, m, d + 1, total / inputs[pos]);
        }
    }
}
