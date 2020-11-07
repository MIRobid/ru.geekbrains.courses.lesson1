public class Running implements Competitors {
    private int dlina;
    public Running(int dlina){
        this.dlina=dlina;
    }

    @Override
    public void doIt(Move c) {c.run(dlina);}
}
