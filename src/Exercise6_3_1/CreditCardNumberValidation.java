package Exercise6_3_1;
import java.util.Scanner;

public class CreditCardNumberValidation {
    /* pseudocode summary
    1. Get nput as long integer
    2. If valid number, then output valid, else output invalid

     */
    public static void main(String[] args) {
        // NOTE: This program assumes the user enters a valid long integer.
        // If the user enters a string or a number larger than a long, a runtime error will occur

        // get credit card number as long integer from user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your credit card number as a long integer: ");
        long ccNumber = input.nextLong();

        // test if credit card number entered is valid
        if (isValidCCNumber(ccNumber)) {
            System.out.println(ccNumber + " is a valid credit card number");
        } else {
            System.out.println(ccNumber + " is an invalid credit card number");
        }
    }

    public static boolean isValidCCNumber(long number) {
        /* test if valid credit card number
            1. Check if valid length
            2. Check if valid prefix
            3. Check Luhn algorithm
         */

        // 1. check if valid length (13 to 16 digits)
        int numLength = getNumLength(number);
        if (numLength < 13 || numLength > 16) {
            return false;
        }

        // 2. check if valid prefix: 4 (Visa), 5 (MasterCard), 37 (Amex), 6 (Discover)
        boolean validPrefix = prefixMatched(number, 4) ||
                prefixMatched(number, 5) ||
                prefixMatched(number, 37) ||
                prefixMatched(number, 6);
        if (!validPrefix) return false;

        // 3. Check Luhn algorithm
        return calculateLuhnSum(number) % 10 == 0;
    }

    public static boolean prefixMatched(long number, int prefix) {
        /* returns whether a number begins with prefix
        get the length of the prefix, then truncate the number by that length, and compares that to the prefix
         */
        int prefixLength = getNumLength(prefix);
        long numPrefix = getPrefix(number, prefixLength);
        return prefix == numPrefix;
    }

    public static int getNumLength(long number) {
        /* return the number of digits in a given number
        if number == 0, returns 1 (since "0" is one digit
        if number < 0, uses absolute value to ignore sign
        logic:
        1. repeatedly divide number by 10 and counting how many times until it reaches 0;
        2. Returns the count which is the number of digits
        */
        if (number == 0) return 1;
        int digitCount = 0;
        long absNumber = Math.abs(number); // ignore sign
        while (absNumber > 0) {
            absNumber /= 10;
            digitCount++;
        }
        return digitCount;
    }

    public static long getPrefix(long number, int prefixLength) {
        /* returns the first prefixLength digits of the number
        Assumes:
            number has already been validated to have 13 to 16 digits
            prefix length will only be 1 or 2
         */
        int length = getNumLength(number);
        for (int i =  0; i < length - prefixLength; i++){
            number /= 10;
        }
        return number;
    }

    public static int calculateLuhnSum(long number) {
        // move through the number, one digit at a time, from right to left
        // double the value of every second digit from right
        // if the doubling > than 9, subtract 9 from it (equivalent to adding digits together)
        // keep a running total of doubling or doubling - 9 for every second digit
        // add doubled results to running total
        // add non-doubled (odd-placed) digits to running total
        // return the running total
        int sumOfDigits = 0;
        int position = 1;
        while (number > 0) {
            int digit = (int)(number % 10);
            if (position % 2 == 0) { // even position
                int doubled = digit * 2;
                if (doubled >= 10) {
                    doubled = doubled - 9;
                }
                sumOfDigits += doubled;
            } else { // odd position
                sumOfDigits += digit;
            }
            number /= 10;
            position++;
        }
        // comment out next statement used for testing
        // System.out.println("The Luhn sum is " + sumOfDigits);
        return sumOfDigits;
    }
}