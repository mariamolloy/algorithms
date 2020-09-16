package pack.elemDataStructs;

public class Queue {

  //maria -- u need to add an isEmpty method and always check if its empty b4 adding or removing

  //create a head and a tail of the queue
  Node head;
  Node tail;

  //queue constructor
  Queue(){
    this.head = null;
    this.tail = null;
  }

  boolean isEmpty(){
    //check to see if theres anything in the queue
    if (head == null){
      return true;
    } else{
      return false;
    }
  }

  public void enqueue(String l){
    Node newNode = new Node(l);

    //if list isn't empty add new node to the end of the queueueue
    if (!isEmpty()){
      newNode.pointer = this.tail;
      this.tail = newNode;
    } else {
      //if the list is empty the new node is the only element so its the head and tail
      this.head = newNode;
      this.tail = newNode;
    }
  }

  public Node dequeue(){

    //if list isnt empty we pop the top
    if (!isEmpty()){
      Node firstInLine = this.head;
      this.head = this.head.pointer;
      return firstInLine;
    } else {
      //if its empty return null we cant dequeueue anything
      return null;
    }
  }

}
