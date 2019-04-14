package sample;

public abstract class Personnage {
    protected double xCoordinate;
    protected double yCoordinate;
    protected int radius;

    public Personnage(int xCoordinate,int yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getRadius() {
        return radius;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public boolean intersect(Personnage other){
        double dx = this.xCoordinate - other.xCoordinate;
        double dy = this.yCoordinate - other.yCoordinate;
        double dCarre = Math.pow(dx,dx)+Math.pow(dy,dy);

        return dCarre < Math.pow(this.xCoordinate+other.xCoordinate,2);
    }
}
