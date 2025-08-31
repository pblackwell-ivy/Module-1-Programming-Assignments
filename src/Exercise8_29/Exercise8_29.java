package Exercise8_29;
import java.util.Scanner;

public class Exercise8_29 {
    /* Prompt the user to enter two 3x3 arrays of integers
    Compare contents of arrays, return true if identical, false if not identical
    Display result message
     */
    public static boolean equals(int[][] m1, int[][] m2) {
        // Method to test if two 3x3 arrays of integers are identical.
        // Assumes arrays to test are both 3 x 3 of integers
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2.length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // declare two 3 x 3 arrays
        // get user input and store in arrays m1 and m2
        // test if array contents are identical and display result

        Scanner input = new Scanner(System.in);
        // declare two arrays for input
        int[][] m1 = new int[3][3];
        int[][] m2 = new int[3][3];

        // input first array
        System.out.print("Enter m1 (a 3 by 3 matrix) row by row: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m1[i][j] = input.nextInt();
            }
        }
        // input second array
        System.out.print("Enter m2 (a 3 by 3 matrix) row by row: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                m2[i][j] = input.nextInt();
            }
        }

        // Compare two arrays and display result
        if (equals(m1, m2)) {
            System.out.println("The two arrays are identical");
        } else {
            System.out.println("The two arrays are not identical");
        }

        // comment out these two lines used to test program development
        // displayArray(m1);
        // displayArray(m2);
    }

    /* public static void displayArray(int[][] m) {
        // outputs m array contents
        System.out.println("Array contents");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
     */
}
