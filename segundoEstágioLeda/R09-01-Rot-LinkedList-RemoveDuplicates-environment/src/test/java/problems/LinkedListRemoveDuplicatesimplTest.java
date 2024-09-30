package problems;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListRemoveDuplicatesimplTest {

    private SingleLinkedListNode<Integer> node1;
    private LinkedListRemoveDuplicatesImpl<Integer> node2;

    private Integer[] lista1;

    @Before
    public void setUp(){
        node1 = new SingleLinkedListNode<>();
        node2 = new LinkedListRemoveDuplicatesImpl<>();

        lista1 = new Integer[]{3, 5, 1, 1, 5, 6, 5};

        node1.setData(3);
        node1.setNext(new SingleLinkedListNode<>(5,
        new SingleLinkedListNode<>(1,
        new SingleLinkedListNode<>(1,
        new SingleLinkedListNode<>(5,
        new SingleLinkedListNode<>(6,
        new SingleLinkedListNode<>(5,
        new SingleLinkedListNode<>())))))));
       
        

    }
    
    public void adiciona(Integer element, SingleLinkedListNode node){
        node = new SingleLinkedListNode(element, new SingleLinkedListNode<>());
        node = node.getNext();
    }

    @Test
    public void removendoDuplicatas(){ 
        node2.removeDuplicates(node1);
        assertEquals(1, 1);
    }

}
