package pack.elemDataStructs;

public class Node {

  String data;
  Node pointer;

  //node constructor
  //set pointer to null bc we don't know yet if it is pointing to anything until we add more nodes
  Node(String d) {
    data = d;
    pointer = null;
  }


  //method to see if two nodes have the same content
  //takes the two nodes we are comparing as parameters
  //used to check for palindromes
  //returns true if  the nodes are equal, false if theyre not (duh lol)
  public static boolean nodesEqual(Node n1, Node n2){
    //as long as both nodes arent null we can save the strings of their data
    if (!(n1.data == null) && !(n2.data == null)) {
      String s1 = n1.data;
      String s2 = n2.data;
      //if the strings are = then the nodes are =
      if (s1.equals(s2)) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  //method to check if the content of a node is a palindrome
  //returns true if a palindrome, false if not
  public boolean isPalindrome() {

    //get data of current node and make it all lowercase to avoid case sensitive typa errors and trim whitespace off ends
    String str = this.data.trim();
        str = str.toLowerCase();
    //new string for the magic item with no spaces
    String noSpace = str.replaceAll("\\s+", "");

    //make the empty stack and queue that we will be adding each letter to
    Stack wordS = new Stack();
    Queue wordQ = new Queue();

    //counter to make sure each set of letters in word matches
    int palCheck = 0;

    //go through word and add each letter to stack and a queue
    for (int i = 0; i < noSpace.length(); i++) {

      //realllllly its gonna be a char every time but chars are more annoying than strings imho so its a string<3
      String letter = "";

      //only add one letter but check if its the last letter so no substring out of bounds error
      if (i == (noSpace.length() - 1)) {
        letter = noSpace.substring(i);
      } else {
        letter = noSpace.substring(i, i + 1);
      }
      //add each letter to stack/queue
      wordS.push(letter);
      wordQ.enqueue(letter);
    }

    //go thru our stack and queue and pop/dequeue to test letters against each other to find palindromes
    for (int j = 0; j < noSpace.length(); j++) {

      //if both letters returned are the same, increase palCheck (pal is checkin out well)
      if (nodesEqual(wordS.pop(), wordQ.dequeue())) {
        palCheck++;
      }
    }

    //if palCheck == noSpace.length then it means each letter in the node matches and it is a palindrome!!! yayyyy
    if (palCheck == noSpace.length()) {
      return true;
    } else {
      return false;
    }

  }
}
