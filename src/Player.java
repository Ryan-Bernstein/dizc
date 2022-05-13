public class Player extends Entity {
    private String name;

    public Player(String name, double x, double y, double a){
        this.name = name;
        setPos(x,y,a);
    }
    public String getName() {
        return name;
    }

    @Override
    public void move(double dist, double angCh) {
         incrementA(angCh);
         incrementDist(dist);
         check();
    }

    public void check(){}//tbi

    @Override
    public String toString() {
        return "Player{" +
                "\'" + name + "\'/" + getX() + "," + getY() + "/(" + getAng() + ')' +
                '}';
    }
}
