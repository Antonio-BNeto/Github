package adt.linkedList.special;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class SpecialLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SpecialLinkedList<T> {

	@Override
	public void swap(T elem1, T elem2) {
		if(!isEmpty() && elem1 != null && elem2!=null){
			SingleLinkedListNode<T> auxNode = this.getHead();

			SingleLinkedListNode<T> nodeElem1 = null;
			SingleLinkedListNode<T> nodeElem2 = null;

			while(!auxNode.isNIL()){
				if(auxNode.getData().equals(elem1)){
					nodeElem1 = auxNode;
				}
				if(auxNode.getData().equals(elem2)){
					nodeElem1 = auxNode;
				}
				auxNode = auxNode.getNext();
			}

			if(nodeElem1 != null && nodeElem2 != null){
				T auxValue = nodeElem1.getData();
				nodeElem1.setData(nodeElem2.getData());;
				nodeElem2.setData(auxValue);
			}
		}
	}

	@Override
	public T elementFromTheEnd(int k) {
		return null;
	}
}
