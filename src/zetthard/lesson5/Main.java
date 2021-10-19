package zetthard.lesson5;

public class Main {
    public static void main(String[] args) {

        MyVector vect1 = new MyVector(2.5, 5.0,5.0);
        MyVector vect2 = new MyVector(3.0, 2.5,4.0);
        System.out.println("Length of a given vector:");
        System.out.println(vect1.getLength());
        System.out.println();
        System.out.println("Vector scalar product:");
        System.out.println(MyVector.getScalar(vect1, vect2));
        System.out.println();
        System.out.println("Vector cross product:");
        System.out.println(MyVector.getVProduct(vect1, vect2));
        System.out.println();
        System.out.println("Cosine between two given vectors:");
        System.out.println(MyVector.getCosine(vect1, vect2));
        System.out.println();
        System.out.println("Sum for two vectors:");
        System.out.println(MyVector.addVectors(vect1, vect2));
        System.out.println();
        System.out.println("Diff of two vectors:");
        System.out.println(MyVector.subVectors(vect1, vect2));
        System.out.println();
        System.out.println("Array of n random vectors:");
        MyVector[] arr1 = MyVector.generateVectArray(4);
        for (var vector:
             arr1) {
            System.out.println(vector);
        }
    }
}
