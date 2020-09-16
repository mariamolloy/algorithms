package pack.elemDataStructs;
import java.io.*;


//maria -- it only is reading the
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
      File magicItems = new File("magicitems.txt");    //creates a new file instance
      FileReader fr = new FileReader(magicItems);   //reads the file
      BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
      StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
      String line;
      while((line = br.readLine())!= null)
      {
        sb.append(line);      //appends line to string buffer
        sb.append("\n");     //line feed
      }
      fr.close();    //closes the stream and release the resources
      System.out.println("Contents of File: ");
      allMagicItems.addTo(allMagicItems, sb.toString());
      //System.out.println(sb.toString());//returns a string that textually represents the object

      /*
      //trim whitespace off ends of item
      String item = sb.toString().trim();
      String noSpaceItem = item.replaceAll("\\s+", "");
      allMagicItems.addTo(allMagicItems, noSpaceItem); */
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

    myPals.printList(myPals);
    allMagicItems.printList(allMagicItems);
  }
}
