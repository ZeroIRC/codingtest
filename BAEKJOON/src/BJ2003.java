import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ2003 {
    private static int[] array;
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = toInt.apply(stringTokenizer.nextToken());
        int M = toInt.apply(stringTokenizer.nextToken());
        array = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = toInt.apply(stringTokenizer.nextToken());
        }
        int low = 0;
        int count = 0;
        int sum = 0;
        int high = 0;
        while(true){
            if(sum>=M){
                sum-=array[low++];
            }
            else if(high==N){
                break;
            }else{
                sum+=array[high++];
            }

            if(sum==M){
                count++;
            }
        }

        System.out.println(count);
    }
}
