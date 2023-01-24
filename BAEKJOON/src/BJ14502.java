import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ14502 {

    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};
    private static int[][] map;
    private static int N;
    private static int M;
    private static int result;
    private static boolean[][] isVisits;
    private static Queue<Point> queue = new LinkedList<>();
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = toInt.apply(stringTokenizer.nextToken());
        M = toInt.apply(stringTokenizer.nextToken());
        map = new int[N][M];


        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = toInt.apply(stringTokenizer.nextToken());
            }
        }

        dfs(0);
        System.out.println(result);

    }

    private static void bfs() {
        isVisits = new boolean[N][M];
        int[][] backUpMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                backUpMap[i][j] = map[i][j];
                if (isVisits[i][j]) continue;
                if (backUpMap[i][j] == 2) {
                    isVisits[i][j] = true;
                    queue.offer(new Point(i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int cy = point.y + dy[i];
                int cx = point.x + dx[i];
                if (cy >= 0 && cy < N && cx >= 0 && cx < M) {
                    if (isVisits[cy][cx]) continue;
                    if (backUpMap[cy][cx] == 0) {
                        backUpMap[cy][cx] = 2;
                        queue.offer(new Point(cy, cx));
                        isVisits[cy][cx] = true;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (backUpMap[i][j] == 0) {
                    count++;
                }
            }
        }
        if (count > result) {
            result = count;
        }
    }

    private static void dfs(int count) {
        if (count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static class Point {
        int x;
        int y;

        public Point(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
