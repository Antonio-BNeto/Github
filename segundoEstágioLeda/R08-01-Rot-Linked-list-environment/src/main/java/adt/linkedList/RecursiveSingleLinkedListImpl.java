package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		return this.getData() == null;
	}

	@Override
	public int size() {
		int size = 0;
		if(!this.isEmpty()){
			size = 1+ next.size();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T search = null;
		if(element != null && !this.isEmpty()){
			if(this.getData().equals(element)){
				search = this.getData();
			}else{
				search = next.search(element);
			}
		}
		return search;
	}

	@Override
	public void insert(T element) {
		if(element != null){
			if(this.isEmpty()){
				this.setData(element);
				this.setNext(new RecursiveSingleLinkedListImpl<>());
			}else{
				next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if(element != null && !this.isEmpty()){
			if(this.getData().equals(element)){
				this.setData(this.getNext().getData());
				this.setNext(this.next.getNext());
			}else{
				next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
