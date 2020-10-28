public class Search {

    String[] arr;
    int comparisons;

    Search(String[] a){
        this.arr = a;
        this.comparisons = 0;
    }

    public void init(){
        this.comparisons = 0;
    }


    public String linearSearch(String item){
        this.comparisons = 0;
        boolean found = false;
        for (int i = 0; i < this.arr.length; i++){
            this.comparisons++;
            String curr = this.arr[i].toUpperCase();
            if (curr.equals(item)){
                found = true;
                return curr;
            }
        }
        return null;
    }

    public int binarySearch(String item, int start, int stop){
        this.comparisons++;

        if (start < stop) {
            int mid = (((stop - start) / 2 ) + 1) + start;
            if (this.arr[mid].compareToIgnoreCase(item) == 0) {
                return mid;
            } else if (this.arr[mid].compareToIgnoreCase(item) < 0) {
               // System.out.println("comes first" + this.arr[mid].compareToIgnoreCase(item));
                return (binarySearch(item, mid + 1, stop));
            } else if (this.arr[mid].compareToIgnoreCase(item) > 0) {
                //System.out.println("comes later" + this.arr[mid].compareToIgnoreCase(item));
                return (binarySearch(item, start, mid - 1));
            } else {
                return -1;
            }
        } else if (start == stop){
            return start;
        } else {
            return -1;
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
