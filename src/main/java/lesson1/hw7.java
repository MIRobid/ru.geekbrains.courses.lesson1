package lesson1;

public class hw7 {
    public static void main(String[] args) {

        Cats[] cat=new Cats[5];
        for(int i=0;i<cat.length;i++){
            cat[i].name="Murzik"+i;
            cat[i].appetite=i*31+i;
        }

        Plate plate = new Plate(2);
        plate.info();
        cat[0].eat(plate,cat);
        plate.info();
        cat[0].info();
    }
}