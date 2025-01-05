public class pascalPyramid {
    public static void main(String args[]) {
        int n=7;
        int l=2*n-1;
        int[][] arr=new int[n][l];
        int rows=0;
        int columns=0;

        while(rows==0 && columns<l) {
            if(rows==0 && columns==l/2) {
                arr[rows][columns]=1;
                columns++;
            } else {
                arr[rows][columns]=0;
                columns++;
            }
        }
        System.out.println();

        for(int i=1; i<n; i++) {
            for(int j=0; j<l; j++) {
                if(j!=0 && j!=l-1) {
                    arr[i][j]=arr[i-1][j-1]+arr[i-1][j+1];
                } else if(j==0 && j!=l-1){
                    arr[i][j]=arr[i-1][j+1];
                } else {
                    arr[i][j]=arr[i-1][j-1];
                }
            }
            System.out.println();
        }

        for(int i=0; i<n; i++) {
            for (int j = 0; j < l; j++) {
                if(arr[i][j]==0) {
                    System.out.print(" ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}


