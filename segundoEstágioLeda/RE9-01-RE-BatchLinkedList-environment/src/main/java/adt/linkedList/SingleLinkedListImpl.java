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
		while (!aux.isNIL()) {
			size++;
			aux = aux.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T search = null;
		if(!this.isEmpty() && element != null){
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
			SingleLinkedListNode<T> auxHead = this.getHead();

			if(this.isEmpty()){
				SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<>());
				this.setHead(newHead);
			}else{
				while(!auxHead.isNIL()){
					auxHead = auxHead.getNext();
				}

				auxHead.setData(element);
				auxHead.setNext(new SingleLinkedListNode<>());
			}
			
		}
	}

	@Override
	public void remove(T element) {
		if(!this.isEmpty() && element != null){
			if(this.getHead().getData().equals(element)){
				this.setHead(this.head.getNext());
			}else{
				SingleLinkedListNode<T> auxNode = this.getHead();
				while(!auxNode.isNIL() && auxNode.getData().equals(element)){
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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
