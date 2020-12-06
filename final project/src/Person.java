public class Person {

    public boolean infected;
    public int index;
    Person pointer;

    //node constructor
    //set pointer to null bc we don't know yet if it is pointing to anything until we add more nodes
    Person(int i) {
        infected = false;
        pointer = null;
        this.index = 0;
    }


}
