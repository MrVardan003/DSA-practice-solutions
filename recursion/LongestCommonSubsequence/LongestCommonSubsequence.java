public class Subsequence {

    int algo(String X, String Y, int m, int n) {
        if(m==0 || n==0) {
            return 0;
        } else if(X.charAt(m-1)== Y.charAt(n-1)) {
            return 1+ algo(X, Y, m-1, n-1);
        } else {
            return Math.max(algo(X, Y, m, n-1), algo(X, Y, m-1, n));
        }
    }

    public static void main(String[] args) {
        Subsequence lcs= new Subsequence();

        String X= "AHUDYEKGOS";
        String Y= "OPUDXSIELFYOS";
        int m= X.length();
        int n= Y.length();

        int tl= lcs.algo(X, Y, m, n);
        System.out.println(tl);
    }
}
