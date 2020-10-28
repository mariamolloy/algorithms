import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
        String[] magic42 = find42(magicItems);

        Search project3 = new Search(magicItems);
        for (int i = 0; i < magic42.length; i++){
            String current = magic42[i];
            System.out.println(project3.linearSearch(current));
        }
        
    }

    //make this return a random list of 42 elements
    public static String[] find42 (String[] arr){
        int size = arr.length;
        if (size >= 42){
            for (int i = 0; i < size; i++){

            }
        }
    }
}
