import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ2667 {

    private static int[][] map;
    private static boolean[][] isVisitedMap;
    private static int count = 0;
    private static int home = 0;
    private static ArrayList<Integer> homeList = new ArrayList<>();
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = toInt.apply(stringTokenizer.nextToken());

        map = new int[N][N];
        isVisitedMap = new boolean[N][N];

        for (int i = 0; i < N; ++i) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String str = stringTokenizer.nextToken();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = toInt.apply(String.valueOf(str.charAt(j)));
            }
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (isVisitedMap[i][j]) {
                    continue;
                }
                if (map[i][j] == 1) {
                    home = 1;
                    dfs(N, i, j);
                    homeList.add(home);
                    count++;
                }

            }
        }
        Collections.sort(homeList);
        System.out.println(count);
        for (int home : homeList) {
            System.out.println(home);
        }
    }

    private static void dfs(int N, int x, int y) {
        isVisitedMap[x][y] = true;
        for (int i = 0; i < 4; ++i) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            if (cx >= 0 && cx < N && cy >= 0 && cy < N) {
                if (isVisitedMap[cx][cy]) {
                    continue;
                }
                if (map[cx][cy] == 1) {
                    dfs(N, cx, cy);
                    home++;
                }
            }
        }
    }
}
