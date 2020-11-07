public class Robot implements Move {

    private int rDlina=1000;
    private int rVisota=1000;
    private boolean onDistance=true;

    @Override
    public void run(int x) {
        if(x<=rDlina){
            System.out.println("robot is running");
        }else{
            System.out.println("robot couldn't run");
            onDistance=false;
        }
    }

    @Override
    public void jump(int y) {
        if(y<=rDlina){
            System.out.println("robot is jumping");
        }else{
            System.out.println("robot couldn't jump");
            onDistance=false;
        }
    }

    @Override
    public boolean isOnDistance() {return onDistance;}
}
