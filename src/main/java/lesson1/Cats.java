package lesson1;

public class Cats {
    public String name;
    public int appetite;
    public boolean full=false;

    public Cats(String name, int appetite){
        this.name = name;
        this.appetite=appetite;
    }
    public void eat(Plate p, Cats[] cat){
            p.decreaseFood(appetite, this);
    }

    public void info(){
        System.out.println(name+appetite+full);
    }
}
