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

        int size = magicItems.length;

        int linearAvgComp = 0;
     /*   for (int i = 0; i < magic42.length; i++){
            System.out.println(magic42[i]);
        } */
        //new linear search
        Search linear = new Search(magicItems);
        //go through array of 42 and search for each element
        for (int i = 0; i < magic42.length; i++){
            String current = magic42[i];
            System.out.println(linear.linearSearch(current) + " & " + linear.comparisons);
            linearAvgComp += linear.comparisons;
        }
        linearAvgComp = linearAvgComp / magic42.length;
        System.out.println("Linear Search finished with an average of " + linearAvgComp + " comparisons");


        Search binary = new Search(magicItems);
        binary.mergeSort(0, size - 1);
        int binaryAvgComp = 0;
        //go through array of 42 and search for each element
        for (int j = 0; j < magic42.length; j++){
            String current = magic42[j];
            binary.init();
                System.out.println(magicItems[binary.binarySearch(current, 0, size - 1)] + " & " + binary.comparisons);
                binaryAvgComp += binary.comparisons;
        }
        binaryAvgComp = binaryAvgComp / magic42.length;
        System.out.println("Binary Search finished with an average of " + binaryAvgComp + " comparisons");

        HashTable myHash = new HashTable();
        int hashAvgComp = 0;
        for (int k = 0; k < magicItems.length; k++){
            myHash.addToTable(magicItems[k]);
        }

        for (int l = 0; l < magic42.length; l++){
            if(myHash.getFromTable(magic42[l])){
                System.out.println(magic42[l] + " & " + myHash.comparisons);
                hashAvgComp++;
            }else {
                System.out.println("not found");
            }
        }
        hashAvgComp = hashAvgComp / magic42.length;
        System.out.println("Hashing finished with an average of " + hashAvgComp + " comparisons");
    }

    //function returns random 42 elements in an array
    public static String[] find42 (String[] arr){
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
