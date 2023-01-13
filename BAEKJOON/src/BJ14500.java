import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ14500 {
    private static int[][] map;
    private static boolean[][] isVisits;
    private static int N;
    private static int M;
    private static int result;
    private static int[] dx = {0, -1, 0, 1};
    private static int[] dy = {-1, 0, 1, 0};
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = toInt.apply(stringTokenizer.nextToken());
        M = toInt.apply(stringTokenizer.nextToken());
        map = new int[N][M];
        isVisits = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = toInt.apply(stringTokenizer.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isVisits[i][j]) continue;
                isVisits[i][j] = true;
                solve(0, i, j, 0);
                isVisits[i][j] = false;
            }
        }
        System.out.println(result);


    }

    private static void solve(int count, int y, int x, int total) {
        if (count == 4) {
            if (result < total) {
                result = total;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int cx = dx[i] + x;
            int cy = dy[i] + y;
            if (cx >= 0 && cy >= 0 && cx < M && cy < N) {
                if (isVisits[cy][cx]) continue;
                if (count == 2) {
                    isVisits[cy][cx] = true;
                    solve(count + 1, y, x, total + map[cy][cx]);
                    isVisits[cy][cx] = false;
                }
                isVisits[cy][cx] = true;
                solve(count + 1, cy, cx, total + map[cy][cx]);
                isVisits[cy][cx] = false;
            }
        }
    }

}
