import java.util.*;

public class Vertex {
    int id;
    boolean processed;
    ArrayList<Integer> neighbors;
    Vertex pointer;

    //vertex constructor
    //param i is the id of the vertex
    public Vertex(int i) {
        this.id = i;
        this.processed = false;
        this.neighbors = new ArrayList<Integer>();
        this.pointer = null; //we only are using this for the   queue used in breadth first traversal
    }

}