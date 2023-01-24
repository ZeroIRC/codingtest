import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class BJ14891 {

    private static int[] isVisits = new int[4];
    private static int[] left = {0, 1, 1, 1};
    private static int[] right = {1, 1, 1, 0};
    private static int[] scoreMap = {1, 2, 4, 8};
    private static int result = 0;
    private static ArrayList<int[]> map = new ArrayList<>();
    private static Function<String, Integer> toInt = Integer::parseInt;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        for (int i = 0; i < 4; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int[] input = new int[8];
            String str = stringTokenizer.nextToken();
            for (int j = 0; j < 8; j++) {
                input[j] = toInt.apply(String.valueOf(str.charAt(j)));
            }
            map.add(input);
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int K = toInt.apply(stringTokenizer.nextToken());

        for (int i = 0; i < K; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int pos = toInt.apply(stringTokenizer.nextToken()) - 1;
            int rotate = toInt.apply(stringTokenizer.nextToken());
            solve(0, rotate, pos, left[pos], right[pos]);
            for (int j = 0; j < 4; j++) {
                gearRotate(j, isVisits[j]);
            }

            isVisits = new int[4];

        }
        cal();
        System.out.println(result);

    }

    private static void solve(int count, int rotate, int pos, int l, int r) {
        isVisits[pos] = rotate;
        if (l == 1 && map.get(pos - 1)[2] != map.get(pos)[6] && pos >= 1 && isVisits[pos - 1] == 0) {
            solve(count + 1, rotate == 1 ? -1 : 1, pos - 1, left[pos - 1], right[pos - 1]);
        }

        if (r == 1 && map.get(pos)[2] != map.get(pos + 1)[6] && pos <= 4 && isVisits[pos + 1] == 0) {
            solve(count + 1, rotate == 1 ? -1 : 1, pos + 1, left[pos + 1], right[pos + 1]);
        }

    }

    private static void cal() {
        for (int i = 0; i < 4; i++) {
            int score = map.get(i)[0];
            result += score * scoreMap[i];
        }
    }

    private static void gearRotate(int pos, int rotate) {
        int temp = 0;
        if (rotate == 1) {
            temp = map.get(pos)[7];
            for (int i = 6; i >= 0; i--) {
                map.get(pos)[i + 1] = map.get(pos)[i];
            }
            map.get(pos)[0] = temp;
        }
        if (rotate == -1) {
            temp = map.get(pos)[0];
            for (int i = 0; i < 7; i++) {
                map.get(pos)[i] = map.get(pos)[i + 1];
            }
            map.get(pos)[7] = temp;
        }

    }


}
