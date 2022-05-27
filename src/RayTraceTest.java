public class RayTraceTest {
    private char[][] field = {{'#','0','#','#','#','0','0'},
                              {'#','0','0','0','#','0','0'},
                              {'#','#','#','0','#','0','0'},
                              {'0','0','#','0','#','0','#'},
                              {'#','0','0','0','0','0','#'},
                              {'0','0','#','#','#','0','#'},
                              {'#','0','0','0','0','0','#'},
                              {'0','#','0','0','0','#','#'}};
    private Player player;
    private double FOV = Math.PI / 4;
    private int res;

    private double[] findRays(){
        for(int i = 0; i < res; i++){
            double rayAngle = (player.getAng() - FOV / 2.0) + ((double) i / (double) res) * FOV;
            double distanceToWall = 0; //abstract this
            //while loop adding unit vector and checking
            //add to an array
        }
        return null;
    }

    private void genDraw(){//generate rects to draw from cols
    }
}
