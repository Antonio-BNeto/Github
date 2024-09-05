package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		if(!isEmpty()){
			SingleLinkedListNode<T> aux = this.head;
			while(!aux.isNIL()){
				size++;
				aux = aux.getNext();
			}
		}	
		return size;	
	}

	@Override
	public T search(T element) {
		T result = null;
		if(!isEmpty() && element != null){
			SingleLinkedListNode<T> auxNode = this.head;
			while(!auxNode.isNIL() && !auxNode.getData().equals(element)){
				auxNode = auxNode.getNext();
			}
			result = auxNode.getData();
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if(element != null){
			SingleLinkedListNode<T> aux = head;
			if(this.head.isNIL()){
				SingleLinkedListNode<T> aux2 = new SingleLinkedListNode<>(element, this.head);
				this.head = aux2;
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
		if(!isEmpty() && element != null){
			SingleLinkedListNode<T> auxNode = this.head;
			if(this.head.getData().equals(element)){
				this.head = this.head.getNext();
			}else{
				while(!auxNode.isNIL() && !auxNode.getData().equals(element)){
					auxNode = auxNode.getNext();
				}
				if(!auxNode.isNIL()){
					auxNode.setData(auxNode.getNext().getData());
					auxNode.setNext(auxNode.next.getNext());
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] lista = (T[]) new Object[size()]; 
		SingleLinkedListNode<T> aux = this.head;
		int cont  = 0;
		while(!aux.isNIL()){
			lista[cont++] = aux.getData();
			aux = aux.getNext();
		}

		return lista;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
