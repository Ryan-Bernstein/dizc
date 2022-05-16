public abstract class Entity {
    private double x;
    private double y;
    private double ang;

    public abstract void move(double dist, double angle);

    public double getX() {
        return x;
    }

    public double getAng() {
        return ang;
    }

    public double getY() {
        return y;
    }

    public void incrementA(double changeA){ //adds to the angle then performs adjustments for <0 and >360
        double temp = ang += changeA;
        if (temp > 360){ang = temp % 360;}
        else if(temp < 0){ang = 360 - Math.abs(temp);}
        else{ang = temp;}
    }

    public void incrementDist(double dist){ //add the sin and cos vals of dist for ang to x/y
        this.x += dist * Math.cos(Math.toRadians(ang));
        this.y += dist * Math.sin(Math.toRadians(ang));
    }

    public void setAng(double ang) {
        this.ang = ang;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setPos(double x,double y,double a){
        this.x = x;
        this.y = y;
        this.ang = a;
    }
}
