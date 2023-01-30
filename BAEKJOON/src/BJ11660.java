import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ11660 {
    private static int[][] map;
    private static int[][] dp;
    private static StringBuilder stringBuilder = new StringBuilder();

    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = toInt.apply(stringTokenizer.nextToken());
        int M = toInt.apply(stringTokenizer.nextToken());

        map = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = toInt.apply(stringTokenizer.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + map[i][j];
            }
        }
        int x1, y1, x2, y2;
        for (int i = 1; i <= M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            x1 = toInt.apply(stringTokenizer.nextToken());
            y1 = toInt.apply(stringTokenizer.nextToken());
            x2 = toInt.apply(stringTokenizer.nextToken());
            y2 = toInt.apply(stringTokenizer.nextToken());

            stringBuilder.append((dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1]) + "\n");
        }
        System.out.println(stringBuilder);
    }
}
