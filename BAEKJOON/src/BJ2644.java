import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ2644 {
    private static int[][] map;
    private static int[] visitMap;
    private static int result;
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = toInt.apply(stringTokenizer.nextToken());
        map = new int[n][n];
        visitMap = new int[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int goalA = toInt.apply(stringTokenizer.nextToken()) - 1;
        int goalB = toInt.apply(stringTokenizer.nextToken()) - 1;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int k = toInt.apply(stringTokenizer.nextToken());
        for (int i = 0; i < k; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = toInt.apply(stringTokenizer.nextToken()) - 1;
            int y = toInt.apply(stringTokenizer.nextToken()) - 1;
            map[x][y] = 1;
            map[y][x] = 1;
        }
        bfs(goalA);
        if (visitMap[goalB] == 0) {
            result = -1;
        } else {
            result = visitMap[goalB];
        }
        System.out.println(result);


    }

    private static void bfs(int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        visitMap[k] = 0;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (int i = 0; i < map.length; i++) {
                if (map[index][i] == 0) continue;
                if (visitMap[i] == 0) {
                    visitMap[i] = visitMap[index] + 1;
                    queue.offer(i);
                }
            }
        }
    }
}
