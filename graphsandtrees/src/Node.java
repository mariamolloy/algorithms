public class Node {

    Vertex data;
    Node pointer;

    //node constructor
    //set pointer to null bc we don't know yet if it is pointing to anything until we add more nodes
    Node(Vertex d) {
        data = d;
        pointer = null;
    }

}
