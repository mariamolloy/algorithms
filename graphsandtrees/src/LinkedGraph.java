import java.util.*;

public class LinkedGraph {
    public ArrayList<Vertex> graph;
    public Vertex head;
    public boolean zeroIndex;

    public LinkedGraph(){
        this.graph = new ArrayList<Vertex>();
        this.zeroIndex = false;
    }

    public void reset(){
        for (int i = 0; i < graph.size(); i++){
            graph.get(i).processed = false;
        }
    }

    public void addVertex(int v){
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

    public void addEdge(int i, int j){
        if (zeroIndex) {
            this.graph.get(i).neighbors.add(j);
            this.graph.get(j).neighbors.add(i);
        } else {
            this.graph.get(i - 1).neighbors.add(j);
            this.graph.get(j - 1).neighbors.add(i);
        }
    }

    public void breadthFirst(Vertex source){
        System.out.println("\nBreadth first: ");
        Queue q = new Queue();
        q.enqueue(source);
        source.processed = true;
        while (!q.isEmpty()){
            Vertex v = q.dequeue();
            System.out.print(v.id + ", ");
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

    public void depthFirst(Vertex source){
        if (!source.processed){
            System.out.print(source.id + ", ");
            source.processed = true;
        }
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
