import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ2606 {
    private static int[][] map;
    private static boolean[] isVisits;
    private static int computers;
    private static int count;
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        computers = toInt.apply(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int virus = toInt.apply(stringTokenizer.nextToken());
        map = new int[computers][computers];
        isVisits = new boolean[computers];
        for (int i = 0; i < virus; ++i) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = toInt.apply(stringTokenizer.nextToken()) - 1;
            int m = toInt.apply(stringTokenizer.nextToken()) - 1;
            map[n][m] = 1;
            map[m][n] = 1;
        }
        dfs(0);
        System.out.println(count);

    }

    private static void dfs(int k) {
        for (int i = 0; i < computers; ++i) {
            if (isVisits[i]) {
                continue;
            }
            if (map[k][i] == 1) {
                isVisits[k] = true;
                count++;
                dfs(i);
            }
        }
    }
}
