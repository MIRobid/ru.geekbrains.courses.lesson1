package lesson1;

public class Plate {
    private int food;
    public Plate (int food) {
        this.food = food;
    }
    public void decreaseFood(int n, Cats c){

        if(n<0) {
            return;
        }
           else if(food-c.appetite<0) {
               System.out.println("Нужно больше еды");
           } else {
               food -= n;
               c.full=true;
           }
        }

    public void info(){
        System.out.println("plate: "+food);
    }
}
