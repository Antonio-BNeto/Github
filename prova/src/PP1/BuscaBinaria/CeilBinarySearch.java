package BuscaBinaria;

import util.Util;

public class CeilBinarySearch {
    public Integer ceil(Integer[] array, Integer k){
        Integer result = null; 
        if(array != null && array.length>0 && k != null){
            quickSort(array, 0, array.length-1);
            result = ceilBinarySearch(array, k, 0, array.length-1);
        }
        return result;
    }

    private Integer ceilBinarySearch(Integer[] array, Integer k, int leftIndex, int rightIndex){
        Integer result = null;
        if(leftIndex<=rightIndex){
            int middle = (rightIndex+leftIndex)/2;

            if (array[leftIndex].compareTo(k)>=0) {
                result = array[leftIndex];

            }else if(array[middle].compareTo(k)==0){
                result = array[middle];

            }else if(array[middle].compareTo(k)>0){
                if (array[middle-1].compareTo(k)<0) {
                    result = array[middle];

                }else{
                    result = ceilBinarySearch(array, k, leftIndex, middle-1);
                }
            }else{
                result = ceilBinarySearch(array, k, middle+1, rightIndex);
            }
        }
        return result;
    }

    public void quickSort(Integer[] array, int leftIndex, int rightIndex){
        if(leftIndex == rightIndex || leftIndex<0 || leftIndex>rightIndex || rightIndex>array.length){
        }else{
            medianOfThree(array, leftIndex, rightIndex);
            int pivotIndex = partition(array, leftIndex+1, rightIndex-1);

            quickSort(array, leftIndex, pivotIndex-1);
            quickSort(array, pivotIndex+1, rightIndex);
        }
    }

    private void medianOfThree(Integer[] array, int leftIndex, int rightIndex){
        int middle = (rightIndex+leftIndex)/2;

        if(array[leftIndex].compareTo(array[rightIndex])>0){
            Util.swap(array, leftIndex, rightIndex);
        }
        if(array[leftIndex].compareTo(array[middle])>0){
            Util.swap(array, leftIndex, middle);
        }
        if(array[middle].compareTo(array[rightIndex])>0){
            Util.swap(array, middle, rightIndex);
        }

        if(rightIndex-leftIndex >= 2){
            Util.swap(array, leftIndex+1, middle);
        }
    }

    private int partition(Integer[] array, int leftIndex, int rightIndex){
        int pivot = leftIndex;
        int i = leftIndex;

        for(int j = i+1; j<=rightIndex;j++){
            if(array[j].compareTo(array[pivot])<=0){
                i++;
                Util.swap(array, i, j);
            }
        }

        Util.swap(array, leftIndex, i);

        return i;

    }
}
