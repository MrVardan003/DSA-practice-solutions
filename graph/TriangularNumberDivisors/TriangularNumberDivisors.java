import java.util.Scanner;

public class TriangularNumberDivisors {
    
    public static int countDivisors(int number) {
        int divisors = 0;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                divisors += (i == number / i) ? 1 : 2;
            }
        }
        return divisors;
    }
    
    public static void findTriangularNumber(int n) {
        int index = 1;
        int triangularNumber = 0;
        while (true) {
            triangularNumber += index;
            int divisors = countDivisors(triangularNumber);
            if (divisors > n) {
                System.out.println(triangularNumber);
                break;
            }
            index++;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            findTriangularNumber(n);
        }
        input.close();
    }
}
