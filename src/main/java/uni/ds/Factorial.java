package uni.ds;

public class Factorial {
    public static int recursiveFactorial(int n) {
        if (n == 0) {
            return 1;
        }

        return n * recursiveFactorial(n - 1);
    }

    public static int factorial(int n) {
        int result = 1;

        while (n > 0) {
            result *= n;
            n--;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
