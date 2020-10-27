package ru.geekbrains.algorithms;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int x = 3;
        int startTime;
        int finishTime;
        Random rand=new Random();
        int key=rand.nextInt(4);

        startTime=(int) System.nanoTime();
        int[] arr=new int[400];
        arrNumbers(arr,400);
        finishTime=(int) System.nanoTime();

        System.out.println(Arrays.toString(arr));
        System.out.println(finishTime-startTime);

        //Линейный поиск
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                System.out.println("Key is "+key+" at index: "+i);
                break;
            }
        }

        //Двоичный поиск
        startTime=(int) System.nanoTime();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Key: "+key);
        System.out.println(binarySearch(arr,key));
        finishTime=(int) System.nanoTime();
        System.out.println(finishTime-startTime);

        //Массив из 400 элементов
        int[] bigArr=new int[400];
        arrNumbers(bigArr,400);
        System.out.println(Arrays.toString(bigArr));
        startTime=(int) System.nanoTime();
        Arrays.sort(bigArr);
        System.out.println(Arrays.toString(bigArr));
        finishTime=(int) System.nanoTime();
        System.out.println(finishTime-startTime);

        Сортировка Пузырьком
        int buff;
        boolean sorted=false;
        startTime=(int) System.nanoTime();
        while (!sorted) {
            sorted=true;
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]>arr[i+1]){
                    sorted=false;
                    buff=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=buff;
                }
            }
        }
        bubbleSort(bigArr,400);
        finishTime=(int) System.nanoTime();
        System.out.println(Arrays.toString(bigArr));
        System.out.println(finishTime-startTime);

        //Сортировка методом выбора
        startTime=(int) System.nanoTime();
        for(int i=0;i<bigArr.length-1;i++){
            int min=i;
            for (int j=i+1;j<bigArr.length;j++){
                if(bigArr[j]<bigArr[min]){
                    min = j;
                }
            }
            swapM(bigArr,i,min);
        }
        finishTime=(int) System.nanoTime();
        System.out.println(finishTime-startTime);

        //Сортировка методом вставки
        startTime=(int) System.nanoTime();
        int in;
        for(int i=1;i<bigArr.length;i++){
            buff=bigArr[i];
            in=i;
            while(in>0 && bigArr[in-1]>=buff){
                bigArr[in]=bigArr[in-1];
                --in;
            }
            bigArr[in]=buff;
        }
        finishTime=(int) System.nanoTime();
        System.out.println(finishTime-startTime);
    }



    public static void arrNumbers(int[] arr, int numbers){
        Random rand=new Random();
        for(int i=0;i<arr.length;i++){
            arr[i]=rand.nextInt(numbers);
        }
    }

    public static int binarySearch(int arr[],int key){
        int firstIndex=0;
        int lastIndex=arr.length-1;
        
        while(firstIndex<=lastIndex){
            int middleIndex=(firstIndex+lastIndex)/2;

            if(arr[middleIndex]==key){
                System.out.print("Index at ");
                return middleIndex;
            }
            else if (arr[middleIndex]<key){
                firstIndex=middleIndex+1;
            }
            else {
                firstIndex=middleIndex-1;
            }
        }
        return -1;
    }

    public static void swapM(int[] arr, int first, int last){
        int buff = arr[first];
        arr[first]=arr[last];
        arr[last]=buff;
    }

    public static void bubbleSort(int[] arr,int elements){
        for(int i=elements-1;i>=1;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1])
                    swapM(arr,j,j+1);
            }
        }
    }
}
