package Exercise6_9;

public class FeetMetersConversions {
    /*
    Write a class that contains the following two methods: footToMeter and meterToFoot
    Output a table of 4 columns where
        Col 1: feet from 1.0 to 10.0 by 1.0 feet increments
        Col 2: Conversion of col 1 to meters to 3 decimal places
        Col 3: meters from 20.0 to 65.0 by 5 meter increments
        Col 4: conversion of Col 3 to feet to 3 decimal places
     */

    public static void main(String[] args) {
        /* Method summary:
           1. Define & Display header
           2. Create conversionTable
           3. Populate conversionTable using conversion methods
           4. Display formatted contents of conversionTable
        */

        // 1. Define & display header (44 characters per row from assignment image)
        final String HEADER = "Feet    Meters              Meters      Feet";
        final String DIVIDER = "--------------------------------------------";
        System.out.println(HEADER);
        System.out.println(DIVIDER);

        // 2. Create ConversionTable to hold calculated values
        final int ROWS = 10;
        final int COLS = 4;
        double [][] conversionTable = new double[ROWS][COLS];

        // 3. Populate the conversionTable with a loop using footToMeter and meterToFoot methods
        for (int r = 0; r < ROWS; r++) {
            double feet = 1 + r;  // 1.0 to 10.0 by 1.0
            double meters = 20.0 + (5.0 * r); // 20.0 to 65.0 by 5.0
            conversionTable[r][0] = feet;
            conversionTable[r][1] = footToMeter(feet);
            conversionTable[r][2] = meters;
            conversionTable[r][3] = meterToFoot(meters);
        }

        // 4. Display the table using a looping printf
        for (int r = 0; r < ROWS; r++) {
            System.out.printf(
                    "%4.1f" +  // Feet: ends at col 3 (width 4)
                    "%10.3f" +  // Meters (from feet): ends at col 13 (width 10)
                    "%20.1f" +  // Meters: ends at col 33 (width 20)
                    "%10.3f%n", // Feet (from meters): ends at col 43 (width 10)
                    conversionTable[r][0],
                    conversionTable[r][1],
                    conversionTable[r][2],
                    conversionTable[r][3]);
        }
    }
    public static double footToMeter(double foot) {
        // meter = 0.305 * foot
        return 0.305 * foot;
    }
    public static double meterToFoot(double meter) {
        // foot = 3.279 * meter
        return 3.279 * meter;
    }
}