import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ14889 {
    private static int[][] map;
    private static boolean[] isVisits;
    private static int N;
    private static int result = 1000000000;
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = toInt.apply(stringTokenizer.nextToken());
        map = new int[N][N];
        isVisits = new boolean[N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = toInt.apply(stringTokenizer.nextToken());
            }
        }
        solve(0, 0);
        System.out.println(result);

    }

    private static void solve(int pos, int count) {
        if (count == N / 2) {
            int start = 0;
            int link = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (isVisits[i] && isVisits[j]) {
                        start += map[i][j];
                        start += map[j][i];
                    }
                    if (!isVisits[i] && !isVisits[j]) {
                        link += map[i][j];
                        link += map[j][i];
                    }
                }

            }
            int temp = Math.abs(start - link);
            if (result > temp) {
                result = temp;
            }
            return;
        }
        for (int i = pos; i < N; i++) {
            if (isVisits[i]) continue;
            isVisits[i] = true;
            solve(i + 1, count + 1);
            isVisits[i] = false;
        }
    }
}
