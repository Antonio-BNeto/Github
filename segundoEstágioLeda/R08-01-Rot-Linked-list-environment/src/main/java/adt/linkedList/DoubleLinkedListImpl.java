package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl(){
		this.head = new DoubleLinkedListNode<>();
		this.last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void insertFirst(T element) {
		if(element != null){
			DoubleLinkedListNode<T> auxNode = new DoubleLinkedListNode<>(element,(DoubleLinkedListNode<T>) this.getHead(), new DoubleLinkedListNode<>());
			((DoubleLinkedListNode<T>)this.getHead()).setPrevious(auxNode);
			if(this.getHead().isNIL()){
				this.setLast(auxNode);
			}
			this.setHead(auxNode);
		}
	}

	@Override
	public void removeFirst() {
		if(!this.isEmpty()){
			this.setHead(this.getHead().getNext());
			if(this.getHead().isNIL()){
				this.setLast((DoubleLinkedListNode<T>)this.getHead());
			}else{
				((DoubleLinkedListNode<T>)this.getHead()).setPrevious(new DoubleLinkedListNode<>());
			}
		}
	}

	@Override
	public void removeLast() {
		if(!this.isEmpty()){
			this.getLast().setPrevious(this.getLast().getPrevious());
			if(this.getLast().isNIL()){
				this.setHead(this.getLast());
			}else{
				this.getLast().setNext(new DoubleLinkedListNode<>());
			}
		}
	}

	//Metodos sobreescritos

	@Override
	public T search(T element){
		T search = null;
		if(element != null && !this.isEmpty()){
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.getHead();
			DoubleLinkedListNode<T> auxLast = this.getLast();
			while(!auxHead.getData().equals(auxLast.getData()) && !auxHead.getNext().getData().equals(auxLast.getData())&&
			!auxHead.getData().equals(element) && !auxLast.getData().equals(element)){
				auxHead = (DoubleLinkedListNode<T>)auxHead.getNext();
				auxLast = auxLast.getPrevious();
			}
			if(!auxHead.isNIL()){
				search = auxHead.getData();
			}
			if(!auxLast.isNIL()){
				search = auxLast.getData();
			}
		}
		return search;
	}

	@Override
	public void insert(T element){
		if(element != null){
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<>(), this.getLast());
			if(this.isEmpty()){
				this.setHead(newLast);
			}
			this.setLast(newLast);
		}
	}

	@Override
	public void remove(T element){
		if(element != null && !this.isEmpty()){
			if(this.getHead().getData().equals(element)){
				removeFirst();
			}else if(this.getLast().getData().equals(element)){
				removeLast();
			}else{
				DoubleLinkedListNode<T> auxNode = (DoubleLinkedListNode<T>) this.getHead();
				while(!auxNode.isNIL() && !auxNode.getData().equals(element)){
					auxNode = (DoubleLinkedListNode<T>)auxNode.getNext();
				}
				if(!auxNode.isNIL()){
					auxNode.getPrevious().setNext(auxNode.getNext());
					((DoubleLinkedListNode<T>)auxNode.getNext()).setPrevious(auxNode.getPrevious());
				}
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
