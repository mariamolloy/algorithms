
public class Node {

    String data;
    Node pointer;

    //node constructor
    //set pointer to null bc we don't know yet if it is pointing to anything until we add more nodes
    Node(String d) {
        data = d;
        pointer = null;
    }

}
