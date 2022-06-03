public class TestLauncher {
    public static void main(String[] args) {
        RayTraceTest rayTest = new RayTraceTest(new Player("don",7.0,2.1 , 90), 32, 0.1, display);
        double[] out = rayTest.findRays();
        for (double dist: out) {
            System.out.println(dist);
        }
    }
}
