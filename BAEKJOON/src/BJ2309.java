import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;


public class BJ2309 {
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int[] inputs;
    private static int[] outputs;
    private static boolean[] isVisits;
    private static final int DWARF_COUNT = 9;
    private static final int REAL_DWARF = 7;
    private static final int GOAL = 100;
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        inputs = new int[DWARF_COUNT];
        outputs = new int[REAL_DWARF];
        isVisits = new boolean[DWARF_COUNT];

        for (int i = 0; i < DWARF_COUNT; ++i) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            inputs[i] = toInt.apply(stringTokenizer.nextToken());
        }
        Arrays.sort(inputs);
        dfs(DWARF_COUNT, REAL_DWARF, 0, 0);
        System.out.print(stringBuilder);
    }

    private static void dfs(int n, int m, int index, int count) {
        if (count == m) {
            if (Arrays.stream(outputs).sum() == GOAL) {
                for (int output : outputs) {
                    if (output == outputs[outputs.length - 1]) {
                        stringBuilder.append(output);
                        continue;
                    }
                    stringBuilder.append(output).append("\n");
                }
            }
            return;
        }

        for (int i = index; i < n; ++i) {
            if (isVisits[i]) {
                continue;
            }
            isVisits[i] = true;
            outputs[count] = inputs[i];
            dfs(DWARF_COUNT, REAL_DWARF, i, count + 1);
            isVisits[i] = false;
        }

    }
}
