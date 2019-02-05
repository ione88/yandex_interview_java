/* B. Последовательно идущие единицы
Ограничение времени	1 секунда
Ограничение памяти	64Mb
Ввод	стандартный ввод или input.txt
Вывод	стандартный вывод или output.txt
Требуется найти в бинарном векторе самую длинную последовательность единиц и вывести её длину.

Желательно получить решение, работающее за линейное время и при этом проходящее по входному массиву только один раз.

Формат ввода
Первая строка входного файла содержит одно число n, n ≤ 10000. Каждая из следующих n строк содержит ровно одно число — очередной элемент массива.

Формат вывода
Выходной файл должен содержать единственное число — длину самой длинной последовательности единиц во входном массиве.

Пример
Ввод	Вывод
5
1
0
1
0
1
1
*/
import java.io.*;

public class TaskBSolution {
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

    private static void writeLine(int IntToFile) throws IOException {
        bufferedWriter.write(String.valueOf(IntToFile));
        bufferedWriter.newLine();
    }

    private static void run() throws IOException {
        int n,m, local, result;
        n = readLine();
        result = 0;
        local = 0;

        for (int i = 0; i < n; ++i) {
            m = readLine();
            if (m == 1) {
                ++local;
            } else {
                result = Math.max(result, local);
                local = 0;
            }
        }
        writeLine(result);
    }


}
