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
    private double FOV = Math.PI / 16;
    private int res;
    private double rayRes;

    public RayTraceTest(Player _player, int _res, double _rayRes){
        player = _player;
        res = _res;
        rayRes = _rayRes;
    }

    public double[] findRays(){
        double[] out = new double[res];
        for(int i = 0; i < res; i++){
            double rayAngle = (player.getAng() - FOV / 2.0) + ((double) i / (double) res) * FOV;
            out[i] = findDist(rayAngle);
        }
        return out;
    }
    private double findDist(double rayAngle){
        double distanceToWall = 0;
        double currX = player.getX(), currY = player.getY();
        while(((int) currX > 0 && (int) currX < field.length)&& //in bounds X
                ((int) currY > 0 && (int) currY < field[0].length)&&// in bounds Y
                (field[(int) currX][(int) currY] == '.')) // no wall detected
        {
            currX += rayRes * Math.cos(rayAngle); //increment by the unit vector x
            currY -= rayRes * Math.sin(rayAngle); //increment by the unit vector y -= because origin is top left
            distanceToWall += rayRes;
        }
        return distanceToWall;
    }


    private void genDraw(double[] dists){

    }
}
