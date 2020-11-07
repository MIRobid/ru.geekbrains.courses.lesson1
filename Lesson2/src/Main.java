import java.lang.*;
import java.util.Arrays;
import java.util.function.DoubleToIntFunction;

public class Main {
    public static void main(String args[]) throws MyArraySizeException, MyArrayDataException {
            String[][] arr=new String[4][4];
            try{
                binArray(arr);
            }catch (MyArrayDataException e){
                System.out.println(e.text);
            }catch (MyArraySizeException e){
                System.out.println(e.text);
            }

    }

    public static void binArray(String[][] arr) throws MyArraySizeException, MyArrayDataException{
        int count=0;
        if(arr.length!=4){
            throw new MyArraySizeException("Размер больше 4");
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i].length!=4) throw new MyArraySizeException("Столбцы не равны 4");
                arr[i][j]="i"+i;
                System.out.println(arr[i][j]);
                try{
                    count+=Integer.parseInt(arr[i][j]);
                }catch(NumberFormatException e){
                    throw new MyArrayDataException(i,j);
                }

            }

        }
        System.out.println(count);
    }
}

class MyArraySizeException extends Exception{
    public String text;
    public MyArraySizeException(String text){
        this.text=text;
    }
}

class MyArrayDataException extends NumberFormatException{
    public String text;
    public MyArrayDataException(int arrayN, int n){
        text="Не смогли конвертировать ячейку: "+arrayN+" "+n;
    }
}