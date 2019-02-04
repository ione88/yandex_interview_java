/*
Oracle Java 8
1 секунда	20Mb
Дан упорядоченный по неубыванию массив целых 32-разрядных чисел. Требуется удалить из него все повторения. 
Желательно получить решение, которое не считывает входной файл целиком в память, т.е., использует лишь константный объем памяти в процессе работы.
Формат ввода Первая строка входного файла содержит единственное число n, n ≤ 1000000.
На следующих n строк расположены числа — элементы массива, по одному на строку. Числа отсортированы по неубыванию.
Формат вывода Выходной файл должен содержать следующие в порядке возрастания уникальные элементы входного массива.
Пример 1 
Ввод	Вывод 
5        2
2        4  
4        8
8 
8 
8  
Пример 2 
Ввод	Вывод 
5        2
2        8
2 
2 
8 
8
*/

import java.io.*;

public class TaskCSolution {
    private static final String FILE_INPUT = "input.txt";
    private static final String FILE_OUTPUT = "output.txt";
    private static BufferedReader bufferedReader = null;
    private static BufferedWriter bufferedWriter = null;
    private static int MAX_CHAR_ARRAY_SIZE = 15;
    public static void main(String[] args) throws Exception {
        init();
        run();
        close();
    }

    private static void init() throws IOException {
        bufferedReader = new BufferedReader(new FileReader(FILE_INPUT));
        bufferedWriter = new BufferedWriter(new FileWriter(FILE_OUTPUT));
    }

    private static void run() throws IOException {
        int n = Integer.valueOf(String.valueOf(readLine()).trim());
        if (n<1) return;

        char[] m = writeLine(readLine());
        char[] l = m;
        int i = 1;

        while (i<n){
            m = readLine();
            if (!equals(m,l)) l = writeLine(m);
            ++i;
        }
    }

    private static void close() throws IOException {
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static char[] readLine() throws IOException {
        char[] res = new char[MAX_CHAR_ARRAY_SIZE];
        int count = 0;
        while (true) {
            int b = bufferedReader.read();
            if (b == '\n' || b == -1) break;
            if (b == '\r') continue;
            res[count] = (char) b;
            count++;
        }
        return res;
    }
    private static char[] writeLine(char[] IntToFile) throws IOException {
        bufferedWriter.write(IntToFile);
        bufferedWriter.newLine();
        return IntToFile;
    }

    private static boolean equals(char[] chars1, char[] chars2) throws IOException {
        for (int i = 0; i < MAX_CHAR_ARRAY_SIZE; ++i){
            if (chars1[i] != chars2[i])
                return false;
        }
        return true;
    }
}
