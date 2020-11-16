public class BinarySearchTree {
    Leaf root;

    public BinarySearchTree(){
        root = null;
    }


    public Leaf addTo(Leaf l, String s){
        if (l == null){
           l = new Leaf(s);
           this.root = l;
           return l;
        }
        else {
            if (s.compareToIgnoreCase(l.data) > 0){
                l.left = addTo(l.left, s);
            } else if (s.compareToIgnoreCase(l.data) < 0){
                l.right = addTo(l.right, s);
            }
            return l;
        }
    }

}
