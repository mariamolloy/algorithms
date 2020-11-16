public class Queue {

    //create a head and a tail of the queue
    Vertex header;
    Vertex tail;

    //queue constructor
    Queue(){
        this.header = null;
        this.tail = null;
    }

    boolean isEmpty(){
        //check to see if theres anything in the queue yet
        if (this.header == null){
            return true;
        } else{
            return false;
        }
    }

    //method to enqueueueue a node (add to back of the queueue)
    public void enqueue(Vertex l){

        //new node we are enqueueueueing
        Vertex newVert = l;

        //if list isn't empty add new node to the end of the queueueue
        if (!this.isEmpty()){
            this.tail.pointer = newVert;
            this.tail = newVert;
        } else {
            //if the list is empty the new node is the only element so its the head and tail
            this.header = this.tail = newVert;
        }
    }

    //method to remove a node from the queueueue
    //returns the node we removed
    public Vertex dequeue(){

        //if list isnt empty we pop the top (same idea as stack pop())
        if (!(this.isEmpty())){
            Vertex firstInLine = this.header;
            this.header = this.header.pointer;
            return firstInLine;
        } else {
            //if its empty return null we cant dequeueue anything
            System.out.println("Stack Underflow Error");
            return null;
        }
    }

}
