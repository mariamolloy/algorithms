package pack.elemDataStructs;

import java.io.*;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    //create a new (empty) list of magic items
    LinkedList allMagicItems = new LinkedList();

    //create a new (empty) list of palindromes
    LinkedList myPals = new LinkedList();

    try {
      //locate the file we wanna scan in
      FileInputStream input = new FileInputStream("magicitems.txt");
      //file we wanna scan
      Scanner scan = new Scanner(input);

      //returns true if there is another line to read
      while (scan.hasNextLine()) {

        //returns the next line and adds it to a new node on the allMagicItems list
        String item = scan.nextLine();
        allMagicItems.addTo(allMagicItems, item);
      }
      //close the scanner
      scan.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    //traverse da list, starting at head
    // for each node check if its a palindrome and add to list of pals
    Node currentNode = allMagicItems.head;
    while (currentNode != null) {
      if (currentNode.isPalindrome()) {
        myPals.addTo(myPals, currentNode.data);
      }
      //move on to the next node
      currentNode = currentNode.pointer;
    }

    //print out our list of palindromes
    System.out.println("Palindromes:");
    myPals.printList(myPals);
  }
}
