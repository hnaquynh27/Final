package oopprinciples.abstraction;

class Circle extends Shape {
    double radius;

    public Circle(String color, double radius) {
        super(color);
        System.out.println("Call circle");
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "The color of the circle is " + super.getColor() + " and its area is : " + area();
    }
}
