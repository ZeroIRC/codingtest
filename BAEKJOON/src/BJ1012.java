import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;


public class BJ1012 {
    private static int[][] map;
    private static boolean[][] isVisitedMap;
    private static int count;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static StringBuilder stringBuilder = new StringBuilder();
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int testCase = toInt.apply(stringTokenizer.nextToken());
        for (int i = 0; i < testCase; ++i) {
            count = 0;
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = toInt.apply(stringTokenizer.nextToken());
            int m = toInt.apply(stringTokenizer.nextToken());
            int cabbageCount = toInt.apply(stringTokenizer.nextToken());
            map = new int[n][m];
            for (int j = 0; j < cabbageCount; ++j) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int x = toInt.apply(stringTokenizer.nextToken());
                int y = toInt.apply(stringTokenizer.nextToken());
                map[x][y] = 1;
            }
            isVisitedMap = new boolean[n][m];
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < m; ++k) {
                    if (isVisitedMap[j][k]) {
                        continue;
                    }
                    if (map[j][k] == 1) {
                        dfs(n, m, j, k);
                        count++;
                    }
                }
            }
            stringBuilder.append(count).append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static void dfs(int n, int m, int x, int y) {
        isVisitedMap[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy >= 0 && cx < n && cy < m) {
                if (isVisitedMap[cx][cy]) {
                    continue;
                }
                if (map[cx][cy] == 1) {
                    dfs(n, m, cx, cy);
                }
            }

        }
    }
}
