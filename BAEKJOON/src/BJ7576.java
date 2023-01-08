import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ7576 {

    private static int[][] map;
    private static int day;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    private static Queue<Tomato> queue = new LinkedList<>();
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = toInt.apply(stringTokenizer.nextToken());
        int m = toInt.apply(stringTokenizer.nextToken());

        map = new int[m][n];
        for (int i = 0; i < m; ++i) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; ++j) {
                map[i][j] = toInt.apply(stringTokenizer.nextToken());
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (map[i][j] == 1) {
                    queue.offer(new Tomato(i, j));
                }
            }
        }
        bfs(m, n);
        System.out.println(day);
    }

    private static void bfs(int m, int n) {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            for (int i = 0; i < 4; ++i) {
                int cx = tomato.x + dx[i];
                int cy = tomato.y + dy[i];
                if (cx < m && cx >= 0 && cy < n && cy >= 0) {
                    if (map[cx][cy] == 0) {
                        map[cx][cy] = map[tomato.x][tomato.y] + 1;
                        queue.offer(new Tomato(cx, cy));
                    }
                }
            }
        }
        for (int i = 0; i < m; ++i) {
            if (day == -1) {
                break;
            }
            for (int j = 0; j < n; ++j) {
                if (day < map[i][j]) {
                    day = map[i][j] - 1;
                }
                if (map[i][j] == 0) {
                    day = -1;
                    break;
                }
            }
        }

        if (day == 1) {
            day = 0;
        }


    }

    private static class Tomato {
        int x;
        int y;

        public Tomato(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
