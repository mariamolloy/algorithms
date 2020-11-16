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

        //String[] allGraphs = tempArr.toArray(new String[0]);

        for (int i = 0; i < fileLines; i++) {
            if (tempArr.get(i).equalsIgnoreCase("new graph")) {
                int v = 0; //keeps track of # of vertices
                int j = i + 1; //keeps track of what line were on
                while (tempArr.get(j).length() > 10 && tempArr.get(j).substring(0, 10).equalsIgnoreCase("add vertex")) {
                    v++;
                    j++;
                }
                Graph myGraph = new Graph(v);
                //j++;
                while (tempArr.get(j).length() > 8 && tempArr.get(j).substring(0, 8).equalsIgnoreCase("add edge")){
                    int e1 = Integer.parseInt(tempArr.get(j).substring(9, 10)) - 1;
                    int e2 = Integer.parseInt(tempArr.get(j).substring(13, 14)) - 1;
                    myGraph.addEdge(e1, e2);
                    j++;
                }
                System.out.println(myGraph.printMatrix());
            }
        }

    }


}
