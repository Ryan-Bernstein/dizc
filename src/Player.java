public class Player extends Entity {
    private String name;
    private char[][] field;
    private RayTraceTest engine;

    private boolean win;

    private int vicX, vicY;

    public Player(String name, double x, double y, double a){
        this.name = name;
        setPos(x,y,a);
        win = false;
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
        if(!((int) getX() + 1 > 0 && (int) getX() < field.length) || //in bounds X
        !((int) getY() + 1 > 0 && (int) getY() < field[0].length)
        || field[(int) getX()][(int) getY()] == '#'){
            setX(x);
            setY(y);
        }
        if((int) getX() == vicX && (int) getY() == vicX){
            this.win = true;
        }

    }//tbi

    @Override
    public String toString() {
        String out = "";
//        for(char[] row: field){
//            for(char bit: row){
//                //add player thing
//                out += bit;
//            }
//            out += "\n";
//        }
        out += getX() + ", " + getY();
        return out;
    }

    public void setEngine(RayTraceTest engine) {
        this.engine = engine;
    }

    public boolean isWin() {
        return win;
    }
}
