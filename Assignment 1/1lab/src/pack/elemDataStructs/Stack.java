package pack.elemDataStructs;

public class Stack {
  //create a top of the stack
  Node top;

  //stack constructor
  Stack(){
    this.top = null;
  }

  boolean isEmpty(){
    //check if list is empty by seeing if there is a top node yet
    if (top == null){
      return true;
    } else {
      return false;
    }
  }

  //method to add an element to the top of the stack
  //element : the String data of the node to be added to the stack
  public void push(String element){

    //create a new node w the data we want to add to the stack
    Node newNode = new Node(element);

    //set the new node's pointer to the node that used to be at the top of the stack
    newNode.pointer = this.top;

    //set the top to the node we just added
    this.top = newNode;
  }

  //method to remove the element at the top of the stack
  //returns the node we removed
  public Node pop(){

    //as long as there is SOMETHING in the stack we can move forward and pop the top
    if (!(this.isEmpty())){
      Node poppedNode = this.top;
      this.top = this.top.pointer;
      return poppedNode;
    } else {
      //is stack is empty we can't pop anything :(
      System.out.println("Stack Underflow Error");
      return null;
    }
  }
}
