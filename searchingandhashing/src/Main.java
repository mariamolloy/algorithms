import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static String[] magicArray(String address){
        //create a new arraylist of magic items
        ArrayList<String> tempMagicItems = new ArrayList<String>();
        int fileLines = 0;

        try {
            //locate the file we wanna scan in
            FileInputStream input = new FileInputStream(address);
            //file we wanna scan
            Scanner scan = new Scanner(input);

            //returns true if there is another line to read
            while (scan.hasNextLine()) {

                //returns the next line and adds it tempMagicItems and increases file line counter
                String item = scan.nextLine().toUpperCase();
                tempMagicItems.add(item);
                fileLines++;
            }
            //close the scanner
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tempMagicItems.toArray(new String[0]);
    }


    public static void main (String[] args){
        String[] magicItems = magicArray("magicitems.txt");
        String[] magic42 = find42(magicArray("magicitems.txt"));

        int linearAvgComp = 0;
        for (int i = 0; i < magic42.length; i++){
            System.out.println(magic42[i]); }
      /*  }
        Search linear = new Search(magicItems);
        for (int i = 0; i < magic42.length; i++){
            String current = magic42[i];
            System.out.println(linear.linearSearch(current) + " with " + linear.comparisons + " comparisons");
            linearAvgComp += linear.comparisons;
        }
        linearAvgComp = linearAvgComp / magic42.length;
        System.out.println("Linear Search had an average of " + linearAvgComp + " comparisons"); */

        Search binary = new Search(magicItems);
        int binaryAvgComp = 0;
        for (int j = 0; j < magic42.length; j++){
            String current = magic42[j];
            binary.init();
            System.out.println(binary.binarySearch(current, 0, magicItems.length) + " with " + binary.comparisons + " comparisons");
            binaryAvgComp += binary.comparisons;
        }
        binaryAvgComp = binaryAvgComp / magic42.length;
        System.out.println("Binary Search had an average of " + binaryAvgComp + " comparisons");
        
    }

    //make this return a random list of 42 elements
    public static String[] find42 (String[] arr){
      // Queue allItems = new Queue();
        int size = arr.length;
        String[] randomItems = new String[42];
        for (int i = 0; i < 42; i++){
            Random r = new Random();
            int index = r.nextInt(size);
                while(arr[index] == null){
                    index = r.nextInt(size);
                }
                randomItems[i] = arr[index];
                arr[index] = null;
        }
        return randomItems;
    }
}
