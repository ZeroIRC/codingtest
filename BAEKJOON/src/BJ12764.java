import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ12764 {

    private static Function<String, Integer> toInt = Integer::parseInt;
    private static PriorityQueue<Time> times = new PriorityQueue<>();
    private static PriorityQueue<Computer> usingCom = new PriorityQueue<>();
    private static PriorityQueue<Integer> nextCom = new PriorityQueue<>();
    private static int[] comSeat = new int[100001];
    private static int count = 0;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = toInt.apply(stringTokenizer.nextToken());
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = toInt.apply(stringTokenizer.nextToken());
            int end = toInt.apply(stringTokenizer.nextToken());
            times.add(new Time(start, end));
        }

        for (int i = 0; i < N; i++) {
            while (!usingCom.isEmpty() && times.peek().start > usingCom.peek().end) {
                nextCom.add(usingCom.poll().index);
            }

            if (nextCom.isEmpty()) {
                usingCom.add(new Computer(times.poll().end, count));
                comSeat[count]++;
                count++;
            } else {
                int com = nextCom.poll();
                usingCom.add(new Computer(times.poll().end, com));
                comSeat[com]++;
            }
        }
        stringBuilder.append(count).append("\n");
        for (int i = 0; i < count; i++) {
            stringBuilder.append(comSeat[i] + " ");
        }
        System.out.println(stringBuilder);

    }

    private static class Computer implements Comparable<Computer> {

        int end;
        int index;

        public Computer(int end, int index) {
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Computer o) {
            return Integer.compare(this.end, o.end);
        }
    }

    private static class Time implements Comparable<Time> {

        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            return Integer.compare(this.start, o.start);
        }
    }
}
