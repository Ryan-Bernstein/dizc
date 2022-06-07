import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class RayTraceTest {
    private char[][] field = {{'#','.','#','#','#','.','.'},
                              {'#','.','.','.','#','.','.'},
                              {'#','#','#','.','#','.','.'},
                              {'.','.','#','.','#','.','#'},
                              {'#','.','.','.','.','.','#'},
                              {'.','.','#','#','#','.','#'},
                              {'#','.','.','.','.','.','#'},
                              {'.','#','.','.','.','#','#'}};
    private Player player;
    private double FOV = Math.PI / 1.5, renderDistance = 4;
    private int res;
    private double rayRes;
    private Display display;


    public RayTraceTest(Player _player, int _res, double _rayRes, Display display){
        player = _player;
        res = _res;
        rayRes = _rayRes;
        this.display = display;
    }

    private double[] findRays(){
        double[] out = new double[res];
        for(int i = 0; i < res; i++){
            double rayAngle = (Math.toRadians(player.getAng()) - FOV / 4.0) + ((double) i / (double) res) * FOV;
            out[i] = findDist(rayAngle);
//            if(i * 2 == res){System.out.println(rayAngle);}
        }
        return out;
    }
    private double findDist(double rayAngle){
        double distanceToWall = 0, yUnitV = Math.sin(rayAngle), xUnitV = Math.cos(rayAngle);
        double currX = player.getX(), currY = player.getY();
        while(((int) currX > 0 && (int) currX < field.length)&& //in bounds X
                ((int) currY > 0 && (int) currY < field[0].length)&&// in bounds Y
                (field[(int) currX][(int) currY] == '.')) // no wall detected
        {
            currX += rayRes * xUnitV; //increment by the unit vector x
            currY -= rayRes * yUnitV; //increment by the unit vector y -= because origin is top left
            distanceToWall += rayRes;
        }
        return distanceToWall;
    }

    private ArrayList<Column> genDraw(double[] dists){
        int screenHeight = display.getDimentions()[1], screenWidth = display.getDimentions()[0];
        ArrayList<Column> out = new ArrayList<Column>();
        for (int col =  0; col < res; col++) {
            double dist = dists[col];
            int nCeiling = (dist > 2) ? (int)((screenHeight / 2.0) - screenHeight / ((double) dist)) : (int)((screenHeight / 2.0) - screenHeight / ((double) 2)) ;
//            System.out.print(nCeiling);
            int nfloor = screenHeight - nCeiling;
            out.add(new Column(nCeiling, nfloor, res, col * 2 + 1, dist, screenWidth));
            out.add(new Column(nCeiling, nfloor, res, col * 2, dist, screenWidth));
        }
        return out;
    }

    public ArrayList<Column> getRenderSet(){
        return genDraw(findRays());
    }
}

