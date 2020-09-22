package lesson1;

public class java_hw1_nasirov_m {
    public static void main(String[] args) {
        byte a = 11;
        short b = 22;
        int c = 33;
        long d = 44;
        float e = 55.55F;
        double f = 66.666;
        char g = 'a';
        boolean h = true;
        String i = "Hi";


    }

    public static int calc(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    public static boolean check(int x, int y) {
        if (10 < x + y && x + y <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void positive(int z) {
        if (z >= 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean negative(int w) {
        if (w < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void name(String n) {
        System.out.println("Привет, " + n + "!");
    }

    public static void year(int y) {
        if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
