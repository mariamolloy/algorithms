package pack.sorts;

public class Sort {
  String[] arr;

  Sort(String[] a){
    this.arr = a;
  }

  public static int selectionSort(String[] arr){
    return 0;
  }

  public int insertionSort(){
    int comparisons = 0;
    for (int i = 1; i < this.arr.length; i++){
      String key = this.arr[i];
      int j = i -1;
      while ((j>0) && (this.arr[j].compareTo(key) > 0)){
        this.arr[j + 1] = this.arr[j];
        comparisons++;
        j--;
      }
      this.arr[j + 1] = key;
    }
    return comparisons;
  }

  public static int mergeSort(String[] arr){
    return 2;
  }

  public static int quickSort(String[] arr){
    return 3;
  }



}
