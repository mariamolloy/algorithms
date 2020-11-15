import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){

    }

    public static String[] getMagicItems(String address){
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

    public static String[] getGraphs(String address){
        //create a new arraylist of magic items
        ArrayList<String> tempGraph = new ArrayList<String>();
        try {
            //locate the file we wanna scan in
            FileInputStream input = new FileInputStream(address);
            //file we wanna scan
            Scanner scan = new Scanner(input);

            //returns true if there is another line to read
            while (scan.hasNextLine()) {

                //returns the next line and adds it tempMagicItems and increases file line counter
                String item = scan.nextLine().toUpperCase();
                tempGraph.add(item);
            }
            //close the scanner
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tempGraph.toArray(new String[0]);
    }
}
