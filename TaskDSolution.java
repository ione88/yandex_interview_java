/*D. Генерация скобочных последовательностей
Ограничение времени	1 секунда
Ограничение памяти	20Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
Дано целое число n. Требуется вывести все правильные скобочные последовательности длины 2 ⋅ n, упорядоченные лексикографически (см. https://ru.wikipedia.org/wiki/Лексикографический_порядок).

В задаче используются только круглые скобки.

Желательно получить решение, которое работает за время, пропорциональное общему количеству правильных скобочных последовательностей в ответе, и при этом использует объём памяти, пропорциональный n.

Формат ввода
Единственная строка входного файла содержит целое число n, 0 ≤ n ≤ 11

Формат вывода
Выходной файл содержит сгенерированные правильные скобочные последовательности, упорядоченные лексикографически.

Пример 1
Ввод	Вывод
2
(())
()()
Пример 2
Ввод	Вывод
3
((()))
(()())
(())()
()(())
()()()
*/
import java.io.*;

public class TaskDSolution {
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

    private static int readLine() throws IOException {
        return Integer.valueOf(bufferedReader.readLine());
    }

    private static void writeLine(char[] IntToFile) throws IOException {
        bufferedWriter.write(IntToFile);
        bufferedWriter.newLine();
    }

    private static void run() throws IOException {
        int n = readLine() * 2;
        if (n < 2) return;
        char[] chrs = new char[n];
        for (int i = 0; i < n/2; i++) {
            chrs[i] = '(';
        }
        for (int i = n/2; i < n; i++) {
            chrs[i] = ')';
        }
        writeLine(chrs);
        do {
            int i = n - 1;
            int c = 0;
            while (i >= 0) {
                c += chrs[i] == ')' ? -1 : 1;
                if ((c < 0) && (chrs[i] == '(')) break;
                --i;
            }
            if (i < 0) break;

            chrs[i++] = ')';
            int ind = i;
            for (; i < n; i++) {
                chrs[i] = (i<= (n-ind+c)/2+ind) ? '(' : ')';
            }
            writeLine(chrs);
        }while (true);
    }
}
