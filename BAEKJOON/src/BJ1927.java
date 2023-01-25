import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ1927 {
    private static Function<String,Integer> toInt = Integer::parseInt;
    private static PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparing(x -> x));

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = toInt.apply(stringTokenizer.nextToken());
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int data = toInt.apply(stringTokenizer.nextToken());
            if(data == 0){
                if(queue.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(queue.poll());
                continue;

            }
            queue.offer(data);
        }
    }
}
