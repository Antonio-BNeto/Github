package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.getHead().isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = this.getHead();
		while(!aux.isNIL()){
			size ++;
			aux = aux.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T search = null;
		if(element != null && !this.isEmpty()){
			SingleLinkedListNode<T> auxNode = this.getHead();
			while(!auxNode.isNIL() && !auxNode.getData().equals(element)){
				auxNode = auxNode.getNext();
			}
			if(!auxNode.isNIL()){
				search = auxNode.getData();
			}
		}
		return search;
	}

	@Override
	public void insert(T element) {
		if(element != null){
			SingleLinkedListNode<T> aux = this.getHead();
			if(this.isEmpty()){
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<>());
				this.setHead(newHead);
			}else{
				while (!aux.isNIL()) {
					aux = aux.getNext();
				}
				aux.setData(element);
				aux.setNext(new SingleLinkedListNode<>());
			}
		}
	}

	@Override
	public void remove(T element) {
		if(element!= null && !this.isEmpty()){
			SingleLinkedListNode<T> auxNode = this.getHead();
			while(!auxNode.isNIL() && !auxNode.getData().equals(element)){
				auxNode = auxNode.getNext();
			}
			if(!auxNode.isNIL()){
				auxNode.setData(auxNode.getNext().getData());
				auxNode.setNext(auxNode.next.getNext());
			}
		}
		
	}

	@Override
	public T[] toArray() {
		T[] array =(T[]) new Object[this.size()];
		SingleLinkedListNode<T> auxNode = this.getHead();
		int cont = 0;
		
		while(!auxNode.isNIL()){
			array[cont] = auxNode.getData();
			cont ++;
			auxNode = auxNode.getNext();
		} 
		return array;
	} 

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
