package simpleSort;

public class Insertion {
    
    public void sort(Integer[] array,int leftIndex,int rightIndex){
        for(int i = leftIndex+1;i<=rightIndex;i++){
            Integer key = array[i];
            int j = i-1;

            while(j>=leftIndex && array[j].compareTo(key)>0){
                array[j+1] = array[j];
                j = j-1;
            }
            array[j+1] = key;
        }
    }
}
