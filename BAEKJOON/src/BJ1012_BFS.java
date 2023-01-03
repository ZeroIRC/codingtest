import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ1012_BFS {

    private static int[][] map;
    private static boolean[][] isVisitMap;
    private static int count;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static Function<String, Integer> toInt = Integer::parseInt;
    private static StringBuilder stringBuilder = new StringBuilder();

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
            isVisitMap = new boolean[n][m];
            for (int j = 0; j < cabbageCount; ++j) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int x = toInt.apply(stringTokenizer.nextToken());
                int y = toInt.apply(stringTokenizer.nextToken());
                map[x][y] = 1;
            }
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < m; ++k) {
                    if (isVisitMap[j][k]) continue;
                    if (map[j][k] == 1) {
                        bfs(j, k, n, m);
                        count++;
                    }
                }
            }
            stringBuilder.append(count).append("\n");

        }
        System.out.println(stringBuilder);

    }

    private static void bfs(int x, int y, int n, int m) {
        isVisitMap[x][y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int cx = point.x + dx[i];
                int cy = point.y + dy[i];
                if (cx >= 0 && cy >= 0 && cx < n && cy < m) {
                    if (isVisitMap[cx][cy]) {
                        continue;
                    }
                    if (map[cx][cy] == 1) {
                        queue.offer(new Point(cx, cy));
                        isVisitMap[cx][cy] = true;
                    }
                }
            }
        }


    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
