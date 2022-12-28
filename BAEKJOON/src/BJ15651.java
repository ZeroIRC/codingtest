

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15651 {
    private static int[] outputAry;
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        outputAry = new int[m];
        dfs(n, m, 0);
        System.out.println(sb);
    }

    private static void dfs(int n, int m, int count) {
        if (count == m) {
            for(int output : outputAry)
            {
                sb.append(output).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; ++i) {
            outputAry[count] = i + 1;
            dfs(n, m, count + 1);
        }
    }

    private static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
