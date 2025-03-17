import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Hashtable;
import java.util.Random;
import java.time.LocalDate; // Represents a date (year, month, day)
import java.time.LocalTime; // Represents a time (hour, minute, second, nanoseconds)
import java.time.LocalDateTime; // Represents both a date and a time
import java.time.format.DateTimeFormatter; // For formatting and parsing dates and times

/**
 * This class is the tester for the Hashtable and its assorted elements. It
 * takes user input from the command line
 * 
 * @author Troy Berhow
 */
public class HashtableExperiment {
    /**
     * Takes user input and puts the content of a file into a hash table and
     * displays the results.
     * 
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
        int numOfElems = 0;
        if (args.length == 3) {
            debugLevel = Integer.parseInt(args[2]);
        }

        int prime = TwinPrimeGenerator.GenereateTwinPrimes(30, 500);
        int size = 100;

        LinearProbing testLinear = new LinearProbing(size, prime);
        DoubleHashing testDouble = new DoubleHashing(size, prime, prime - 2);

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

        if (debugLevel == 2) {
            if (dataSource == 1) {
                Random rand = new Random();
                for (int i = 0; i < (size * loadFactor); i++) {
                    Object obj = rand.nextInt();
                    int key = obj.hashCode();
                    testLinear.insert(key, obj);
                    if (testLinear.table[key] == null) {

                    } else if (testLinear.table[key].getStatus() != 0) {
                        System.out.println(testLinear.table[key].toString() + ", insert succesful!");
                    } else {
                        System.out.println(testLinear.table[key].toString() + ", inserted duplicate.");
                    }
                    testDouble.insert(key, obj);

                    if (testDouble.table[key] == null) {

                    } else if (testDouble.table[key].getStatus() != 0) {
                        System.out.println(testDouble.table[key].toString() + ", insert succesful!");
                    } else {
                        System.out.println(testDouble.table[key].toString() + ", inserted duplicate.");
                    }
                    numOfElems++;
                }
            }

            if (dataSource == 2) {
                long current = System.currentTimeMillis();
                for(int i=0; i < size; i++) {
                    current += 1000;
                    Date date = new Date(current);
                    int key = date.hashCode();
                    HashObject obj = new HashObject(date, key);
                    testLinear.insert(obj.hashCode(), obj);
                    if (testLinear.table[key] == null) {

                    } else if (testLinear.table[key].getStatus() != 0) {
                        System.out.println(testLinear.table[key].toString() + ", insert succesful!");
                    } else {
                        System.out.println(testLinear.table[key].toString() + ", inserted duplicate.");
                    }
                    testDouble.insert(obj.hashCode(), obj);
                    if (testDouble.table[key] == null) {

                    } else if (testDouble.table[key].getStatus() != 0) {
                        System.out.println(testDouble.table[key].toString() + ", insert succesful!");
                    } else {
                        System.out.println(testDouble.table[key].toString() + ", inserted duplicate.");
                    }
                    
                    numOfElems++;
                }
            }

            if (dataSource == 3) {
                String filepath = "C:\\Users\\skysk\\CS321\\p3-hashtables-maximumove\\wordlist.txt";
                try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        Object obj = line;
                        int key = line.hashCode();
                        testLinear.insert(key, obj);
                        if (testLinear.table[key] == null) {

                        } else if (testLinear.table[key].getStatus() != 0) {
                            System.out.println(testLinear.table[key].toString() + ", insert succesful!");
                        } else {
                            System.out.println(testLinear.table[key].toString() + ", inserted duplicate.");
                        }

                        testDouble.insert(key, obj);
                        if (testDouble.table[key] == null) {

                        } else if (testDouble.table[key].getStatus() != 0) {
                            System.out.println(testDouble.table[key].toString() + ", insert succesful!");
                        } else {
                            System.out.println(testDouble.table[key].toString() + ", inserted duplicate.");
                        }

                        numOfElems++;
                    }
                } catch (IOException e) {
                    System.err.println("Error reading file: wordlist.txt");
                }
            }
        }

        else {
            if (dataSource == 1) {
                Random rand = new Random();
                for (int i = 0; i < (size * loadFactor); i++) {
                    Object obj = rand.nextInt();
                    int key = obj.hashCode();
                    testLinear.insert(key, obj);
                    testDouble.insert(key, obj);
                    numOfElems++;
                }
            }

            if (dataSource == 2) {
                long current = System.currentTimeMillis();
                for(int i=0; i < size; i++) {
                    current += 1000;
                    Date date = new Date(current);
                    int key = date.hashCode();
                    HashObject obj = new HashObject(date, key);
                    testLinear.insert(obj.hashCode(), obj);
                    testDouble.insert(obj.hashCode(), obj);
                    numOfElems++;
                }
            }

            if (dataSource == 3) {
                String filepath = "C:\\Users\\skysk\\CS321\\p3-hashtables-maximumove\\wordlist.txt";
                try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        Object obj = line;
                        int key = line.hashCode();
                        testLinear.insert(key, obj);
                        testDouble.insert(key, obj);
                        numOfElems++;
                    }
                } catch (IOException e) {
                    System.err.println("Error reading file: wordlist.txt");
                }
            }

            if (debugLevel == 0) {
                int totalDups = 0;
                int totalProbes = 0;
                for (int i = 0; i < size; i++) {
                    if (testLinear.table[i] == null) {

                    } else {
                        totalDups += testLinear.table[i].frequency;
                        totalProbes += testLinear.table[i].probeCount;
                    }
                }
                int avgProbe = totalProbes / numOfElems;
                System.out.println("Using Linear Probing");
                System.out.println("HashtableExperiment: size of the hash table is " + prime);
                System.out.println("Inserted " + numOfElems + ", of which " + totalDups + " are duplicates");
                System.out.println("Avg. no. of probes = " + avgProbe);

                totalDups = 0;
                totalProbes = 0;
                for (int i = 0; i < size; i++) {
                    if (testDouble.table[i] == null) {

                    } else {
                        totalDups += testDouble.table[i].frequency;
                        totalProbes += testDouble.table[i].probeCount;
                    }
                }
                avgProbe = totalProbes / numOfElems;
                System.out.println("Using Linear Probing");
                System.out.println("HashtableExperiment: size of the hash table is " + prime);
                System.out.println("Inserted " + numOfElems + ", of which " + totalDups + " are duplicates");
                System.out.println("Avg. no. of probes = " + avgProbe);
            }

            else if (debugLevel == 1) {
                int totalDups = 0;
                int totalProbes = 0;
                for (int i = 0; i < size; i++) {
                    if (testLinear.table[i] == null) {

                    } else {
                        totalDups += testLinear.table[i].frequency;
                        totalProbes += testLinear.table[i].probeCount;
                    }
                }
                int avgProbe = totalProbes / numOfElems;
                System.out.println("Using Linear Probing");
                System.out.println("HashtableExperiment: size of the hash table is " + prime);
                System.out.println("Inserted " + numOfElems + ", of which " + totalDups + " are duplicates");
                System.out.println("Avg. no. of probes = " + avgProbe);

                totalDups = 0;
                totalProbes = 0;
                for (int i = 0; i < size; i++) {
                    if (testDouble.table[i] == null) {

                    } else {
                        totalDups += testDouble.table[i].frequency;
                        totalProbes += testDouble.table[i].probeCount;
                    }
                }
                avgProbe = totalProbes / numOfElems;
                System.out.println("Using Linear Probing");
                System.out.println("HashtableExperiment: size of the hash table is " + prime);
                System.out.println("Inserted " + numOfElems + ", of which " + totalDups + " are duplicates");
                System.out.println("Avg. no. of probes = " + avgProbe);

                testLinear.dumpToFile("linearProbingDump");
                testDouble.dumpToFile("doubleHashingDump");
            }
        }
    }
}