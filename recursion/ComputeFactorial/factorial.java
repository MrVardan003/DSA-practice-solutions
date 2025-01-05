public class factorial {

    public static long facto(int n) {
        if(n==0) {
            return 1;
        } else {
            return n*facto(n-1);
        }
    }

    public static void main(String args[]) {
        int n=5;
        long result=facto(n);
        System.out.println("The fatorial of "+ n +" is "+ result +".");
    }
}
