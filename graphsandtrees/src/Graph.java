import java.util.*;

public class Graph {
    public boolean matrix[][] ;
    public ArrayList<ArrayList<Integer>> adjacencyList;
    public int vertices;
    public boolean zeroIndex;

    public Graph (int v, boolean index){
        this.vertices = v;
        this.matrix = new boolean[v][v];
        this.zeroIndex = index;
        this.adjacencyList = new ArrayList<ArrayList<Integer>>(v);
        //add vertices to array list
        for (int i = 0; i < v; i++){
            adjacencyList.add(new ArrayList<Integer>());
        }
    }

    //adds an edge both the matrix and adjacency graph representations
    //i and j are the two vertices the edge is in between
    public void addEdge(int i, int j) {
        this.matrix[i][j] = true;
        this.matrix[j][i] = true;

        this.adjacencyList.get(i).add(j);
        this.adjacencyList.get(j).add(i);
    }

    public String printMatrix(){
        StringBuilder s = new StringBuilder();
        if (this.zeroIndex) {
            for (int i = 0; i < this.vertices; i++) {
                s.append(i + ": ");
                for (boolean j : this.matrix[i]) {
                    s.append((j ? 1 : 0) + " ");
                }
                s.append("\n");
            }
        } else {
            for (int i = 0; i < this.vertices; i++) {
                s.append((i + 1) + ": ");
                for (boolean j : this.matrix[i]) {
                    s.append((j ? 1 : 0) + " ");
                }
                s.append("\n");
            }
        }
        return s.toString();
    }

    public String printList(){
        StringBuilder s = new StringBuilder();
        if (this.zeroIndex) {
            for (int i = 0; i < this.adjacencyList.size(); i++) {
                s.append("Vertex " + i + ":");
                for (int j = 0; j < this.adjacencyList.get(i).size(); j++) {
                    s.append(" -> " + this.adjacencyList.get(i).get(j));
                }
                s.append("\n");
            }
        } else {
            for (int i = 0; i < this.adjacencyList.size(); i++) {
                s.append("Vertex " + (i + 1) + ":");
                for (int j = 0; j < this.adjacencyList.get(i).size(); j++) {
                    s.append(" -> " + (this.adjacencyList.get(i).get(j) + 1));
                }
                s.append("\n");
            }
        }
        return s.toString();
    }


}
