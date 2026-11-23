package challenges;

// SECTION A: Logic. if, else if, && and ||, and a little math.
// The test is src/test/java/challenges/LogicChallengesTest.java.
// Change only the lines marked YOUR CODE. Each method says what to give back.
// Refresh: Part 06 (if and switch), Part 07 (logical operators), Part 13 (methods).

public class LogicChallenges {

    // How much extra a drink size costs.
    //   'S' or 's' -> 0.0     'M' or 'm' -> 0.50     'L' or 'l' -> 1.00
    //   anything else -> -1.0 (that size does not exist)
    //   sizeUpcharge('M') -> 0.5     sizeUpcharge('l') -> 1.0     sizeUpcharge('X') -> -1.0
    // Returns the extra cost based on the drink size.
    public static double sizeUpcharge(char size) {
        if (size == 'S' || size == 's') {
            return 0.0;
        } else if (size == 'M' || size == 'm') {
            return 0.50;
        } else if (size == 'L' || size == 'l') {
            return 1.00;
        } else {
            return -1.0;
        }

    }

    // Happy hour on a weekday is from hour 14 to hour 16 (2 PM to 4 PM), both included.
    // On the weekend it is longer: hour 12 to hour 17, both included.
    // hour is on a 24-hour clock (0 to 23). Any other hour is never happy hour.
    //   isHappyHour(15, false) -> true     isHappyHour(12, false) -> false
    //   isHappyHour(12, true)  -> true     isHappyHour(25, true)  -> false

    // Checks whether the given hour falls within happy hour.
    public static boolean isHappyHour(int hour, boolean weekend) {
        if (weekend) {
            return hour >= 12 && hour <= 17;
        } else {
            return hour >= 14 && hour <= 16;
        }
    }

    // A loyalty card gets one stamp per drink. Every 10 stamps is one free drink.
    // The card already has stamps, and the customer buys more drinks.
    // Give back how many free drinks they have earned in total.
    // If stamps or bought is below 0, give back 0.
    //   freeDrinks(8, 3)  -> 1     freeDrinks(0, 25) -> 2
    //   freeDrinks(4, 5)  -> 0     freeDrinks(-1, 30) -> 0

    // Calculates how many free drinks were earned from the total stamps.
    public static int freeDrinks(int stamps, int bought) {
        if (stamps < 0 || bought < 0) {
            return 0;
        }

        int totalStamps = stamps + bought;

        return totalStamps / 10;
    }

    // The fewest coins that make the change. Coins are 25, 10, 5 and 1 cents.
    // Use as many quarters as you can, then dimes, then nickels, then pennies.
    // If cents is 0 or less, give back 0.
    //   coinsForChange(30) -> 2  (25 + 5)
    //   coinsForChange(41) -> 4  (25 + 10 + 5 + 1)
    //   coinsForChange(99) -> 9  (3 quarters, 2 dimes, 4 pennies)

    // Calculates the fewest coins needed to make the given amount of change.
    public static int coinsForChange(int cents) {
        if (cents <= 0) {
            return 0;
        }

        int coins = 0;

        coins += cents / 25;
        cents %= 25;

        coins += cents / 10;
        cents %= 10;

        coins += cents / 5;
        cents %= 5;

        coins += cents;

        return coins;
    }
}
