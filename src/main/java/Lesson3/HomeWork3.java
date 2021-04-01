package Lesson3;

import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {
    private final static int MaxWord = 15;
    private static char[] tempArr = new char[MaxWord];
    public static void main(String[] args)
    {

        boolean isGameContinue;
        do
        { isGameContinue = mainCycle();

        }
        while(isGameContinue);
    }


    //Экран выбора игры

    static boolean mainCycle()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число, для выбора игры:\n" +
                "1 - Игра \"Угадай число\"\n2 - Игра \"Угадай слово\"");
        int gameNumber = scanner.nextInt();


        switch(gameNumber) {

            case 1:
                //* Задание 1. Написать программу, которая загадывает случайное число от 0 до 9

                guessTheNumber();
                break;

            case 2:
                //*Задание 2: Угадать слово (из заранее заданного массива слов).

                String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                        "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                        "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
                int size = words.length;
                Random random = new Random();
                int numWord = random.nextInt(size);
                GuessWord( words[numWord] );
                break;

            default:
                System.out.println("Введено некорректное число");
                break;
        }
        System.out.println("Вернуться к выбору игры?\n1 - да;\n0 - нет.");
        return scanner.nextInt() == 1 ? true : false;
    }


    //Игра "угадай число"

    static void guessTheNumber()
    {
        final int BOUND = 10;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        boolean repeatGame;
        do
        {
            int number = random.nextInt( BOUND );
            System.out.println("Загадано число от 0 до 9. Угадайте.\n");

            boolean flagNumberGuessed = isNumberGuessed( number );

            String result = flagNumberGuessed ? " угадано: Вы выиграли!\n" : " не угадано: Вы проиграли\n";
            System.out.println("Число " + number + result);
            System.out.println("Повторить игру?\nВведите:\n1 - да;\n0 - нет");

            repeatGame = scanner.nextInt() == 1 ? true : false;

        } while(repeatGame);
    }

    static boolean isNumberGuessed( int requiredNumber )
    {
        final int NUM_CONTINUE = 3;

        Scanner scanner = new Scanner( System.in );
        boolean flagNumberGuessed = false;
        int numContinue = NUM_CONTINUE;

        do
        {
            System.out.print("У Вас " + numContinue + " попытки\n" + "Введите число от 0 до 9: ");
            int inputNumber = scanner.nextInt();
            flagNumberGuessed = inputNumber == requiredNumber;

            String equalSign = inputNumber > requiredNumber ? "больше" : "меньше";
            if(!flagNumberGuessed)
            {
                System.out.println("Вы не угадали, ваше число " + equalSign + ", чем загаданное\n");
            }

            numContinue--;
        } while ( numContinue > 0 && !flagNumberGuessed );

        return flagNumberGuessed;
    }
    //Игра "Угадай слово"


    static void GuessWord(String word)
    {

        fillArrayWithSymbol(tempArr, '#', MaxWord);
        boolean flagWordGuessed;
        System.out.println("Угадайте слово");


        System.out.println();

        do
        {
            flagWordGuessed = isWordGuessed(word);
            if(!flagWordGuessed)
            {
                System.out.println("Продолжайте угадывать");
            }

        }while(!flagWordGuessed);

        System.out.println("Вы угадали! Слово: \"" + word + "\".");
    }

    static boolean isWordGuessed(String reqWord)
    {
        Scanner scanner = new Scanner(System.in);
        String inWord = scanner.nextLine();
        printWordCompareResult(reqWord, inWord);

        return reqWord.equals(inWord);
    }

    static void printWordCompareResult(String reqWord, String inWord)
    {


        int reqSize = reqWord.length();
        int inSize = inWord.length();
        int size = Math.min(reqSize, inSize);

        for(int i = 0; i < size; i++)
        {
            if(inWord.charAt(i) == reqWord.charAt(i))
            {
                tempArr[i] = reqWord.charAt(i);
            }

            System.out.print(tempArr[i]);
        }

        for(int i = size; i < MaxWord; i++)
        {
            System.out.print(tempArr[i]);
        }
        System.out.println();
    }

    static void fillArrayWithSymbol(char[] arr, char symbol, int size)
    {
        for(int i = 0; i < size; i++)
        {
            arr[i] = symbol;
        }
    }
    //---------------------------------------------------------

}
