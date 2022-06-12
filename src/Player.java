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
        if(field == null){field = engine.getField(); init();}
        if(!((int) getX() + 1 > 0 && (int) getX() < field.length) || //in bounds X
        !((int) getY() + 1 > 0 && (int) getY() < field[0].length)
        || field[(int) getX()][(int) getY()] == '#'){
            setX(x);
            setY(y);
        }
//        System.out.println((int) getX() + ", " + (int) getY() + ":" + vicX + ", " + vicY);
        if((int) getX() == vicX && (int) getY() == vicY){
            this.win = true;
        }

    }//tbi
    private void init(){
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[0].length; col++) {
               char bit = field[row][col];
               if(bit == 'S'){setPos(row, col, 0);}
               if(bit == 'F'){this.vicX = row; this.vicY = col;}
            }
        }
    }

    @Override
    public String toString() {
        String out = "";
        for(int row = 0; row < field.length; row++){
            for(int col = 0; col < field[0].length; col++){
                //add player thing
                char bit = field[row][col];
                out += ((int) getX() == row && (int) getY() == col) ? "O" : bit;
            }
            out += "\n";
        }
//        out += getX() + ", " + getY();
        return out;
    }

    public void setEngine(RayTraceTest engine) {
        this.engine = engine;
    }

    public boolean isWin() {
        return win;
    }
}
