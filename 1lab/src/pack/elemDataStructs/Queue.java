package pack.elemDataStructs;

public class Queue {

  //maria -- u need to add an isEmpty method and always check if its empty b4 adding or removing

  //create a head and a tail of the queue
  Node header;
  Node tail;

  //queue constructor
  Queue(){
    this.header = null;
    this.tail = null;
  }

  boolean isEmpty(){
    //check to see if theres anything in the queue
    if (this.header == null){
      return true;
    } else{
      return false;
    }
  }

  public void enqueue(String l){
    Node temp = new Node(l);

    //if list isn't empty add new node to the end of the queueueue
    if (!this.isEmpty()){
      this.tail.pointer = temp;
      this.tail = temp;
    } else {
      //if the list is empty the new node is the only element so its the head and tail
      this.header = this.tail = temp;
    }
  }

  public Node dequeue(){

    //if list isnt empty we pop the top
    if (!(this.isEmpty())){
      Node firstInLine = this.header;
      this.header = this.header.pointer;
      return firstInLine;
    } else {
      //if its empty return null we cant dequeueue anything
      System.out.println("S lol tack Underflow Error");
      return null;
    }
  }

}
