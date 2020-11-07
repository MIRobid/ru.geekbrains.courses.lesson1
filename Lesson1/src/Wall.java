public class Wall implements Competitors {
    private int visota;
    public Wall(int visota){
        this.visota=visota;
    }

    @Override
    public void doIt(Move c) {c.jump(visota);}
}
