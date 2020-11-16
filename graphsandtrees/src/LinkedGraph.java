import java.util.*;

public class LinkedGraph {
    public ArrayList<Vertex> graph;
    public Vertex head;
    public boolean zeroIndex;

    public LinkedGraph(){
        this.graph = new ArrayList<Vertex>();
        this.zeroIndex = false;
    }

    //resets all vertices to unprocessed
    public void reset(){
        for (int i = 0; i < graph.size(); i++){
            graph.get(i).processed = false;
        }
    }

    //adds a vertex to the graph
    //param v is the id of the vertex
    public void addVertex(int v){
        //if there is nothing in the graph yet, check the indexing and make it the head of the graph
        if (this.graph.isEmpty()) {
            Vertex newVert = new Vertex(v);
            graph.add(newVert);
            this.head = newVert;
            if (newVert.id == 0){
                this.zeroIndex = true;
            }
        } else {
            Vertex newVert = new Vertex(v);
            graph.add(newVert);
        }
    }

    //adds an edge to the graph
    //params i and j are the vertices of the edge
    public void addEdge(int i, int j){
        if (zeroIndex) {
            this.graph.get(i).neighbors.add(j);
            this.graph.get(j).neighbors.add(i);
        } else {
            this.graph.get(i - 1).neighbors.add(j);
            this.graph.get(j - 1).neighbors.add(i);
        }
    }

    //traverses the graph breadth first and prints each element
    //param source is the element we are starting our traversal at
    public void breadthFirst(Vertex source){
        System.out.println("\nBreadth first: ");
        //create a queue to add elements to print to
        //starting with the element we called this with ofc
        Queue q = new Queue();
        q.enqueue(source);
        source.processed = true;
        //as long as the queue isnt empty, print the next element
        while (!q.isEmpty()){
            Vertex v = q.dequeue();
            System.out.print(v.id + ", ");
            //add all the neighbors of that elemet to the queue
            for (int i = 0; i < v.neighbors.size(); i++){
                Vertex currentVert = new Vertex(0);
                if (this.zeroIndex) {
                     currentVert = this.graph.get(v.neighbors.get(i));
                } else {
                     currentVert = this.graph.get(v.neighbors.get(i) - 1);
                }
                    if (!currentVert.processed) {
                        q.enqueue(currentVert);
                        currentVert.processed = true;
                    }
            }
        }
        System.out.println("\n");
    }


    //function to traverse depth first through a graph and print each element
    // param source is the element we are starting at
    public void depthFirst(Vertex source){
        //if its not processed, print it!
        if (!source.processed){
            System.out.print(source.id + ", ");
            source.processed = true;
        }
        //go through neighbors of first element and call to print them recursively if they havent been already
        for (int i = 0; i < source.neighbors.size(); i++){
            Vertex currentVert = new Vertex(0);
            if (zeroIndex){
                 currentVert = this.graph.get(source.neighbors.get(i));
            } else {
                 currentVert = this.graph.get(source.neighbors.get(i) - 1);
            }
            if (!currentVert.processed){
                depthFirst(currentVert);
            }
        }
    }


}
