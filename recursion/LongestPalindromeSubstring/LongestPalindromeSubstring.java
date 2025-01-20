public class LongestPalindromeSubstring {

    static int max(int x, int y) {
        return (x>y) ? x:y;
    }

    static int findLongest(String str, int i, int j) {
        if(i>j) {
            return 0;
        } else if(i==j) {
            return 1;
        } else if(str.charAt(i)==str.charAt(j)) {
            return 2+ findLongest(str, i+1, j-1);
        } else {
            return max(findLongest(str, i+1, j), findLongest(str, i, j-1));
        }

    }

    static int palinLength(String str) {
        return findLongest(str, 0, str.length()-1);
    }

    public static void main(String args[]) {
        String str="AAAAABAA";
        int length=palinLength(str);
        System.out.println(length);
    }
}
