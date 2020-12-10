public class Main {
    public static void main (String[] args){

        BSTIntegers maple = new BSTIntegers(); //make a new BST
        //add elements
        maple.add(50);
        maple.add(30);
        maple.add(70);
        maple.add(20);
        maple.add(40);
        maple.add(60);
        maple.add(80);
        maple.add(25);
        maple.add(56);
        maple.add(24);

        maple.search(24, maple.root);
        System.out.println("Search for 24 took " + maple.comparisons + " comparisons");

    }
}
