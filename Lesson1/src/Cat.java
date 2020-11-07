public class Cat implements Move {

    private int cDlina=100;
    private int cVisota=50;
    private boolean onDistance=true;

    @Override
    public void run(int x){
        if(x<=cDlina){
            System.out.println("cat is jumping");
        }else{
            System.out.println("cat couldn't jump");
            onDistance=false;
        }
    }

    @Override
    public void jump(int y){
        if(y<cVisota){
            System.out.println("cat is jumping");
        }else{
            System.out.println("cat isn't jumping");
            onDistance=false;
        }
    }

    @Override
    public boolean isOnDistance() {return onDistance;}
}
