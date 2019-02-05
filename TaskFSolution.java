/*
F. Слияние k сортированных списков
Язык	Ограничение времени	Ограничение памяти	Ввод	Вывод
Все языки	1 секунда	10Mb	стандартный ввод или input.txt	стандартный вывод или output.txt
Oracle Java 7	1 секунда	20Mb
Node JS 8.9.4	1 секунда	20Mb
Oracle Java 8	1 секунда	20Mb
Kotlin	1 секунда	20Mb
Даны k отсортированных в порядке неубывания массивов неотрицательных целых чисел, каждое из которых не превосходит 100. Требуется построить результат их слияния: отсортированный в порядке неубывания массив, содержащий все элементы исходных k массивов.

Длина каждого массива не превосходит 10 ⋅ k.

Постарайтесь, чтобы решение работало за время k ⋅ log(k) ⋅ n, если считать, что входные массивы имеют длину n.

Формат ввода
Первая строка входного файла содержит единственное число k, k ≤ 1024.

Каждая из следующих k строк описывает по одному массиву. Первое число каждой строки равняется длине соответствующего массива, оставшиеся числа этой строки описывают значения элементов этого же массива. Элементы массивов являются неотрицательными целыми числами и не превосходят 100.

Формат вывода
Выходной файл должен содержать отсортированный в порядке неубывания массив, содержащий все элементы исходных массивов.

Пример
Ввод	
4
6 2 26 64 88 96 96
4 8 20 65 86
7 1 4 16 42 58 61 69
1 84
Вывод
1 2 4 8 16 20 26 42
58 61 64 65 69 84 86
88 96 96 

*/import java.io.*;

public class TaskFSolution {
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

    private static void run() throws IOException {
        int k, ki, i, j;
        
        nextChars();
        k = charsToInt();
        for (i = 0; i < k; ++i){
            nextChars();
            ki = charsToInt();
            for(j = 0; j < ki; ++j){
                nextChars();
                ++sort[charsToInt()];
            }
        }
        for(i = 0; i <= 100; ++i) {
            charsFromInt(i);
            for (j = 0; j < sort[i]; ++j)
                writeChars();
        }
    }
    
    private static final int MAX_CHAR_ARRAY_SIZE = 5;
    private static final int MAX_NUMBER = 101;
    
    private static int[] sort = new int[MAX_NUMBER];
    private static char[] chars = new char[MAX_CHAR_ARRAY_SIZE];
    
    private static void nextChars() throws IOException {
        int b = 0;
        count = MAX_CHAR_ARRAY_SIZE;
        while (b != '\n' && b != -1 && b != ' ') {
            b = bufferedReader.read();
            if (chars[i] >= '0' && chars[i] <= '9')
                chars[--count] = (char) b;
        }
        for (int i = 0; i < count; ++i) {
            chars[i] = '0';
        }
    }

    private static void writeChars() throws IOException {
        int count = 0;
        for (; count < MAX_CHAR_ARRAY_SIZE-1; ++count) {
            if (chars[i] != '0') break;
        }
        
        for (; count < MAX_CHAR_ARRAY_SIZE; ++count) {
            bufferedWriter.write(chars[count]);
        }
        
        bufferedWriter.write(' ');
    }

    private static int charsToInt() {
        int i, number = 0;

        for(i = 0; i < chars.length; i++)
            if (chars[i] >= '0' && chars[i] <= '9')
                number = (number * 10) + (chars[i] - '0');

        return number;
    }

    private static void charsFromInt(int number) {
        int count = MAX_CHAR_ARRAY_SIZE-1;
        for (; count >= 0; --count) {
            chars[i] = (char) ((number%10) + '0');
        }
    }

}
