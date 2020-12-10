public class populationList {

    //head of the list
    Person first;

    //method to add a node to the list
    //list : the list you are adding to
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

    //param l = the list of the population we are spreading the virus to
    //param inf = a sorted array with the indices of the members of the population to be infected
    public static void infectPpl(populationList l, int[] inf){

        int totalInf = inf.length; //how many people we should infect
        int infectedFound = 0; //counter to see which infected person were on
        Person last = l.first;

        //check to see if first person should be infected bc if we have list of size 1 the while loop wont check
        if (last.index == inf[infectedFound]){
            System.out.println(last.index);
            last.infected = true;
            infectedFound++;
        }
        //go through the population and infect as necessary
        //exit loop either when we have gone through the whole pop or when we have infected everyone we need to infect
        while ((last.pointer != null) && (infectedFound < inf.length)){
                last = last.pointer;
                if (last.index == inf[infectedFound]){
                    System.out.print(last.index + " \n");
                    last.infected = true;
                    infectedFound++;
                }
        }
    }


}
