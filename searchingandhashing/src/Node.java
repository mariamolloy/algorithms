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


}
