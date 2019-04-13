package sample;

public abstract class Personnage {
    protected int xCoordinate;
    protected int yCoordinate;
    protected int radius;

    public Personnage(int xCoordinate,int yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getRadius() {
        return radius;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
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
}
