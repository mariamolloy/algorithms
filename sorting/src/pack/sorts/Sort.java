package pack.sorts;

public class Sort {
  String[] arr;
  int comparisons;

  Sort(String[] a){
    this.arr = a;
    this.comparisons = 0;
  }

  public int selectionSort(){
    //go through array keeping track of smallest element
    for (int i =0; i < this.arr.length - 1; i++){
      int smallest = i;
      //go through unsorted part of array and compare element to each in unsorted
      for (int j = i + 1; j < this.arr.length; j++){
        if (this.arr[j].compareTo(this.arr[i]) < 0) {
          smallest = j;
          this.comparisons++;
        }
      }
      String info = this.arr[smallest];
      this.arr[smallest] = this.arr[i];
      arr[i] = info;
    } return this.comparisons;
  }

  public int insertionSort(){
    //go through array starting at second element
    for (int i = 1; i < this.arr.length; i++){
      String key = this.arr[i];
      int j = i -1;
      //compare it to each element before it, if it should come before, swap them
      //inecrement comparison counter at each comparison
      while ((j>0) && (this.arr[j].compareTo(key) > 0)){
        this.arr[j + 1] = this.arr[j];
        this.comparisons++;
        j--;
      }
      this.arr[j + 1] = key;
    }
    return this.comparisons;
  }

  //arr is the array we are sorting and p, q and r are indices of the array that indicate the sub arrays
  //assumes sub arrays arr[p - q] and arr[q+ 1  - r] are already sorted
  public static void merge(String[] arr, int p, int q, int r){
    //find sizes of arrays to be merged
    int n1 = (q - p) + 1;
    int n2 = r - q;

    //create two temporary arrays
    String[] temp1 = new String[n1];
    String[] temp2 = new String[n2];

    //copy data to temporary arrays
    for (int i = 0; i < n1; i++){
      temp1[i] = arr[p + i];
    }
    for (int j = 0; j < n2; j++){
      temp2[j] = arr[q + j + 1];
    }

    //merge the temp arrays
    int i = 0;
    int j = 0;
    int k = p;

    //
    while ((i < n1) && (j < n2)) {
      if (temp1[i].compareTo(temp2[j]) <= 0){
        arr[k] = temp1[i];
        i++;
      } else {
        arr[k] = temp2[j];
        j++;
      }
      k++;
    }

    while (i < n1){
      arr[k] = temp1[i];
      i++;
      k++;
    }

    while (j < n2){
      arr[k] = temp2[j];
      j++;
      k++;
    }
  }

  public static int mergeSort(String[] arr, int p, int r){
    int comp = 0;
    if (p < r){
      comp++;
      int mid = (p + r)/2;
      mergeSort(arr, p, mid);
      mergeSort(arr, mid + 1, r);

      merge(arr, p, mid, r);
    }
    return comp;
  }

  public static int quickSort(String[] arr){
    return 3;
  }



}
