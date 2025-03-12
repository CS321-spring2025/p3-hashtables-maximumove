public class TwinPrimeGenerator {

    public TwinPrimeGenerator() {

    }

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