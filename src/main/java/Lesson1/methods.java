package Lesson1;

import java.util.Scanner;

public class methods {
    //Написать метод, которому в качестве параметра передается целое число, метод должен
    //напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль
    //считаем положительным числом.
    static void shwValue(int value) {
        if (value >= 0) {
            System.out.println("+");
        }
        else if (value < 0)    {
            System.out.println("-");
        }
    }
    // Написать метод, которому в качестве параметра передается целое число, метод должен
    //вернуть true, если число отрицательное;
    static boolean isPositive(int value) {
        return (value > 0);
    }
    //Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит
    //в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    static boolean isWet(int value) {
        return value >= 10 && value <= 20;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число");

        int value = in.nextInt();
        shwValue(value);

        System.out.println(isPositive(value));
        isPositive(value);

        System.out.println(isWet(value));
        isWet(value);



    }










    }


