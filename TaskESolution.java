import java.io.*;

public class TaskESolution {
    private static final String FILE_INPUT = "input.txt";
    private static final String FILE_OUTPUT = "output.txt";
    private static BufferedReader bufferedReader = null;
    private static BufferedWriter bufferedWriter = null;
    public static void main(String[] args) throws Exception {
        init();
        run();
        close();
    }

    private static void init() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(FILE_INPUT));
        bufferedWriter = new BufferedWriter(new FileWriter(FILE_OUTPUT));
    }

    private static void close() throws IOException {
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static String readLine() throws IOException {
        return bufferedReader.readLine();
    }

    private static void writeLine(char ch) throws IOException {
        bufferedWriter.write(ch);
        bufferedWriter.newLine();
    }

    private static void run() throws IOException {

        String s = readLine();
        String s1 = readLine();
        if (s1.equals(s)) {
            writeLine('1');
            return;
        }
        if (s1.length() != s.length()) {
            writeLine('0');
            return;
        }
        int[] alf = new int[26];
        for (int i = 0; i <s.length(); i++) {
            alf[s.charAt(i)-'a']++;
        }
        for (int i = 0; i <s1.length(); i++) {
            alf[s1.charAt(i)-'a']--;
        }
        for (int i = 0; i <26; i++) {
            if (alf[i] != 0) {
                writeLine('0');
                return;
            }
        }
        writeLine('1');
    }

}
