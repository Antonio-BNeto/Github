package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insertFirst(T element) {
	}

	@Override
	public void removeFirst() {
		if(!this.isEmpty()){
			if(this.next.isEmpty() && this.previous.isEmpty()){
				this.data = null;
				this.next = null;
				this.previous = null;
			}else{
				this.data = this.getNext().getData();
				this.next = this.next.getNext();
				((RecursiveDoubleLinkedListImpl<T>) this.next).setPrevious(this);
			}
		}
	}

	@Override
	public void removeLast() {
		if(!this.isEmpty()){
			if(this.next.isEmpty()){
				this.data = null;
				this.next = null;
				if(this.previous.isEmpty()){
					this.previous = null;
				}
			}else{
				((RecursiveDoubleLinkedListImpl<T>)this.next).removeLast();
			}
		}
	}

	//Metodos Sobreescritos

	@Override
	public void insert(T element){
		if(element != null){
			if(this.isEmpty()){
				this.setData(element);
				this.setNext(new RecursiveDoubleLinkedListImpl<>());
				if(this.getPrevious() == null){
					this.setPrevious(new RecursiveDoubleLinkedListImpl<>());
				}
			}else{
				next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element){
		if(element != null && !this.isEmpty()){
			if(this.getData().equals(element)){
				if(this.getPrevious() == null){
					removeFirst();
				}else if( this.getNext() == null){
					removeLast();
				}else{
					this.getPrevious().setNext(this.getNext());
					((RecursiveDoubleLinkedListImpl<T>)this.getNext()).setPrevious(this.getPrevious());
				}
			}
			next.remove(element);
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
