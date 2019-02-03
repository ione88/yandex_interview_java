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

public class WooHooС {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(r.readLine());
        if (n < 1) return;
        int m = Integer.valueOf(r.readLine());
        System.out.println(m);
        int l = m;

        for (int i = 1; i < n; ++i) {
            m = Integer.valueOf(r.readLine());
            if (m != l) {
                System.out.println(m);
                l = m;
            }
        }
    }
}
