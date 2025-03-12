/**
 * This class holds a function to generate twin primes.
 * @author Troy Berhow
 */
public class TwinPrimeGenerator {

    /**
     * Finds a pair of twin primes between the min and max parameters.
     * @param int minimum number
     * @param int maximum number
     * @return larger of the two twin primes
     */
    public static int GenereateTwinPrimes(int min, int max) {
        if (min >= max) {
            return 0;
        }
        for (int i=min; i < max; i++) {
            if (isPrime(i) && isPrime(i + 2)) {
                return i+2;
            }
        }
        return -1;
    }

    /**
     * Checks to see if a given number is a prime number.
     * @param int number to check
     * @return true if prime, false if not
     */
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}