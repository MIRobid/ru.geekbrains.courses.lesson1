public class Main {
    public static void main(String[] args) {
        Human human=new Human();
        Cat cat=new Cat();
        Robot robot=new Robot();

        Move[] moves= {
                human,
                cat,
                robot,
        };

        Competitors[] competitors={
                new Running(100),
                new Wall(100)
        };

        for (Move c:moves){
            for (Competitors o:competitors){
                o.doIt(c);
                if(!c.isOnDistance()){
                    break;
                }
            }
        }

    }
}
