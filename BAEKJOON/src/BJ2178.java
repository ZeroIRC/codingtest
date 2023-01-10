import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ2178 {

    private static int[][] map;
    private static int[] dx = {0, 1, -1, 0};
    private static int[] dy = {1, 0, 0, -1};

    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = toInt.apply(stringTokenizer.nextToken());
        int m = toInt.apply(stringTokenizer.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; ++i) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String input = stringTokenizer.nextToken();
            for (int j = 0; j < m; ++j) {
                map[i][j] = toInt.apply(String.valueOf(input.charAt(j)));
            }
        }
        bfs(0, 0, n, m);
        System.out.println(map[n - 1][m - 1]);
    }

    private static void bfs(int x, int y, int n, int m) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int cx = point.x + dx[i];
                int cy = point.y + dy[i];
                if (cx < n && cx >= 0 && cy < m && cy >= 0) {
                    if (map[cx][cy] == 1) {
                        map[cx][cy] = map[point.x][point.y] + 1;
                        queue.offer(new Point(cx, cy));
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
