import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ11724 {

    private static Function<String, Integer> toInt = Integer::parseInt;
    private static int[][] map;
    private static int count = 0;
    private static boolean[] isVisits;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = toInt.apply(stringTokenizer.nextToken());
        int m = toInt.apply(stringTokenizer.nextToken());
        map = new int[n][n];
        isVisits = new boolean[n];
        for (int i = 0; i < m; ++i) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u = toInt.apply(stringTokenizer.nextToken()) - 1;
            int v = toInt.apply(stringTokenizer.nextToken()) - 1;
            map[u][v] = 1;
            map[v][u] = 1;
        }
        for (int i = 0; i < n; ++i) {
            if (isVisits[i]) {
                continue;
            }
            dfs(n, i);
            count++;
        }
        System.out.println(count);

    }

    private static void dfs(int n, int k) {
        for (int i = 0; i < n; ++i) {
            if (isVisits[i]) {
                continue;
            }
            if (map[k][i] == 1) {
                isVisits[i] = true;
                dfs(n, i);
            }

        }
    }
}