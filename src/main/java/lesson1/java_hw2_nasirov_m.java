package lesson1;

import java.util.Arrays;

public class java_hw2_nasirov_m {
    public static void main(String[] args) {

        //Задание 1
        int[] arr = {0, 1, 1, 0, 1, 0, 0, 1, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr));

        //Задание 2
        int[] arr2 = new int[8];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i * 3;
        }
        System.out.println(Arrays.toString(arr2));

        //Задание 3
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr3));

        //Задание 4
        int[][] arr4 = new int[3][3];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                if (i == j || i + j == (arr4.length - 1)) {
                    arr4[i][j] = 1;
                }
            }
        }
        printArr(arr4);

        //Задание 5
        int[] arr5 = {3, 2, 1, 4, 5, 6, 7, 8, 9, 10};
        maximum(arr5);
        System.out.println(minimum(arr5));
    }

    //Задание 6
    int[] arr6 = {6, 5, 4, 4, 5, 6};
    method(arr6);

        //Задание 7
        int[] arr7={1,2,3,4,5};
        shiftArr(arr7,1);
        System.out.println(Arrays.toString(arr7));

}


    public static int[] shiftArr(int[] arr, int n) {
        int k=n%arr.length+arr.length;
        for (int i=0;i<k;i++){
            int tmp=arr[arr.length-1];
            for (int j=arr.length-1;j>0;j--){
                arr[j]=arr[j-1];
            }
            arr[0]=tmp;
        }
        return arr;
    }


    public static void method(int[] arr) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                sum1 += arr[j];
            }
            sum2 += arr[i];
            if (sum2 == sum1) {
                System.out.println("true");
                return;
            } else {
                sum1 = 0;
            }
        }
        System.out.println("false");
    }


    public static void maximum(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    public static int minimum(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }


    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }


}
