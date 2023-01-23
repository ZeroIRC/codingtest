import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ9012 {

    private static Function<String, Integer> toInt = Integer::parseInt;

    private static StringBuilder stringBuilder= new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = toInt.apply(stringTokenizer.nextToken());
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String str = stringTokenizer.nextToken();
            String[] strArray = str.split("");
            boolean isCheck = true;
            Queue<String> queue = new LinkedList<>();
            for (String s : strArray) {
                if (s.equals("(")) {
                    queue.offer(s);
                }else{
                    if(queue.isEmpty()){
                        stringBuilder.append("NO").append("\n");
                        isCheck = false;
                        break;
                    }
                    queue.poll();
                }
            }
            if(isCheck){
                if(queue.isEmpty()){
                    stringBuilder.append("YES").append("\n");
                }else{
                    stringBuilder.append("NO").append("\n");
                }
            }
        }
        System.out.println(stringBuilder);
    }
}
