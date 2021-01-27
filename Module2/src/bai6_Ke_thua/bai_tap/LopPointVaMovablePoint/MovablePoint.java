package bai6_Ke_thua.bai_tap.LopPointVaMovablePoint;

public class MovablePoint  extends Point{
    protected float xSpeed;
    protected float ySpeed;

    public MovablePoint(){

    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed(){
        return new float[]{this.xSpeed, this.ySpeed};
    }

    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint move(){
        this.x += this.xSpeed;
        this.y += this.ySpeed;

        return this;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + "), speed = (" + this.xSpeed + ", " + this.ySpeed + ")";
    }
}
