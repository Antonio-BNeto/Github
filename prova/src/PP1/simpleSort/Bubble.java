package simpleSort;

import util.Util;

public class Bubble {
    
    public void sort(Integer[] array, int leftIndex, int rightIndex){
        if(leftIndex<=rightIndex){
            boolean swapped = true;
            while (swapped) {
                swapped = false;
                for(int i = leftIndex;i<rightIndex;i++){
                    if(array[i].compareTo(array[i+1])>0){
                        Util.swap(array, i, i+1);
                        swapped = true;
                    }
                }    
                rightIndex--;    
            }
        }
    }
}
