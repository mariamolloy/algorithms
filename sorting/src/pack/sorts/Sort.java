package pack.sorts;

public class Sort {
  String[] arr;
  int comparisons;

  Sort(String[] a){
    this.arr = a;
    this.comparisons = 0;
  }

  public int selectionSort(){
    for (int i =0; i < this.arr.length - 1; i++){
      int smallest = i;
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

  public static int mergeSort(String[] arr){
    return 2;
  }

  public static int quickSort(String[] arr){
    return 3;
  }



}
