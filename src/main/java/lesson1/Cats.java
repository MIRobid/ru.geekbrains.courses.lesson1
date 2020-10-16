package lesson1;

public class Cats {
    public String name;
    int appetite;
    boolean full=false;



    public void appetite(int i){
        this.appetite=i;
    }

    public Cats(String name, int appetite){
        this.name = name;
        this.appetite=appetite;
    }
    public void eat(Plate p, Cats cat){
            p.decreaseFood(appetite, this);
    }

    public void info(){
        System.out.println(this.name.toString()+" "+appetite+" "+full);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
