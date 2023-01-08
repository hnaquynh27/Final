package oopprinciples.polymorphism;

public class Kitten extends Cat{
    public static void main(String[] args) {
        Animal meo = new Kitten();
        meo.speak();
    }

    // Vì Kitten không ghi đè phương thức speak() nên phương thức speak() của lớp Cat được gọi
}
