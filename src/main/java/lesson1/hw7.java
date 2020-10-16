package lesson1;

import java.util.Random;

public class hw7 {
    public static void main(String[] args) {
        Plate plate = new Plate(100);
        plate.addFood(100);
        Cats[] cat={
                new Cats("Murzik",10),
                new Cats("Barsik",5),
                new Cats("Begemot",100)
        };

        for(Cats cats:cat) {
            cats.eat(plate,cats);
        }
        for(Cats cats:cat) {
            cats.info();
        }

        plate.info();

    }
}