import java.util.Arrays;
import java.util.Random;

public class Main {

    //5.1 Приведите пример использования рекурсии.
    //арифметическая прогрессия, где а=а1+(n-1)d.

    //5.2. Реализуйте простой пример бесконечной рекурсии и обычной рекурсии с условием для выхода.
    public static int counting1(int n){
        System.out.println(n);
        return counting1(n/2);
    }

    public static int counting2(int n){
        System.out.println(n);
        if(n<1){
            return 0;
        }
        return counting2(n/2);
    }

    //5.3 Приведите пример изображающий стек вызова и стек вызова с рекурсией.
    int x=3;
    int y=5;
    int a=x+y;
    int b=a+x+y;

    public static int factorial(int n){
            int result=n*(factorial(n-1));
            System.out.println(result);
            return result;

    }

    //5.4 Реализуйте простой алгоритм использующий цикл и простой алгоритм использующий рекурсию.
    //Оцените два алгоритма с помощью базового метода System.nanoTime().
    public static void sikl(int n){
    int start=(int) System.nanoTime();
        for(int i=0;i<n;i++){
            i=i+i;
            System.out.println(i);
        }
        int finish=(int) System.nanoTime();
        System.out.println(finish-start);

    }

    public static int recur(int n){
        System.out.println(n);
        return recur(n+1);
    }

    //5.5 Реализуйте алгоритм двоичного рекурсивного поиска на основе массива из задания 2.1.
    //Оцените алгоритм двоичного рекурсивного поиска с помощью базового метода System.nanoTime() и сравните с обычным двоичным поиском.
    public static int binaryFind(int key,int min, int max,int[] arr){
        if (min>max)
            return arr.length;

        int mid=(min+max)/2;

        if (arr[mid]==key)
            return mid;
        else if (arr[mid]<key)
            return binaryFind(key,min+1,max,arr);
        else
            return binaryFind(key, min,max-1,arr);
    }

    //5.6 На основе массива из задания 2.1 реализуйте алгоритм сортировки слиянием.
    //Оцените алгоритм сортировки слиянием с помощью базового метода System.nanoTime() и сравните с сортировкой методом sort().

    public static int[] sortMerge(int[] arr){
        int len=arr.length;
        if(len<2) return arr;
        int middle = len/2;
        return merge(sortMerge(Arrays.copyOfRange(arr,0,middle))),sortMerge(Arrays.copyOfRange(arr,middle,len)));
    }

    public static int[] merge(int[] a,int[] b){
        int[] result=new int[a.length+b.length];
        int aIndex=0;
        int bIndex=0;

        for(int i=0;i<result.length;i++){
            result[i]=a[aIndex]<b[bIndex] ? a[aIndex]:b[bIndex++];
            if(aIndex==a.length){
                System.arraycopy(b,bIndex,result,++i,b.length-bIndex);
                break;
            }
            if(bIndex==b.length){
                System.arraycopy(a,aIndex,result,++i,a.length-aIndex);
                break;
            }
        }
        return result;
    }



    public static void main (String[] args){
        int n=5;
        factorial(n);
        counting2(n);
        int[] arr=new int[n];
        Random rand=new Random();
        for(int i=0;i<arr.length;i++){
            arr[i]=i;
        }
        int start=(int) System.nanoTime();
        System.out.println(binaryFind(4,0,n,arr));
        int finish=(int) System.nanoTime();
        System.out.println(finish-start);

        int[] arr2=new int[n];
        for(int i=0;i<arr2.length;i++){
            arr2[i]=rand.nextInt(n);
        }
        int start2=(int) System.nanoTime();
        System.out.println(Arrays.toString(sortMerge(arr2)));
        int finish2=(int) System.nanoTime();
        System.out.println(finish-start);
    }
}
