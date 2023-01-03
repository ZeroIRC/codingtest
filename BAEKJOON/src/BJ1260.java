import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ1260 {
    private static boolean[] isVisits;
    private static int[][] map;
    private static Function<String, Integer> toInt = Integer::parseInt;
    private static StringBuilder DFSOutputs = new StringBuilder();
    private static StringBuilder BFSOutputs = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = toInt.apply(stringTokenizer.nextToken());
        int m = toInt.apply(stringTokenizer.nextToken());
        int v = toInt.apply(stringTokenizer.nextToken()) - 1;
        map = new int[n][n];
        isVisits = new boolean[n];
        for (int i = 0; i < m; ++i) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = toInt.apply(stringTokenizer.nextToken()) - 1;
            int y = toInt.apply(stringTokenizer.nextToken()) - 1;
            map[x][y] = 1;
            map[y][x] = 1;
        }
        dfs(v, n);
        bfs(v, n);
        System.out.println(DFSOutputs);
        System.out.println(BFSOutputs);
    }

    private static void bfs(int v, int n) {
        isVisits = new boolean[n];
        isVisits[v] = true;
        Queue<Integer> queue = new LinkedList<>();
        BFSOutputs.append(v + 1).append(" ");
        queue.offer(v);
        while (!queue.isEmpty()) {
            int k = queue.poll();
            for (int i = 0; i < n; ++i) {
                if (isVisits[i]) continue;
                if (map[k][i] == 1) {
                    isVisits[i] = true;
                    queue.offer(i);
                    BFSOutputs.append(i + 1).append(" ");
                }
            }
        }
    }

    private static void dfs(int v, int n) {
        isVisits[v] = true;
        DFSOutputs.append(v + 1).append(" ");
        for (int i = 0; i < n; ++i) {
            if (isVisits[i]) continue;
            if (map[v][i] == 1) {
                dfs(i, n);
            }
        }
    }
}
