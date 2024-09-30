package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListRemoveDuplicatesImpl<T> implements LinkedListRemoveDuplicates<T>{

    /**
     * Restricoes extras:
     * - Você NÃO pode usar recursão
     * - Você pode criar métodos auxiliares se achar necessário, desde que sejam criados
     *   nesta classe
     * - A primeira ocorrencia de um elemento que tem duplicatas na lista é a que 
     *   permanece na lista.
     * - Caso o elemento tenha apenas uma ocorrencia, ela deve permanecer na lista. 
     * - A ordem dos elementos NÃO pode ser modificada. 
     * Exemplo:
     * remover as duplicatas da lista 3 -> 5 -> 1 -> 1 -> 5 -> 6 -> 5 -> NIL
     * transforma a lista em 3 -> 5 -> 1 -> 6 -> NIL
     */
    public void removeDuplicates(SingleLinkedListNode<T> node){
        SingleLinkedListNode<T> aux1 = node; 
        while (!aux1.isNIL()) {
            SingleLinkedListNode<T> aux2 = aux1.getNext();
            while(!aux2.isNIL()){
                if(aux2.getData().equals(aux1.getData())){
                    aux2.setData(aux2.getNext().getData());
                    aux2.setNext(aux2.getNext().getNext());;
                }else{
                    aux2 = aux2.getNext();
                }
            } 
            aux1 = aux1.getNext();
        }
    }
}

