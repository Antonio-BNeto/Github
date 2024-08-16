package BuscaBinaria;

import util.Util;

public class FloorBinarySearch {
    
    public Integer floor(Integer[] array, Integer x){
        if(array != null && array.length>0 && x != null){
            quickSort(array, 0, array.length-1);
            return floorBinarySearch(array, x, 0, array.length-1);
        }
        return null;
    }

    private Integer floorBinarySearch(Integer[] array,Integer x, int leftIndex, int rightIndex){
        Integer result = null;

        if(leftIndex<=rightIndex&& array[0].compareTo(x)<=0){
            
            int middle = (rightIndex+leftIndex)/2;
            
            if(array[rightIndex].compareTo(x)<=0){
                result = array[rightIndex];

            }else if(array[middle].compareTo(x)==0){
                result = array[middle];

            }else if(array[middle].compareTo(x)>0){

                if(array[middle-1].compareTo(x)<0){
                    result = array[middle-1];

                }else{
                    result = floorBinarySearch(array, x, leftIndex, middle-1);
                }
            }else{
                result = floorBinarySearch(array, x, middle+1, rightIndex);
            }

        }

        return result;
    }

    private void quickSort(Integer[] array, int leftIndex, int rightIndex){
        if(leftIndex == rightIndex || leftIndex< 0|| leftIndex>rightIndex || rightIndex>array.length){

        }else{
            medianOfThree(array, leftIndex, rightIndex);
            int pivot = partition(array, leftIndex+1, rightIndex-1);
            quickSort(array, leftIndex, pivot-1);
            quickSort(array, pivot+1, rightIndex);
        }
    }

    private void medianOfThree(Integer[] array, int leftindex, int rightIndex){
        int middle = (leftindex+rightIndex)/2;

        if(array[leftindex].compareTo(array[rightIndex])>0){
            Util.swap(array, leftindex, rightIndex);
        }
        if(array[leftindex].compareTo(array[middle])>0){
            Util.swap(array, leftindex, middle);
        }
        if(array[middle].compareTo(array[rightIndex])>0){
            Util.swap(array, middle, rightIndex);
        }

        if(rightIndex-leftindex>=2){
            Util.swap(array, leftindex+1, middle);
        }
    }

    private int partition(Integer[] array, int leftIndex, int rightIndex){
        Integer pivot = array[leftIndex];
        int i = leftIndex;

        for(int j=i+1; j<=rightIndex;j++){
            if(array[j].compareTo(pivot)<=0){
                i++;
                Util.swap(array, i, j);
            }
        }
        Util.swap(array, leftIndex, i);

        return i;
    }

}
