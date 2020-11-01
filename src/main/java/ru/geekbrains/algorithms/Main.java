package ru.geekbrains.algorithms;

import java.util.*;

class StackList{
    private LinkedList list;
    public StackList() {list=new LinkedList();}
    public void push(String name){list.add(name);}
    public void pop(int x){list.remove(x);}
    public boolean isEmpty(){return list.isEmpty();}
    public void display(int x){list.get(x);}
}

public class Main {



    public static void main(String[] args) {
        int startTime;
        int finishTime;
        Random rand=new Random();

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


        //Задача 4.1
        startTime=(int) System.nanoTime();
        Stack<String> sList=new Stack<>();

        sList.push("One");
        sList.push("Two");
        sList.push("Three");
        sList.push("Four");

        while(!sList.empty()){
            System.out.println(sList);
            sList.pop();
        }
        finishTime=(int) System.nanoTime();
        System.out.println(finishTime-startTime);

        //Задача 4.2
        startTime=(int) System.nanoTime();
        Queue<String> qList=new LinkedList<>();
        
        qList.add("One");
        qList.add("Two");
        qList.add("Three");

        while(!qList.isEmpty()){
            System.out.println(qList);
            qList.poll();
        }
        finishTime=(int) System.nanoTime();
        System.out.println(finishTime-startTime);

        //Задача 4.3
        startTime=(int) System.nanoTime();
        Deque<String> dList=new LinkedList<>();

        dList.add("One");
        dList.add("Two");
        dList.add("Three");
        dList.addFirst("Zero");
        dList.addLast("Last");

        while (!dList.isEmpty()){
            System.out.println(dList);
            dList.poll();
        }
        finishTime=(int) System.nanoTime();
        System.out.println(finishTime-startTime);

        //Задача 4.4
        startTime=(int) System.nanoTime();
        PriorityQueue<Integer> pList=new PriorityQueue<>();

        pList.add(1);
        pList.add(2);
        pList.add(3);
        pList.offer(4);

        while(!pList.isEmpty()){
            System.out.println(pList.poll());
        }

        finishTime=(int) System.nanoTime();
        System.out.println(finishTime-startTime);

        //Задача 4.5
        startTime=(int) System.nanoTime();
        StackList s1 = new StackList();
        s1.push("Test");
        s1.display(0);
        finishTime=(int) System.nanoTime();
        System.out.println(finishTime-startTime);


    }


}

