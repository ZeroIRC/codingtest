import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ3190 {

    private static int[][] moves = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private static int[][] dirs = new int[][]{{1, 2}, {3, 0}, {0, 3}, {2, 1}};
    private static int curDir = 0;
    private static int[][] map;
    private static Queue<int[]> queue = new LinkedList<>();
    private static Queue<int[]> snake = new LinkedList<>();
    private static int N;
    private static int K;
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = toInt.apply(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        K = toInt.apply(stringTokenizer.nextToken());
        map = new int[N][N];
        map[0][0] = 1;
        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int row = toInt.apply(stringTokenizer.nextToken()) - 1;
            int col = toInt.apply(stringTokenizer.nextToken()) - 1;
            map[row][col] = -1;
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int l = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < l; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int sec = Integer.parseInt(stringTokenizer.nextToken());
            String temp = stringTokenizer.nextToken();
            int dir;
            if (temp.equals("D")) {
                dir = 0;
            } else {
                dir = 1;
            }
            queue.add(new int[]{sec, dir});
        }
        snake.add(new int[]{0, 0});

        int r = 0, c = 0;
        int second = 0;
        while (true) {
            second++;
            r += moves[curDir][0];
            c += moves[curDir][1];
            if (r < 0 || c < 0 || r >= N || c >= N || map[r][c] == 1) {
                break;
            }
            snake.add(new int[]{r, c});
            if (map[r][c] != -1) {
                int[] del = snake.poll();
                map[del[0]][del[1]] = 0;
            }
            map[r][c] = 1;
            if (!queue.isEmpty() && queue.peek()[0] == second) {
                int[] temps = queue.poll();
                curDir = dirs[curDir][temps[1]];
            }
        }

        System.out.println(second);
    }
}
