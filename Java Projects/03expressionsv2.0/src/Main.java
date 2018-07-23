import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] digits = Arrays.stream(in.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        int number = Integer.parseInt(in.nextLine());
        int result =countExpressions(digits, number, 1, digits[0], 1, 0, false);

        System.out.println(result);
    }

    static int countExpressions(int[] digits, int expectedResult, int index, int currentNumber, int currentProduct, int currentSum, boolean negative){
        if (index == digits.length)
        {
            currentProduct *= currentNumber;
            currentSum += negative ? -currentProduct : currentProduct;

            if (currentSum == expectedResult)
            {
                return 1;
            }

            return 0;
        }

        var result = 0;
        var nextSum = currentSum + currentProduct * currentNumber * (negative ? -1 : 1);
        result += countExpressions(digits, expectedResult, index + 1, digits[index], 1, nextSum, false);
        result += countExpressions(digits, expectedResult, index + 1, digits[index], 1, nextSum, true);

        var nextProduct = currentProduct * currentNumber;
        result += countExpressions(digits, expectedResult, index + 1, digits[index], nextProduct, currentSum, negative);

        if (currentNumber != 0)
        {
            var nextNumber = currentNumber * 10 + digits[index];
            result += countExpressions(digits, expectedResult, index + 1, nextNumber, currentProduct, currentSum, negative);
        }

        return result;
    }

    
}
