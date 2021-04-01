package Lesson2;
import java.util.Arrays;
import java.util.concurrent.Callable;

public class HomeWork2 {
    static void ChangeArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) arr[i]=(arr[i]>0)? 0:1;}

    //Задание2
    static void Arr8(int n) {
        int[] a = new int[n];
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + 3;
        }
    }
    //Задание3
    static void process(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }
    //Задание4
    static void generateArr2(int n) {
        int[][] m = new int[n][n]; // 0 0 0 0...
        for (int i = 0; i < n; i++) {
            m[i][i] = 1;
            m[i][n - i - 1] = 1;
        }
    }

    static void getMinMax(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int i : arr) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        System.out.println(min);
        System.out.println(max);
    }

    static boolean checkBalance(int[] arr) {
        int sum = 0;
        int leftSum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int pos = 0;
        for (int i : arr) {
            leftSum += i;
            pos++;
            if (2 * leftSum == sum) {
                for (int j = 0; j < pos; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
                for (int j = pos; j < arr.length; j++) {
                    System.out.print(arr[j] + " ");
                }
                System.out.println();
                return true;
            }
        }
        return false;
    }

    static void shift(int[] arr, int n) {
        int len = arr.length;
        n = n % len;
        n = (len + n) % len; // n - положительное и меньшее длины массива
        for (int i = 0; i < n; i++) {
            swap(arr);
        }
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
            // 0 1 2 3 4 5
            // 1 2 3 4 5
        }
        arr[arr.length - 1] = temp;
    }

    public static void main(String[] args) {
        System.out.println(checkBalance(new int[]{1, 2, 3, 5, 3, 1, 7}));
        for (int i = -5; i <= 5; i++) {
            shift(new int[]{1, 2, 3, 4, 5}, i);
        }
        //Задание1
        int[] arrayInt1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("1");
        System.out.println("Вход: " + Arrays.toString(arrayInt1));
        ChangeArr(arrayInt1);
        System.out.println("Выход: " + Arrays.toString(arrayInt1));
        //Задание3
        int[] arrayInt3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("3");
        System.out.println("Вход: " + Arrays.toString(arrayInt3));
        process(arrayInt3);
        System.out.println("Выход: "+ Arrays.toString(arrayInt3));

    }


}

