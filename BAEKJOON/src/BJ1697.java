import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ1697 {

    private static int[] map;
    private static int cx[] = new int[3];
    private static StringBuilder stringBuilder = new StringBuilder();
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = toInt.apply(stringTokenizer.nextToken());
        int k = toInt.apply(stringTokenizer.nextToken());
        map = new int[100001];
        if (n == k) {
            System.out.println(0);
        } else {
            bfs(n, k);
        }
        System.out.println(stringBuilder);

    }

    private static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        map[n] = 1;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            cx[0] = x + 1;
            cx[1] = x - 1;
            cx[2] = x * 2;
            for (int i = 0; i < 3; ++i) {
                if (cx[i] == k) {
                    stringBuilder.append(map[x]);
                    return;
                }
                if (cx[i] >= 0 && cx[i] < map.length && map[cx[i]] == 0) {
                    map[cx[i]] = map[x] + 1;
                    queue.offer(cx[i]);

                }

            }
        }
    }
}
