import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ15652 {

    private static StringBuilder sb = new StringBuilder();
    private static int[] outputs;
    private static Function<String, Integer> toInt = Integer::parseInt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = toInt.apply(st.nextToken());
        int m = toInt.apply(st.nextToken());
        outputs = new int[m];
        dfs(n, m, 0, 0);
        System.out.println(sb);
    }

    private static void dfs(int n, int m, int index, int count) {
        if (count == m) {
            for (int output : outputs) {
                sb.append(output).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i < n; ++i) {
            outputs[count] = i + 1;
            dfs(n, m, i, count + 1);
        }
    }

}
