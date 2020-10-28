public class Hashing {
    private static final String FILE_NAME = "magicitems.txt";
    private static final int LINES_IN_FILE = 666;
    private static final int HASH_TABLE_SIZE = 250;

    private static int makeHashCode(String str) {
        str = str.toUpperCase();
        int length = str.length();
        int letterTotal = 0;

        // Iterate over all letters in the string, totalling their ASCII values.
        for (int i = 0; i < length; i++) {
            char thisLetter = str.charAt(i);
            int thisValue = (int)thisLetter;
            letterTotal = letterTotal + thisValue;

            // Test: print the char and the hash.
                            /*
           System.out.print(" [");             System.out.print(thisLetter);
           System.out.print(thisValue);
          System.out.print("] ");
            // */
        }

        // Scale letterTotal to fit in HASH_TABLE_SIZE.
        int hashCode = (letterTotal * 1) % HASH_TABLE_SIZE;  // % is the "mod" operator
        // TODO: Experiment with letterTotal * 2, 3, 5, 50, etc.
        return hashCode;
    }


    public static void makeHashTable(){

    }
    public static void addToTable(int code){

    }
    public static String getFromTable(int code){

    }
}
