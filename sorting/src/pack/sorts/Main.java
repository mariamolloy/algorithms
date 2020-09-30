package pack.sorts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

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

    String[] allMagicItems = tempMagicItems.toArray(new String[0]);
    return allMagicItems;
  }


  public static void main(String[] args){
    String[] magicItems = magicArray("magicitems.txt");
    /*for (int i = 0; i < magicItems.length; i++) {
      System.out.println(magicItems[i] + " ");
    }*/

    //insertion sort
    Sort insertion = new Sort(magicItems);
    System.out.println("Insertion sort had " + insertion.insertionSort() + " comparisons");

    Sort selection = new Sort(magicItems);
    System.out.println("Selection sort had " + selection.selectionSort() + " comparisons");

    for (int i = 0; i < selection.arr.length; i++) {
      System.out.println(selection.arr[i] + " ");
    }

  }
}
