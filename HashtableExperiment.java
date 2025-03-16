import java.util.Hashtable;
import java.util.Random;

/**
 * This class is the tester for the Hashtable and its assorted elements. It takes user input from the command line
 * @author Troy Berhow
 */
public class HashtableExperiment {
    /**
     * Takes user input and puts the content of a file into a hash table and displays the results.
     * @param String[] command line arguments
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Arguments missing");
            return;
        }
        int dataSource = Integer.parseInt(args[0]);
        long loadFactor = Integer.parseInt(args[1]);
        if(args.length == 3) {
            int debugLevel = Integer.parseInt(args[2]);
        }

        int size = TwinPrimeGenerator.GenereateTwinPrimes(30, 500);

        LinearProbing testLinear = new LinearProbing(100, size);
        DoubleHashing testDouble = new DoubleHashing(100, size, size-2);

        if (dataSource == 1) {
            Random rand = new Random();
            for (int i=0; i < (100*loadFactor); i++) {
                Object obj = rand.nextInt();
                int key = obj.hashCode();
                testLinear.insert(key, obj);
            }
        }
    }
}