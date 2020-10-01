package pack.sorts;

import java.util.*;

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
        }
        this.comparisons++;
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


  public int partition(int p, int r){
    //choose a random pivot with the random method
    random(p, r);
    String pivot = this.arr[r];
    //int i = (int)(Math.random() * (r - p + 1) + p);
    int i = p - 1;
    for (int j = p; j < r; j++){
      this.comparisons++;
      //if the current element is less than the pivot, we swap the current element and the first unsorted element
      if (this.arr[j].compareTo(pivot) <= 0){
        i++;
        String temp = this.arr[j];
        this.arr[j] = this.arr[i];
        this.arr[i] = temp;
      }
    }
    //swap pivot and element after last unsorted element
    String temptemp = this.arr[i + 1];
    this.arr[i + 1] = this.arr[r];
    this.arr[r] = temptemp;
    return i+1;
  }

  //this method chooses a random element of the array to be the pivot
  //this ensures that no matter the order of the array the quick sort will be fast(ish)
  //takes first and last index of array as params
  public void random(int p, int r){
    Random random = new Random();
    int pivot = random.nextInt(r - p) + p;

    String temp = this.arr[pivot];
    this.arr[pivot]=arr[r];
    this.arr[r]=temp;
  }

  //method to do quicksort
  //takes indices of the array ur sorting as params
  public void quickSort(int p, int r){
    //the index of the partition
    int part = 0;
    if (p < r){
      part = partition(p, r);
      quickSort(p, part - 1);
      quickSort(part + 1, r);
    }
  }



}
