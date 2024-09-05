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
			DoubleLinkedListNode<T> auxHead = new DoubleLinkedListNode<T>(element, (DoubleLinkedListNode<T>)this.getHead(), new DoubleLinkedListNode<T>());
			((DoubleLinkedListNode<T>) this.getHead()).setPrevious(auxHead);
			if(this.getHead().isNIL()){
				this.setLast(auxHead);;
			}
			this.setHead(auxHead);
		}
	}

	@Override
	public void removeFirst() {
		if(!this.isEmpty()){
			this.setHead(this.getHead().getNext());
			if(this.getHead().isNIL()){
				this.setLast((DoubleLinkedListNode<T>) this.getHead());
			}else{
				((DoubleLinkedListNode<T>)this.getHead()).setPrevious(new DoubleLinkedListNode<>());
			}

		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()){
			this.setLast(this.getLast().getPrevious());
			if(this.getLast().isNIL()){
				this.setHead(this.getLast());
			}else{
				this.getLast().setNext(new DoubleLinkedListNode<T>());
			}
		}
	}

	//Metodos sobreescritos

	@Override
	public T search(T element){
		T search = null;
		if(!this.isEmpty() && element != null){
			DoubleLinkedListNode<T> auxHead =(DoubleLinkedListNode<T>) this.getHead();
			DoubleLinkedListNode<T> auxLast = this.getLast();

			while(!auxHead.getData().equals(auxLast.getData()) && auxHead.next.getData().equals(auxLast.getData()) && 
			!auxHead.getData().equals(element) && !auxLast.getData().equals(element)){
				auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
				auxLast = auxLast.getPrevious();
			}
			if(auxHead.getData().equals(element)){
				search = auxHead.getData();
			}
			if(auxLast.getData().equals(element)){
				search = auxLast.getData();
			}

		}
		return search;

	}

	@Override
	public void insert(T element){
		if(element != null){
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>() , this.last);
			this.last.setNext(newLast);
			if(this.isEmpty()){
				this.setHead(newLast);;;
			}
			last = newLast;
		}
	}

	@Override
	public void remove(T element){
		if(element != null){
			if(this.head.getData().equals(element)){
				removeFirst();
			}else{
				DoubleLinkedListNode<T> auxNode = (DoubleLinkedListNode<T>) this.getHead();
				while (!auxNode.isNIL() && !auxNode.getData().equals(element)) {
					auxNode = (DoubleLinkedListNode<T>) auxNode.getNext();
				}
				if(!auxNode.isNIL()){
					auxNode.previous.setNext(auxNode.next.getNext());
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
