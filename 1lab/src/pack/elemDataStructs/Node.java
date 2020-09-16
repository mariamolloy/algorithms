package pack.elemDataStructs;

public class Node {

  String data;
  Node pointer;

  //node constructor
  //set pointer to null bc we don't know yet if it is pointing to anything
  Node(String d) {
    data = d;
    pointer = null;
  }

  public static boolean nodesEqual(Node n1, Node n2){
    if (!(n1.data == null) && !(n2.data == null)) {
      String s1 = n1.data;
      String s2 = n2.data;
      if (s1.equals(s2)) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }

  }

  public boolean isPalindrome() {

    boolean isPal = false;

    //get data of current node
    String str = this.data;
    Stack wordS = new Stack();
    Queue wordQ = new Queue();

    //counter to make sure each set of letters in word matches
    //only works rn for even numbers
    int palCheck = 0;

    //go through word and add each letter to stack and a queue
    for (int i = 0; i < str.length(); i++) {

      //realllllly its gonna be a char every time but chars are more annoying than strings imho
      String letter = "";

      //only add one letter but check so no substring out of bounds error
      if (i == (str.length() - 1)) {
        letter = str.substring(str.length() - 1);
      } else {
        letter = str.substring(i, i + 1);
      }
      //add each letter to stack/queue
      wordS.push(letter);
      wordQ.enqueue(letter);
    }

    //go thru our stack and queue and pop/dequeue to test letters against each other to find palindromes
    //this only works for even number amt of lettered words rn i think
    for (int j = 0; j < str.length(); j++) {


      //if both letters returned are the same, increase palCheck (pal is checkin out well)
      if (nodesEqual(wordS.pop(), wordQ.dequeue())) {
        palCheck++;
        isPal = true;
      }
    }

    //if palCheck == str.length then it is a palindrome!!! yayyyy
    if (palCheck == str.length()) {
      return isPal;
    } else {
      return false;
    }

  }
}
