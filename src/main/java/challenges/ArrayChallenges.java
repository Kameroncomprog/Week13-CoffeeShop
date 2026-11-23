package challenges;

// SECTION C: Arrays. for loops over an array, and a 2D array.
// The test is src/test/java/challenges/ArrayChallengesTest.java.
// Change only the lines marked YOUR CODE. Each method says what to give back.
// Refresh: Part 08 (for loops and nested loops), Part 10 (arrays and 2D arrays).

public class ArrayChallenges {

    // The lowest price in the array. If the array is empty, give back 0.0.
    //   cheapest({3.25, 2.00, 4.50}) -> 2.0
    //   cheapest({5.0})              -> 5.0
    //   cheapest({})                 -> 0.0
    // Finds and returns the lowest price in the array.
    public static double cheapest(double[] prices) {
        if (prices.length == 0) {
            return 0.0;
        }
        double lowest = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            }
        }
        return lowest;
    }

    // How many prices are MORE than limit? (Equal to limit does not count.)
    //   countOver({3.25, 2.00, 4.50}, 3.00) -> 2
    //   countOver({3.25, 2.00, 4.50}, 4.50) -> 0
    // Counts how many prices are greater than the limit.
    public static int countOver(double[] prices, double limit) {
        int count = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > limit) {
                count++;
            }
        }
        return count;
    }

    // Each row is one day. Each number in the row is how many cups were sold in one hour.
    // Give back the row number (starting at 0) of the day that sold the most cups in total.
    // If two days tie, give back the first one. If there are no rows, give back -1.
    //   busiestDay({{5, 9}, {20, 1}, {3, 3}}) -> 1    (row totals are 14, 21, 6)
    //   busiestDay({{4, 4}, {8}})             -> 0    (a tie: 8 and 8, so the first)

    // Finds the day with the highest total number of cups sold.
    public static int busiestDay(int[][] cups) {
        if (cups.length == 0) {
            return -1;
        }

        int busiest = 0;
        int highestTotal = 0;

        for (int i = 0; i < cups.length; i++) {
            int total = 0;

            for (int j = 0; j < cups[i].length; j++) {
                total += cups[i][j];
            }

            if (i == 0 || total > highestTotal) {
                highestTotal = total;
                busiest = i;
            }
        }
        return busiest;
    }
}
