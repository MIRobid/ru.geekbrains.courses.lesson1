package lesson1;

import java.util.Random;
import java.util.Scanner;

public class java_hw3_nasirov_m {
    public static Scanner sc = new Scanner(System.in);

    //Задание 1
    public static void main(String[] args) {
        System.out.println("Начинаем игру \"Угадай число\". У вас 3 попытки.");
        int end = 1;
        do {
            game(10, 3);
            System.out.println("Повторить игру еще раз? 1 – да / любая другая цифра – нет");
            end = sc.nextInt();
        } while (end == 1);
        System.out.println("The End");
        sc.close();
    }

    public static int game(int n, int count) {

        Random rand = new Random();
        int x = rand.nextInt(n);
        System.out.println("Введите число от 0 до 9");
        for (int i = 0; i < count; i++) {
            int answer = sc.nextInt();
            if (answer == x) {
                System.out.println("Правильно!");
                return answer;
            } else if (answer > x) {
                System.out.println("Выберете число поменьше. Осталось " + (count - i - 1) + " попытки");
            } else {
                System.out.println("Выберете число побольше. Осталось " + (count - i - 1) + " попытки");
            }

        }
        System.out.println("Правильный ответ: " + x);
        return x;
    }

    //Задание 2
    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    Random rand = new Random();
    int x = rand.nextInt(words.length);
    String answer = words[x].toLowerCase();
    int length = words[x].length();
    String[] wall = new String[length];
        for(
    int i = 0;
    i<wall.length;i++)

    {
        wall[i] = "#";
    }

    String myAnswer;
        System.out.println("Угадайте слово");
        do

    {
        myAnswer = sc.nextLine().toLowerCase();
        for (int i = 0; i < words[x].length() && i < myAnswer.length(); i++) {
            char a = answer.charAt(i);
            char b = myAnswer.charAt(i);
            if (a == b) {
                wall[i] = String.valueOf(a);
            }
        }
        arr(wall);
    }while(!sc.hasNext(answer));
        System.out.println("Правильно!");
        sc.close();
}

    public static void arr(String[] array) {
        String tail = "##########";
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.print(tail);
        System.out.println();
    }
}

