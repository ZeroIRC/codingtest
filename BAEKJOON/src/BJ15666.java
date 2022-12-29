import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ15666 {

    private static int[] inputs;
    private static int[] outputs;
    private static LinkedHashSet<String> outputSet = new LinkedHashSet<>();
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = toInt.apply(st.nextToken());
        int m = toInt.apply(st.nextToken());
        inputs = new int[n];
        outputs = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            inputs[i] = toInt.apply(st.nextToken());
        }
        Arrays.sort(inputs);
        dfs(n, m, 0, 0);
        for (String output : outputSet) {
            System.out.println(output);
        }

    }

    private static void dfs(int n, int m, int index, int count) {
        if (count == m) {
            StringBuilder sb = new StringBuilder();
            for (int output : outputs) {
                sb.append(output).append(" ");
            }
            outputSet.add(sb.toString());
            return;
        }

        for (int i = index; i < n; ++i) {
            outputs[count] = inputs[i];
            dfs(n, m, i, count + 1);
        }
    }
}
