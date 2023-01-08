package oopprinciples.abstraction;

public abstract class Shape {
    String color;

    // phương thức trừu tượng
    abstract double area();

    public abstract String toString();

    public Shape(String color) {
        System.out.println("Call shape");
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
