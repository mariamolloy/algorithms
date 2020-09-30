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

    //insertion sort
    Sort insertion = new Sort(magicItems);
    System.out.println("Insertion sort had " + insertion.insertionSort() + " comparisons");

    for (int i = 0; i < insertion.arr.length; ++i) {
      System.out.println(insertion.arr[i] + " ");
    }

    /**System.out.println(Sort.selectionSort(magicItems));
    System.out.println(Sort.insertionSort(magicItems));
    System.out.println(Sort.mergeSort(magicItems));
    System.out.println(Sort.quickSort(magicItems));**/

  }
}
