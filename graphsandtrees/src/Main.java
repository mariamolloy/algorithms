import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        getGraphs("graphs1.txt");
    }

    public static String[] getMagicItems(String address){
        //create a new arraylist of magic items
        ArrayList<String> tempMagicItems = new ArrayList<String>();
        int fileLines = 0;

        try {
            //locate the file we wanna scan in
            FileInputStream input = new FileInputStream(address);
            //file we wanna scan
            Scanner scan = new Scanner(input);

            //returns true if there is another line to read
            while (scan.hasNextLine()) {

                //returns the next line and adds it tempMagicItems and increases file line counter
                String item = scan.nextLine().toUpperCase();
                tempMagicItems.add(item);
                fileLines++;
            }
            //close the scanner
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tempMagicItems.toArray(new String[0]);
    }

    //method to read in file with graph instructions and make into both a matrix and an adjancency list and then print it
    //param @ address: the name of the file to read in
    public static void getGraphs(String address){
        //create a new arraylist of magic items
        ArrayList<String> tempArr = new ArrayList<String>();
        int fileLines = 0;
        try {
            //locate the file we wanna scan in
            FileInputStream input = new FileInputStream(address);
            //file we wanna scan
            Scanner scan = new Scanner(input);

            //returns true if there is another line to read
            while (scan.hasNextLine()) {

                //returns the next line and adds it temp array and increases file line counter
                String item = scan.nextLine().toUpperCase();
                tempArr.add(item);
                fileLines++;
            }
            //close the scanner
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //go through array of graph instructions
        for (int i = 0; i < fileLines; i++) {
            //if the line says new graph it is time to make a new graph!
            if (tempArr.get(i).equalsIgnoreCase("new graph")) {
                LinkedGraph g = new LinkedGraph(); //make the graph of linked objects

                int v = 0; //keeps track of # of vertices
                int j = i + 1; //keeps track of what line were on
                boolean zeroIndex = false; //keeps track if this graph is indexed at zero (true) or one (false) (i know... confusing.. im sorry)

                //add vertices by incrementing vertex count and checking if its indexed at 0 or 1
                while (tempArr.get(j).length() > 10 && tempArr.get(j).substring(0, 10).equalsIgnoreCase("add vertex")) {
                    if (tempArr.get(j).equalsIgnoreCase("add vertex 0")){
                        zeroIndex = true;
                    }
                    //add vertex to linked object graph
                    g.addVertex(Integer.parseInt(tempArr.get(j).substring(11)));

                    //increment count of vertices and counter
                    v++;
                    j++;
                }
                //make a new matrix and adjacency graph with the amount of vertices we found
                Graph myGraph = new Graph(v, zeroIndex);

                //add edges line by line
                while (j < fileLines && tempArr.get(j).length() > 8 && tempArr.get(j).substring(0, 8).equalsIgnoreCase("add edge")){
                    String[] edges = tempArr.get(j).substring(9).split("-", 2);
                    int e1 = Integer.parseInt(edges[0].trim());
                    int e2 = Integer.parseInt(edges[1].trim());
                    g.addEdge(e1, e2); //add edges to linked object list regardless of where its indexed
                    if (!myGraph.zeroIndex){
                        e1 = e1 - 1;
                        e2 = e2 - 1;
                    }
                    myGraph.addEdge(e1, e2);
                    j++;
                }
                //print matrix and adjacency list
                System.out.print("\n");
                System.out.println(myGraph.printMatrix());
                System.out.println(myGraph.printList());

                //print both traversals of linked object graph
                g.breadthFirst(g.head);
                g.reset();
                System.out.println("Depth first: ");
                g.depthFirst(g.head);
                System.out.print("\n");
            }
        }

    }


}
