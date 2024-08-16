package EstatisticaDeOrdem;

import util.Util;

public class quickSelect {
    
    public Integer quickSelect(Integer[] array, int k){
        Integer result = null;
        if(array.length != 0 && k<=array.length && k>0){
            result = select(array, 0, array.length-1, k);
        }
        return result;
    }

    private Integer select(Integer[] array, int leftIndex, int rightIndex, int k){

        if(leftIndex==rightIndex){
            return array[leftIndex];
        }

        medianOfThree(array, leftIndex, rightIndex);
        int pivot = partition(array, leftIndex+1, rightIndex-1);

        Integer result; 

        if (pivot == k-1) {
            result = array[pivot];

        }else if(pivot < k-1){
            result = select(array, pivot+1, rightIndex, k);
        }else{
            result = select(array, leftIndex, pivot-1, k);
        }

        return result;
    }

    private void medianOfThree(Integer[] array, int leftIndex, int rightIndex){
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


    private int partition(Integer[] array, int leftIndex, int rightIndex){
        int pivot = array[leftIndex];
        int i = leftIndex;

        for(int j=i+1;j<=rightIndex;j++){
            if(array[j].compareTo(pivot)<=0){
                i++;
                Util.swap(array, i, j);
            }
        }

        Util.swap(array, leftIndex, i);

        return  i;

    }

}
