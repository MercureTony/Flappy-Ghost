package sample;

public abstract class Personnage {
    private int xCoordinate;
    private int yCoordinate;
    private int radius;

    public Personnage(int xCoordinate,int yCoordinate,int radius){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.radius = radius;
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
