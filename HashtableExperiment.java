import java.sql.Date;
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
        int debugLevel = 0;
        if(args.length == 3) {
            debugLevel = Integer.parseInt(args[2]);
        }

        int size = TwinPrimeGenerator.GenereateTwinPrimes(30, 500);

        LinearProbing testLinear = new LinearProbing(100, size);
        DoubleHashing testDouble = new DoubleHashing(100, size, size-2);

        if (dataSource < 1 || dataSource > 3) {
            System.out.println("Error: Invalid data source. Please input integer value between 1 and 3");
            return;
        }
        if (loadFactor < 0 || loadFactor >= 1) {
            System.out.println("Error: Invalid load factor. Please input decimal value between 0 and 1");
            return;
        }
        if (debugLevel < 0 || debugLevel > 2) {
            System.out.println("Error: Invalid debug level. Please input integer value between 0 and 2");
            return;
        }

        if (dataSource == 1) {
            Random rand = new Random();
            for (int i=0; i < (100*loadFactor); i++) {
                Object obj = rand.nextInt();
                int key = obj.hashCode();
                testLinear.insert(key, obj);
            }
            for (int i=0; i < (100*loadFactor); i++) {
                Object obj = rand.nextInt();
                int key = obj.hashCode();
                testDouble.insert(key, obj);
            }
        }

        if (dataSource == 2) {
            // long current = Date().getTime();
        }

        if (dataSource == 3) {

        }
    }
}