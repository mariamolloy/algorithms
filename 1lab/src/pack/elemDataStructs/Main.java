package pack.elemDataStructs;
import java.io.*;
import java.util.Scanner;


//maria -- i think it is reading the entire text file into one string or something
//try like scanner instead of string buffer shit
public class Main {
  public static void main(String[] args){
    //create a new empty list
    LinkedList newList = new LinkedList();

    //create a new empty list of magic items
    LinkedList allMagicItems = new LinkedList();

    //create a new empty list of palindromes
    LinkedList myPals = new LinkedList();

    //insert values
    newList.addTo(newList, "anna");
    newList.addTo(newList, "hello");
    newList.addTo(newList, "molloy");
    newList.addTo(newList, "mom");
    newList.addTo(newList, "racecar");
    newList.addTo(newList, "boob");

    try
    {
//the file to be opened for reading
      FileInputStream fis=new FileInputStream("magicitems.txt");
      Scanner sc=new Scanner(fis);    //file to be scanned
//returns true if there is another line to read
      while(sc.hasNextLine())
      {

        //returns the line that was skipped
        String d = sc.nextLine();
        allMagicItems.addTo(allMagicItems, d);
      }
      sc.close();     //closes the scanner
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }

    //traverse da listo, for each node check if its a palindrome and add to list of pals
    Node currentNode = allMagicItems.head;
    while (currentNode != null){
      if (currentNode.isPalindrome()){
        myPals.addTo(myPals, currentNode.data);
      }
      currentNode = currentNode.pointer;
    }

    System.out.println("Palindromes:");
    myPals.printList(myPals);
  }
}
