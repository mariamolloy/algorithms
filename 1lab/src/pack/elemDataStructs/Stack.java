package pack.elemDataStructs;

public class Stack {
  //create a top of the stack
  Node top;

  //stack constructor
  Stack(){
    this.top = null;
  }

  public boolean isEmpty(){
    //check if list is empty by seeing if there is a top node yet
    if (top == null){
      return true;
    } else {
      return false;
    }
  }

  //method to add an element to the top of the stack
  //element = the String data to be added to the stack
  public void push(String element){

    //create a new node w the data we want to add to the stack
    Node myNode = new Node(element);

    //set the new node's pointer to the node that used to be at the top of the stack
    myNode.pointer = this.top;

    //set the top to the node we just added
    this.top = myNode;
  }

  public void pop(){

  }
}
