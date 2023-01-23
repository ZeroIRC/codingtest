import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ2164 {

    private static Queue<Integer> queue = new LinkedList<>();
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = toInt.apply(stringTokenizer.nextToken());
        for (int i = 1; i < N + 1; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1){
            queue.poll();
            queue.offer(queue.poll());
        }
        System.out.println(queue.poll());

    }
}
