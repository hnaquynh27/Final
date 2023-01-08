package oopprinciples.encapsulation;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee em1 = new Employee();
        em1.setName("Nguyen Van A");
        em1.setId("01");
        System.out.println(em1.getName());
        System.out.println(em1.getId());

        Employee em2 = new Employee();
        em2.setId("02");
        em2.setName("Nguyen Thi B");
        System.out.println(em2.getId());
    }
}
