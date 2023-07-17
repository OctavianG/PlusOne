import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    //    Input: digits = [1,2,3]
    //    Output: [1,2,4]
    //    Explanation: The array represents the integer 123.
    //    Incrementing by one gives 123 + 1 = 124.
    //    Thus, the result should be [1,2,4].
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        // while the digit is 9 it is converted to 0
        // when the digit != 9 it is incremented by one and the code ends returning digits[]
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        // if the digits[] isn't returned in the for loop
        // => there are only digits == 9

        // creating new int[] with length equals to digits.length + 1
        int[] newDigits = new int[n + 1];

        //the first digit must be 1 since there were only digit == 9
        newDigits[0] = 1;

        return newDigits;
    }

    public static int[] plusOneSecond(int[] digits) {
        int n = digits.length;

        // Increment the last digit by one
        digits[n - 1] += 1;

        // Check for carry-over and propagate it if necessary
        for (int i = n - 1; i > 0 && digits[i] == 10; i--) {
            digits[i] = 0;

            // if digits[i - 1] == 9 it will continue the for loop
            digits[i - 1] += 1; // if digits[i - 1] == 9 -> +1 == 10
        }

        // If the first digit is 10, create a new array and set the first element to 1
        if (digits[0] == 10) {
            int[] newDigits = new int[n + 1];
            newDigits[0] = 1;
            return newDigits;
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{9, 9, 9};
        System.out.println(Arrays.toString(plusOne(digits)));

        int[] digitsSecond = new int[]{9, 9, 9};
        System.out.println(Arrays.toString(plusOneSecond(digitsSecond)));
    }
}