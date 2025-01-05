public class fibonacci {

    public static int fibo(int n) {
        if(n<=1) return n;
        } else {
            return fibo(n-1)+fibo(n-2);
        }
    }

    public static void main(String args[]) {
        int a=7;
        int result=fibo(a);
        System.out.println("The fibonacci of "+ a +" is "+ result +".");
        System.out.print("The fibonacci sequence of "+a+" is :");
        for(int i=0; i<=a; i++) {
            System.out.print(fibo(i)+" ");
        }
    }
}
