package lesson1;

public class hw6_nasirov_m {
    public static void main(String[] args) {
        Animal cat = new Cat("Мурзик", 200,0);
        Animal dog =new Dog("Шарик", 500, 10);
        cat.run(200);
        cat.swim(200);
        dog.run(200);
        dog.swim(200);

        System.out.println("Создали животных: "+(cat.getCount()+dog.getCount()));
    }
}

/*
package lesson1;

public abstract class Animal {
    String name;
    int distance;
    int limitRun;
    int limitSwim;
    public int count;

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public int getCount(){
        return count;
    }
}


package lesson1;

public class Dog extends Animal {

    public Dog (String name, int limitRun, int limitSwim){
        this.name=name;
        this.limitRun=limitRun;
        this.limitSwim=limitSwim;
        count++;
    }

    @Override
    public void run(int distance) {
        if(distance<=limitRun){
            System.out.println(name+" пробежал "+distance+" м");
        }else{
            System.out.println(name+" пробежал только "+limitRun+" м из "+distance+" м");
        }
    }

    @Override
    public void swim(int distance) {
        if(distance<=limitSwim) {
            System.out.println(name + " проплыл " + distance + " м");
        }else{
            System.out.println(name+" проплыл только "+limitSwim+" м из "+distance+" м");
        }
    }


}

package lesson1;

public class Cat extends Animal {

    public Cat (String name, int limitRun, int limitSwim){
        this.name=name;
        this.limitRun=limitRun;
        this.limitSwim=limitSwim;
        count++;
    }

    @Override
    public void run(int distance) {
        if(distance<=limitRun){
            System.out.println(name+" пробежал "+distance+" м");
        }else{
            System.out.println(name+" пробежал только "+limitRun+" м из "+distance+" м");
        }
    }

    @Override
    public void swim(int distance) {
        if(distance<=limitSwim) {
            System.out.println(name + " проплыл " + distance + " м");
        }else{
            System.out.println(name+" проплыл только "+limitSwim+" м из "+distance+" м");
        }
    }

}
 */