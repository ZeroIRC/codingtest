
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ15649 {

    private static boolean[] visitedAry;
    private static int[] outputAry;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        visitedAry = new boolean[n];
        outputAry = new int[m];
        dfs(n, m, 0);
        System.out.println(sb);
    }

    private static void dfs(int n, int m, int count) {
        if (count == m) {
            for (int output : outputAry) {
                sb.append(output).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; ++i) {
            if (!visitedAry[i]) {
                visitedAry[i] = true;
                outputAry[count] = i + 1;
                dfs(n, m, count + 1);
                visitedAry[i] = false;
            }
        }
    }

    private static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
