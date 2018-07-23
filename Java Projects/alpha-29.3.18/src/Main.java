import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = Integer.parseInt(scan.nextLine());

        long[][] matrix = new long[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i==0&&j==0){
                    matrix[i][j] = 1;
                }
                else if(j==0&&i!=0){
                    matrix[i][j] = 2*matrix[i-1][j];
                }
                else{
                    matrix[i][j] = matrix[i][j-1]*2;
                }
            }
        }
        long sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println(sum);
    }
}