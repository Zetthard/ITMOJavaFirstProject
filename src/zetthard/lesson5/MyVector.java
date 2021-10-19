package zetthard.lesson5;

import java.util.Random;

public class MyVector {

    private double x;
    private double y;
    private double z;

    public double getX() {
        return x;
    }

    private void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    private void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    private void setZ(double z) {
        this.z = z;
    }

    public MyVector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "MyVector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public double getLength() {
        return Math.sqrt(x*x + y*y + z*z);
    }

    public static double getScalar (MyVector vect1, MyVector vect2) {
        return vect1.x * vect2.x + vect1.y * vect2.y + vect1.z * vect2.z;
    }

    public static MyVector getVProduct (MyVector vect1, MyVector vect2) {

        double xCoord = vect1.y * vect2.z - vect1.z * vect2.y;
        double yCoord = vect1.z * vect2.x - vect1.x * vect2.z;
        double zCoord = vect1.x * vect2.y - vect1.y * vect2.x;

        return new MyVector(xCoord, yCoord, zCoord);
    }

    public static double getCosine (MyVector vect1, MyVector vect2) {

        return getScalar(vect1, vect2) / (vect1.getLength() * vect2.getLength());
    }

    public static MyVector addVectors (MyVector vect1, MyVector vect2) {

        return new MyVector(vect1.x + vect2.x, vect1.y + vect2.y, vect1.z + vect2.z);
    }

    public static MyVector subVectors (MyVector vect1, MyVector vect2) {

        return new MyVector(vect1.x - vect2.x, vect1.y - vect2.y, vect1.z - vect2.z);
    }

    public static MyVector[] generateVectArray (int n) {

        MyVector[] vectArr = new MyVector[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {

            vectArr[i] = new MyVector(rnd.nextInt(), rnd.nextInt(), rnd.nextInt());
        }

        return vectArr;
    }
}
