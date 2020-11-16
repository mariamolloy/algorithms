import java.util.*;

public class LinkedGraph {
    public ArrayList<Vertex> graph;
    public Vertex head;

    public LinkedGraph(){
        this.graph = new ArrayList<Vertex>();
    }

    public void addVertex(int v){
        if (this.graph.isEmpty()) {
            Vertex newVert = new Vertex(v);
            graph.add(newVert);
            this.head = newVert;
        } else {
            Vertex newVert = new Vertex(v);
            graph.add(newVert);
        }
    }

    public void addEdge(int i, int j){
        this.graph.get(i).neighbors.add(j);
        this.graph.get(j).neighbors.add(i);
    }

    public void breadthFirst(Vertex source){
        Queue q = new Queue();
        q.enqueue(source);
        source.processed = true;
        while (!q.isEmpty()){
            Vertex v = q.dequeue();
            System.out.println(v.id);
            for (int i = 0; i < v.neighbors.size(); i++){
                Vertex currentVert = this.graph.get(v.neighbors.get(i));
                if (!currentVert.processed){
                    q.enqueue(currentVert);
                    currentVert.processed = true;
                }
            }
        }
    }

   // public String depthFirst(){

   // }


}
