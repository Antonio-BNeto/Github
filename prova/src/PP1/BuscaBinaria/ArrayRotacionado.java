package BuscaBinaria;

public class ArrayRotacionado {
    

    public int find(Integer[] array){
        return findMin(array, 0, array.length-1);
    }

    private Integer findMin(Integer[] array, int leftIndex, int rightIndex){
        if(leftIndex==rightIndex){
            return leftIndex;
        }
        int middle = (rightIndex+leftIndex)/2;
            
        if(array[middle].compareTo(array[rightIndex])>0){
            return findMin(array, middle+1, rightIndex);
        }else{
            return findMin(array, leftIndex, middle);
        }

    }
}
