import java.util.*;

public class Vertex {
    int id;
    boolean processed;
    ArrayList<Integer> neighbors;
    Vertex pointer;

    public Vertex(int i) {
        this.id = i;
        this.processed = false;
        this.pointer = null; //we only are using this for the   queue
    }

}