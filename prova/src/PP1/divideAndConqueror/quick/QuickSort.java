package divideAndConqueror.quick;

import util.Util;

public class QuickSort {
    
    public void sort(Integer[] array, int leftIndex, int rightIndex){
        if(leftIndex<rightIndex){
            int partition = partition(array, leftIndex, rightIndex);

            sort(array, leftIndex, partition-1);
            sort(array, partition+1, rightIndex);
        }
    }

    public int partition(Integer[] array, int leftIndex, int rightIndex){
        Integer pivot = array[leftIndex];
        int i = leftIndex;

        for(int j = i+1;j<=rightIndex;j++){
            if (array[j].compareTo(pivot)<=0) {
                i++;
                Util.swap(array, i, j);
            }
        }

        Util.swap(array, leftIndex, i);

        return i;

    }
}