public class HashTable {
    private static final String FILE_NAME = "magicitems.txt";
    private static final int LINES_IN_FILE = 666;
    private static final int HASH_TABLE_SIZE = 250;
    private static LinkedList[] list = new LinkedList[HASH_TABLE_SIZE];
    public static int comparisons = 0;

    //create table and initialize it all to null
    public HashTable() {
        for (int i = 0; i < HASH_TABLE_SIZE; i++){
            list[i] = null;
        }
    }

    //method for adding to our hash table
    //key = what you want to add
    public static void addToTable(String key){
        int code = makeHashCode(key);
        //if this location is empty, we need to create a linked list
        if (list[code] == null){
            LinkedList newList = new LinkedList();
            newList.addTo(newList, key);
            list[code] = newList;
        } else { //otherwise we can just add to the linked list already there
            list[code].addTo(list[code], key);
        }
    }

    //method for retrieving an element from the hash table
    //key = the element we want to find
    public static boolean getFromTable(String key){
        comparisons = 0;
        int code = makeHashCode(key);
        if (list[code] != null){ //if location isnt null we must go through linked list to look for the key
            Node currentNode = list[code].head;
            while(currentNode != null){
                comparisons++;
                if (currentNode.data.equalsIgnoreCase(key)){
                    return true;
                } else {
                    currentNode = currentNode.pointer;
                }
            }
            return false;
        } else { //if its null the element isnt in the list
            return false;
        }
    }

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

}
