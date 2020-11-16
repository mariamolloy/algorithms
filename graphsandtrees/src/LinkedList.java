
public class LinkedList {
    //creates a head of the list
    Node head;

    //method to add a node to the list
    //list : the list you are adding to
    //data : the string/content of the node you are adding
    public static LinkedList addTo(LinkedList list, Vertex data) {

        //create a new node and set the pointer to null (we dk whats in the list yet)
        Node newNode = new Node(data);
        newNode.pointer = null;

        //check to see if there is anything in the list yet
        //if list is empty, the node we are adding is the new head
        if (list.head == null){
            list.head = newNode;
        }
        //if list ISN'T empty, go through list and add new node to the end of the list
        else {
            Node last = list.head;
            //go through the list
            while (last.pointer != null){
                last = last.pointer;
            }
            //insert the new node at the end of the list
            last.pointer = newNode;
        }
        //return the linked list we added to
        return list;
    }

    //method to print a linked list
    //list : the linked list u wanna print
    public static void printList (LinkedList list){
        //traverse da list, starting w da head
        //for each node print the data and skip a line and move to next node
        Node currentNode = list.head;

        while (currentNode != null){
            System.out.print(currentNode.data + " \n");
            currentNode = currentNode.pointer;
        }
    }


}
