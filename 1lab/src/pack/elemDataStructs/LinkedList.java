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

  public static void main(String[] args){
    System.out.println("hello world");

    //create a new empty list
    LinkedList newList = new LinkedList();

    //insert values
    newList = addTo(newList, "m");
    newList = addTo(newList, "a");
    newList = addTo(newList, "r");
    newList = addTo(newList, "i");
    newList = addTo(newList, "aaa");

    printList(newList);

  }

}
