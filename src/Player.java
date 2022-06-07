public class Player extends Entity {
    private String name;
    private char[][] field;
    private RayTraceTest engine;

    public Player(String name, double x, double y, double a){
        this.name = name;
        setPos(x,y,a);
    }
    public String getName() {
        return name;
    }

    @Override
    public void move(double dist, double angCh) {
         double oldX = getX(), oldY = getY();
         incrementA(angCh);
         incrementDist(dist);
         check(oldX, oldY);
    }

    public void check(double x, double y){
        if(field == null){field = engine.getField();}
        if(field[(int) getX()][(int) getY()] == '#'){
            setX(x);
            setY(y);
        }
    }//tbi

    @Override
    public String toString() {
        return "Player{" +
                "\'" + name + "\'/" + getX() + "," + getY() + "/(" + getAng() + ')' +
                '}';
    }

    public void setEngine(RayTraceTest engine) {
        this.engine = engine;
    }
}
