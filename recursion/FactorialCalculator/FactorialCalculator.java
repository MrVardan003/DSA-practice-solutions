public class FactorialCalculator {

    public static long facto(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * facto(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        long result = facto(n);
        System.out.println("The factorial of " + n + " is " + result + ".");
    }
}
