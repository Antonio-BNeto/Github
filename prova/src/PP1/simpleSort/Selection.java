package simpleSort;

import util.Util;

public class Selection {
    
    public void sort(Integer[] array, int leftIndex, int rightIndex){
        
        for(int i = leftIndex;i<=rightIndex;i++){
            Integer min = array[i];
            
            for(int j = i+1;j<=rightIndex;j++){
                if(array[j].compareTo(min)<0){
                    Util.swap(array, i, j);
                }
            }
        }

    }
}
