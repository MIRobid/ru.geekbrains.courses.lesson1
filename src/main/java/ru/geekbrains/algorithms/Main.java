package ru.geekbrains.algorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        int x = 3;
        int startTime;
        int finishTime;
        Random rand=new Random();
        int key=rand.nextInt(4);

        startTime=(int) System.nanoTime();
        String[] arr=new String[4];
        arr[0]="Zero";
        arr[1]="One";
        arr[2]="Two";
        arr[3]="Three";
        finishTime=(int) System.nanoTime();

        System.out.println(Arrays.toString(arr));
        System.out.println(finishTime-startTime);

        startTime=(int) System.nanoTime();
        ArrayList<String> mArray=new ArrayList<>();
        mArray.add("Zero");
        mArray.add("One");
        mArray.add("Two");
        mArray.add("Three");
        finishTime=(int) System.nanoTime();

        System.out.println(mArray);
        System.out.println(finishTime-startTime);

        //добавление
        startTime=(int) System.nanoTime();
        mArray.add(2,"Element");
        System.out.println(mArray);

        //удаление
        mArray.remove(2);
        System.out.println(mArray);

        //получение элемента из списка
        System.out.println(mArray.get(2));
        finishTime=(int) System.nanoTime();
        System.out.println(finishTime-startTime);

        //простой список
        LinkedList<String> listL=new LinkedList<>();
        listL.add("Zero");
        listL.add("One");
        listL.add("Two");
        listL.add("Three");
        System.out.println(listL);
        listL.add(1,"Element");
        listL.remove(1);
        System.out.println(listL.get(1));

        //итератор
        startTime=(int) System.nanoTime();
        Iterator<String> iter=mArray.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
            iter.remove();
        }
        System.out.println(mArray);
        finishTime=(int) System.nanoTime();
        System.out.println(finishTime-startTime);

    }


}
