package inputreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InputReader {
    private final BufferedReader br;
    private StringTokenizer st;

    public InputReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
    public InputReader(BufferedReader br) { this.br = br; }

    public String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    public int nextInt() { return Integer.parseInt(next()); }
    public long nextLong() { return Long.parseLong(next()); }
    public float nextFloat() { return Float.parseFloat(next()); }
    public double nextDouble() { return Double.parseDouble(next()); }
}
