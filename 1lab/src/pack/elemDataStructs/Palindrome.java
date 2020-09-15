package pack.elemDataStructs;


public class Palindrome {
  Node word;

  Palindrome(Node pal){
    word = pal;
  }


  /**
  //maria -- i think everything in the while loop is what should be this method and everything outside while loop should be in a separate method in the linked list class
  //goes through a list to check for palindromes
  public static boolean isPalindrome(Node currentNode){
    //traverse da list
    Node currentNode = l.head;
    while (currentNode != null){

      //get data of current node
      String str = currentNode.data;
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
        if (i == (str.length() - 1)){
          letter = str.substring(str.length() - 1);
        } else {
          letter = str.substring(i, i + 1);
        }
        //add each letter to stack/queue
        wordS.push(letter);
        wordQ.queue(letter);
      }

      //go thru our stack and queue and pop/dequeue to test letters against each other to find palindromes
      //this only works for even number amt of lettered words rn i think
      for (int j = str.length(); j > 0; j--){

        //just for testing pur poses
        System.out.print(wordS.pop().data);
        //if both letters returned are the same, increase palCheck (pal is checkin out well)
        if (wordS.pop().data.equals(wordQ.dequeue().data)){
          palCheck++;
        }
      }

      //if palCheck == str.length then it is a palindrome!!! yayyyy
      if (palCheck == str.length()){
        return true;
      }else {
        return false;
      }

      currentNode = currentNode.pointer;
    }
  } **/


}
