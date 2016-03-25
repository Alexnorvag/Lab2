package by.norvag.lab2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by norvag on 09.02.2016.
 * Ввести с консоли n – размерность матрицы a[n][n].
 * Задать значения элементов матрицы в интервале значений от -n до n с помощью датчика случайных чисел.
 * Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки.
 */
public class Matrix {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sDim = reader.readLine();
        int Dim = Integer.parseInt(sDim);

        int[][] matrixA = new int[Dim][Dim];
        int[] sumLine = new int[Dim];

        int min = -Dim;
        int max = Dim;

        for (int i = 0; i < Dim; i++) {
            for (int j = 0; j < Dim; j++) {
                int rnd = rnd(min, max);
                matrixA[i][j] = rnd;
            }
        }

        for (int i = 0; i < Dim; i++) {
            for (int j = 0; j < Dim; j++) {
                if(matrixA[i][j] > 0){
                    int k = j + 1;
                    while (matrixA[i][k] <= 0) {
                        sumLine[i] += matrixA[i][k];
                        k++;
                    }
                    break;
                }
            }
        }

        System.out.println("Matrix:");
        for(int i = 0; i < Dim; i++) {
            for(int j = 0; j < Dim; j++){
                System.out.print(matrixA[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Sum in lines");
        for (int i = 0; i < sumLine.length; i++){
            System.out.println(sumLine[i]);
        }
    }

    public static int rnd(int min, int max) {
        max -= min;
        return (int)(Math.random() * ++max) + min;
    }
}
