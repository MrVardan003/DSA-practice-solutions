public class ArrayToStringConversion {

    public static String[] operations(int[] arr, int n) {
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = String.valueOf(arr[i]);
        }
        return str;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        String[] result = operations(arr, n);

        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }
}

