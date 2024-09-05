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
			DoubleLinkedListNode<T> auxHead = new DoubleLinkedListNode<T>(element, (DoubleLinkedListNode<T>)this.getHead(),((DoubleLinkedListNode<T>)this.getHead()).getPrevious());
			((DoubleLinkedListNode<T>)this.getHead()).setPrevious(auxHead);
			if(this.getHead().isNIL()){
				this.setLast(auxHead);
			}
			this.setHead(auxHead);

		}
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()){
			this.setHead(this.getHead().getNext());
			if(this.getHead().isNIL()){
				this.setLast((DoubleLinkedListNode<T>)this.getHead());
			}
			((DoubleLinkedListNode<T>)this.getHead()).setPrevious(new DoubleLinkedListNode<T>());
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()){
			this.setLast(this.getLast().getPrevious());
			
			if(this.getLast().isNIL()){
				this.setHead(this.getLast());
			}
			this.getLast().setNext(new SingleLinkedListNode<>());			
		}
	}

	//Metodos sobreescritos

	@Override
	public T search(T element){
		T search = null;
		if(!isEmpty() && element != null){
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>)this.getHead();
			DoubleLinkedListNode<T> auxLast = this.getLast();
			while(auxHead != auxLast && auxHead.next != auxLast && auxHead.data != element && auxLast.data != element){
				
				auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
				auxLast = auxLast.getPrevious();
			}
			if(!auxHead.getData().equals(element)){
				search = auxHead.getData();
			}
			if(!auxLast.getData().equals(element)){
				search = auxLast.getData();
			}
		}
		return search;
	}

	@Override
	public void remove(T element){
		if(!isEmpty() && element != null){
			if(this.getHead().getData().equals(element)){
				removeFirst();
			}else if(this.getLast().getData().equals(element)){
				removeLast();
			}else{
				DoubleLinkedListNode<T> auxNode = (DoubleLinkedListNode<T>) this.getHead();
				while(!auxNode.isNIL() && auxNode.getData().equals(element)){
					auxNode = (DoubleLinkedListNode<T>)auxNode.getNext();
				}
				if(!auxNode.isNIL()){
					auxNode.getPrevious().setNext(auxNode.getNext());
					((DoubleLinkedListNode<T>)auxNode.getNext()).setPrevious(auxNode.getPrevious());
				}

			}
		}
	}

	public void insert(T element){
		if(element != null){
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<>(), this.getLast());
			this.last.setNext(newLast);
			if(this.getLast().isNIL()){
				this.setHead(this.getLast());
			}
			this.setLast(newLast);
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
