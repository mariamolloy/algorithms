public class populationList {

    //head of the list
    Person first;

    //method to add a node to the list
    //list : the list you are adding to
    //data : the string/content of the node you are adding
    public static populationList addTo(populationList list) {

        //create a new node and set the pointer to null (we dk whats in the list yet)
        Person newPerson = new Person(0);
        newPerson.pointer = null;

        //check to see if there is anything in the list yet
        //if list is empty, the node we are adding is the new head
        if (list.first == null){
            list.first = newPerson;
        }
        //if list ISN'T empty, go through list and add new node to the end of the list
        else {
            int index = 1;
            Person last = list.first;
            //go through the list
            while (last.pointer != null){
                last = last.pointer;
                index++;
            }
            //set the node's index
            newPerson.index = index;
            //insert the new node at the end of the list
            last.pointer = newPerson;
        }
        //return the linked list we added to
        return list;
    }

    //method to print a linked list
    //list : the linked list u wanna print
    public static void printList (populationList list){
        //traverse da list, starting w da head
        //for each node print the data and skip a line and move to next node
        Person current = list.first;

        while (current != null){
            System.out.print(current.index + " \n");
            current = current.pointer;
        }
    }

    public int getSize(populationList p){
        int size = 0;
        //check to see if there is anything in the list yet
        //if list is empty, the node we are adding is the new head
        if (p.first == null){
            size = p.first.index + 1;
        }
        //if list ISN'T empty, go through list and add new node to the end of the list
        else {
            int index = 1;
            Person last = p.first;
            //go through the list
            while (last.pointer != null){
                last = last.pointer;
                index++;
            }
            size = index;
        }
        //return the linked list we added to
        return size;
    }

    public void goViral(int[] infected)



}
