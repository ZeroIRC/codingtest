

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BJ15665 {

    private static String[] inputs;
    private static String[] outputs;
    private static LinkedHashSet outputSet= new LinkedHashSet();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        inputs = new String[n];
        outputs = new String[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            inputs[i] = st.nextToken();
        }
        Arrays.sort(inputs);
        dfs(n,m,0);

        for(Object outString:outputSet){
            System.out.println(outString);
        }
    }

    private static void dfs(int n, int m, int count) {
        if (count == m) {
            StringBuilder sb = new StringBuilder();
            for(String output : outputs){
                sb.append(output).append(" ");
            }
            outputSet.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; ++i) {
            outputs[count] = inputs[i];
            dfs(n, m, count + 1);
        }
    }

    private static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
