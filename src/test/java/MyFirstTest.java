import org.junit.jupiter.api.Test;

public class MyFirstTest {
    private String name = "Gospodin";

    @Test
    public void firstTest() {
        System.out.println("Hello, corona!");

        int sum = sumTwoDigits(15, 45);
        sumTwoDigits(sum, 15);
        System.out.println("And the sum is: " + sum + " and bla bla bla");

        System.out.println(sumTwoDigits(9, 13));

           }

    private int sumTwoDigits(int a, int b) {
        int c = a + b;
        return c;
    }

}
