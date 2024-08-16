package BuscaBinaria;

import util.Util;

public class FirsAndLastRepetition {
    
    public String firstAndLast(Integer[] array, Integer k){
        String result = "Não tem";
        boolean temElemento = existe(array, k); 
        if(array != null && array.length > 0 && k != null && temElemento){
            quickSort(array, 0, array.length-1);
            result = "first: " + first(array, k, 0, array.length-1);
            result += " last: " + last(array, k, 0, array.length-1);
        }
        return result;
    }

    private int first(Integer[] array,Integer k ,int leftIndex, int rightIndex){
        int result = -1;
        if(leftIndex <= rightIndex){
            int middle = (rightIndex+leftIndex)/2;

            if(array[0].compareTo(k)==0){
                result = 0;
            }else if(array[middle] == k){
                if (array[middle-1].compareTo(k)<0) {
                    result = middle;
                }else{
                    result = first(array, k, leftIndex, middle-1);
                }

            }else if(array[middle].compareTo(k)>0){
                result = first(array, k, leftIndex, middle-1);
            }else{
                result = first(array, k, middle+1, rightIndex);
            }

        }
        return result;
    }

    private int last(Integer[] array,Integer k, int leftIndex, int rightIndex){
        int result = -1;

        if(leftIndex<= rightIndex){
            
            int middle = (rightIndex+leftIndex)/2;

            if(array[array.length-1].compareTo(k)==0){
                result = array.length-1;

            }else if(array[middle].compareTo(k)==0){
                if(array[middle+1].compareTo(k)>0){
                    result = middle;
                }else{
                    result = last(array, k, middle+1, rightIndex);
                }
            }else if(array[middle].compareTo(k)<0){
                result = last(array, k, middle+1, rightIndex);
            }else{
                result = last(array, k, leftIndex, middle-1);
            }
        }
        return result;
    }

    private void quickSort(Integer[] array, int leftIndex, int rightIndex){
        if(leftIndex==rightIndex || leftIndex < 0|| leftIndex>rightIndex || rightIndex>array.length ){

        }else{
            medianOfThree(array, leftIndex, rightIndex);
            int pivotIndex = partition(array, leftIndex+1, rightIndex-1);
            quickSort(array, leftIndex, pivotIndex-1);
            quickSort(array, pivotIndex+1, rightIndex); 
        }
    }

    private void medianOfThree(Integer[] array, int leftIndex, int rightIndex){
        int middle = (rightIndex + leftIndex)/2;

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
        int pivot = leftIndex;
        int i = leftIndex;

        for(int j = i+1; j<=rightIndex;j++){
            if(array[j].compareTo(array[pivot]) <= 0){
                i++;
                Util.swap(array, i, j);
            }
        }

        Util.swap(array, pivot, i);

        return i;
    }

    private boolean existe(Integer[] array, Integer k){
        for(int i = 0; i<array.length; i++){
            if(array[i].compareTo(k)==0){
                return true;
            }
        }
        return false;
    }

}
