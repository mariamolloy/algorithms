package pack.elemDataStructs;

public class LinkedList {
  //creates a head of the list
  Node head;

  //method to add data to the list
  //list : the list you are adding to
  //data : the string you are adding
  public static LinkedList addTo(LinkedList list, String data) {

    //create a new node and set the pointer to null
    Node newNode = new Node(data);
    newNode.pointer = null;

    //check to see if there is anything in the list yet
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
    return list;
  }

  public static void printList (LinkedList list){
    Node currentNode = list.head;
    System.out.print("LinkedList: ");

    while (currentNode != null){
      System.out.print(currentNode.data + " ");
      currentNode = currentNode.pointer;
    }
  }

  //this method i made for testing my stack class
  //basically takes a list and for each element in the list adds the content to its own stack letter by letter
  //should print each word in the list backwards
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


  public static void main(String[] args){

    //create a new empty list
    LinkedList newList = new LinkedList();

    //insert values
    newList = addTo(newList, "maria");
    newList = addTo(newList, "minna");
    newList = addTo(newList, "molloy");
    newList = addTo(newList, "aaa");

    listToStack(newList);



  }

}
