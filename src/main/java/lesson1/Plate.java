package lesson1;

public class Plate {
    private int food;
    Plate (int food) {
        this.food = food;
    }
    public int getFood() {return food;}

    public void decreaseFood(int n, Cats c){

        if(n<0) {
            return;
        }
           else if(food-c.appetite<0) {
               System.out.println("Нужно больше еды для "+c.name);
           } else {
               food -= n;
               c.full=true;
           }
        }

        public boolean addFood(int amount){
        if(amount<0){
            return false;
        }
        food+=amount;
        return true;
        }

    public void info(){
        System.out.println("plate: "+food);
    }
}
