package pack.elemDataStructs;

public class LinkedList {
  //creates a head of the list
  Node head;

  //method to add a node to the list
  //list : the list you are adding to
  //data : the string/content of the node you are adding
  public static LinkedList addTo(LinkedList list, String data) {

    //create a new node and set the pointer to null (we dk whats in the list yet)
    Node newNode = new Node(data);
    newNode.pointer = null;

    //check to see if there is anything in the list yet
    //if list is empty, the node we are adding is the new head
    if (list.head == null){
      list.head = newNode;
    }
    //if list ISN'T empty, go through list and add new node to the end of the list
    else {
      Node last = list.head;
      //go through the list
      while (last.pointer != null){
        last = last.pointer;
      }
      //insert the new node at the end of the list
      last.pointer = newNode;
    }
    //return the linked list we added to
    return list;
  }

  //method to print a linked list
  //list : the linked list u wanna print
  public static void printList (LinkedList list){
    //traverse da list, starting w da head
    //for each node print the data and skip a line and move to next node
    Node currentNode = list.head;

    while (currentNode != null){
      System.out.print(currentNode.data + " \n");
      currentNode = currentNode.pointer;
    }
  }

  //this method i made for testing my stack class
  //basically takes a list and for each element in the list adds the content to its own stack letter by letter
  //should print each word in the list backwards
  //same logic as isPalindrome
  public static void listToStack (LinkedList l){
    Node currentNode = l.head;

    while (currentNode != null){
      String str = currentNode.data;
      Stack word = new Stack();
      for (int i = 0; i < str.length(); i++) {
        String letter = "";
        if (i == (str.length() - 1)){
          letter = str.substring(str.length() - 1);
        } else {
          letter = str.substring(i, i + 1);
        }
        word.push(letter);
      }
      for (int j = str.length(); j > 0; j--){
        System.out.print(word.pop().data);
      }
      currentNode = currentNode.pointer;
    }
  }

  //this is a method i made to test and debug my queue methods
  //works the same as listToStack basically just traverses a list and for each node enqueues each letter individually then dequeues and prints
  //should print letters in correct order
  //same logic as isPalindrome
  public static void listToQueue (LinkedList l){
    Node currentNode = l.head;

    while (currentNode != null){
      String str = currentNode.data;
      Queue word = new Queue();
      for (int i = 0; i < str.length(); i++) {
        String letter = "";
        if (i == (str.length() - 1)){
          letter = str.substring(i);
        } else {
          letter = str.substring(i, i + 1);
        }
        word.enqueue(letter);
      }
      for (int j = str.length(); j > 0; j--){
        System.out.print(word.dequeue().data);
      }
      currentNode = currentNode.pointer;
    }
  }

}
