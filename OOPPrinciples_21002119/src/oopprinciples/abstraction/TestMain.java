package oopprinciples.abstraction;

public class TestMain {
    public static void main(String[] args) {
        Shape shape1 = new Circle("Blue", 4);
        Shape shape2 = new Rectangle("Black", 5, 9);

        System.out.println(shape1.toString());
        System.out.println(shape2.toString());
    }
}
