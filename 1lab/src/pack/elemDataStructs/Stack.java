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

  public void push(String element){
    Node myNode = new Node(element);
    Node prevTop = this.top;
    this.top = myNode;
    myNode.pointer = prevTop;
  }
}
