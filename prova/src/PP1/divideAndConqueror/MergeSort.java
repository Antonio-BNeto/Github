package divideAndConqueror;

public class MergeSort {
    public void sort(Integer[] array, int leftIndex, int rightIndex){

        if(leftIndex<rightIndex){
            int middle = (leftIndex+rightIndex)/2;

            sort(array, leftIndex, middle);
            sort(array, middle+1, rightIndex);

            merge(array, leftIndex, middle, rightIndex);
        }

    }   

    private void merge(Integer[] array, int leftIndex,int middle, int rightIndex){   
        Integer[] merge = new Integer[array.length];

        for(int i = leftIndex;i<=rightIndex; i++){
            merge[i] = array[i];
        }

        int i = leftIndex;
        int j = middle+1;
        int k = leftIndex;

        while(i<=middle && j<=rightIndex){

            if(merge[i].compareTo(merge[j])>0){
                array[k] = merge[j];
                j++;

            }else{
                array[k] = merge[i];
                i++;
            }
            k++;
        }

        while (i<=middle) {
            array[k] = merge[i];
            k++;
            i++;
        }
    }
}
