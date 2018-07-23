import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int[] dimensions = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = in.nextInt();
        int m = in.nextInt();
        long result = 0;

        System.out.println(result);

    }

    static long getValue(int row, int col) {
        return (1 + 3 * (row + col));
    }

//    static BigInteger getValue(int row, int col) {
//        BigInteger formula = BigInteger.ZERO;
//        formula = formula.add(BigInteger.valueOf(1 + 3 * (row + col)));
//        return formula;
//    }
}
