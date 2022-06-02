public class TestLauncher {
    public static void main(String[] args) {
        RayTraceTest rayTest = new RayTraceTest(new Player("don",3.0,3.0 , 90), 32, 0.1 );
        double[] out = rayTest.findRays();
        for (double dist: out) {
            System.out.println(dist);
        }
    }
}
