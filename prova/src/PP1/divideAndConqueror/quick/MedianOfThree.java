package divideAndConqueror.quick;

import util.Util;

public class MedianOfThree {
    
    public void sort(Integer[] array, int leftIndex, int rightIndex){
        if(leftIndex == rightIndex || leftIndex<0 || leftIndex>rightIndex || rightIndex>array.length){

        }else{
            medianOfThree(array, leftIndex, rightIndex);
            int pivotIndex = partition(array, leftIndex+1, rightIndex-1);
            sort(array, leftIndex, pivotIndex-1);
            sort(array, pivotIndex+1, rightIndex);
        }
    }
    
    public int partition(Integer[] array, int leftIndex, int rightIndex){
        Integer pivot = array[leftIndex];
        int i = leftIndex;

        for(int j = i+1; j<=rightIndex; j++){
            if(array[j].compareTo(pivot)<=0){
                i++;
                Util.swap(array, i, j);
            }
        }

        Util.swap(array, leftIndex, i);

        return i;
    }

    public void medianOfThree(Integer[] array, int leftIndex, int rightIndex){
        int middle = (leftIndex+rightIndex)/2;

        if(array[leftIndex].compareTo(array[rightIndex])>0){
            Util.swap(array, leftIndex, rightIndex);
        }
        if(array[leftIndex].compareTo(array[middle])>0){
            Util.swap(array, leftIndex, middle);
        }
        if(array[middle].compareTo(array[rightIndex])>0){
            Util.swap(array, middle, rightIndex);
        }

        if(rightIndex-leftIndex>=2){
            Util.swap(array, leftIndex+1, middle);
        }
    }
}
