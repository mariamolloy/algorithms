public class BinarySearchTree {
    Leaf root;
    int comparisons;

    public BinarySearchTree(){
        root = null;
        comparisons = 0;
    }

    //adds a leaf to the binary search tree
    //param s is the data of the leaf we add
    void add(String s)
    {
        this.root = addTo(this.root, s);
    }

    //recursive function to traverse down the BST when adding an element
    //params: l = the root of the local BST we are looking at, s = data we are adding
    public Leaf addTo(Leaf l, String s){
        //if bst is empty, make a root with the data we are adding
        if (l == null){
           l = new Leaf(s);
           this.root = l;
           return l;
        }
        else {
            //if the string we are adding comes  earlier than the root were on traverse the bst to the left
            if (s.compareToIgnoreCase(l.data) > 0){
                l.left = addTo(l.left, s);
            } //if the string comes later, traverse the bst to the right
            else if (s.compareToIgnoreCase(l.data) < 0) {
                l.right = addTo(l.right, s);
            }
            return l;
        }
    }


    //recursive function to search for a string in the BST
    //params: lookingFor = the string we are looking for (duh), l = the root of the bst we are searching
    public Leaf search(String lookingFor, Leaf l){
        this.comparisons++; //we are about to compare!!!!!
        if (l == null || l.data.equalsIgnoreCase(lookingFor)){ //if we have found it or the bst is empty
            return l;
        } else if(l.data.compareToIgnoreCase(lookingFor) < 0){ //if what were looking for comes before the root, search tree to the left
            return search(lookingFor, l.left);
        } else { //otherwise we should search the tree to the right
            return search(lookingFor, l.right);
        }
    }

    //resets number of comparisons back to 0
    public void reset(){
        this.comparisons = 0;
    }



}
