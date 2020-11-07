public class Human implements Move {

    private int hDlina=150;
    private int hVisota=150;
    private boolean onDistance=true;

    @Override
    public void run(int x) {
        if(x<=hDlina){
            System.out.println("human is running");
        }else{
            System.out.println("human couldn't run");
            onDistance=false;
        }
    }

    @Override
    public void jump(int y) {
        if(y<=hDlina){
            System.out.println("human is jumping");
        }else{
            System.out.println("human couldn't jump");
            onDistance=false;
        }
    }

    @Override
    public boolean isOnDistance() {return onDistance;}
}
