public class Search {

    String[] arr;
    int comparisons;

    Search(String[] a){
        this.arr = a;
        this.comparisons = 0;
    }

    //reset comparisons to 0
    public void init(){
        this.comparisons = 0;
    }

    //linear search algorithm
    //takes the item in the list we are searching for as a parameter
    public String linearSearch(String item){
        this.comparisons = 0;
        //go through array and look for item
        for (int i = 0; i < this.arr.length; i++){
            this.comparisons++; //increment comparisons
            String curr = this.arr[i].toUpperCase();
            if (curr.equals(item)){
                return curr; //we found it!!!
            }
        }
        return null; //it wasnt in the list :(
    }

    //function to do a binary search
    //takes the item we are searching for along with where we are starting and stopping our search as params
    public int binarySearch(String item, int start, int stop){
        this.comparisons++; //increment comparisons
        if (start < stop) { //we are still searching
            int mid = (((stop - start) / 2 ) + 1) + start; //middle value
            if (this.arr[mid].compareToIgnoreCase(item) == 0) {
                return mid; //we found it!!!
            } else if (this.arr[mid].compareToIgnoreCase(item) < 0) {
                return (binarySearch(item, mid + 1, stop)); //go back and search right half
            } else if (this.arr[mid].compareToIgnoreCase(item) > 0) {
                return (binarySearch(item, start, mid - 1)); //go back and search left half
            } else {
                return -1; //we didnt find it :(
            }
        } else if (start == stop){
            return start; //we found iT!
        } else {
            return -1; //we didnt find it :(
        }
    }


    //method to merge two subarrays
    //arr is the array we are sorting and p, q and r are indices of the array that indicate the sub arrays
    //assumes sub arrays arr[p - q] and arr[q+ 1  - r] are already sorted
    public void merge(int p, int q, int r){
        //find sizes of arrays to be merged
        int n1 = (q - p) + 1;
        int n2 = r - q;

        //create two temporary arrays
        String[] temp1 = new String[n1];
        String[] temp2 = new String[n2];

        //copy data to temporary arrays
        for (int i = 0; i < n1; i++){
            temp1[i] = this.arr[p + i];
        }
        for (int j = 0; j < n2; j++){
            temp2[j] = this.arr[q + j + 1];
        }

        //merge the temp arrays
        int i = 0;
        int j = 0;
        int k = p;

        //goo through and combine arrays
        while ((i < n1) && (j < n2)) {
            if (temp1[i].compareTo(temp2[j]) <= 0){
                this.arr[k] = temp1[i];
                i++;
            } else {
                this.arr[k] = temp2[j];
                j++;
            }
            this.comparisons++;
            k++;
        }

        //if any elements havent been added, add them!
        while (i < n1){
            this.arr[k] = temp1[i];
            i++;
            k++;
        }

        while (j < n2){
            this.arr[k] = temp2[j];
            j++;
            k++;
        }
    }

    //recursive mergesort function
    //takes start and end indices of array as a parameter
    public void mergeSort(int p, int r){
        if (p < r){
            int mid = (p + r)/2;
            //this is the divide part
            //recursion time :D
            mergeSort(p, mid);
            mergeSort(mid + 1, r);

            //this is the conquer part
            merge(p, mid, r);
        }
    }


}


