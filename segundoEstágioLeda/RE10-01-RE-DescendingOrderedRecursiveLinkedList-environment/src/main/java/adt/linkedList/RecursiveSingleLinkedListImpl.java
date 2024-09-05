package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		boolean vazia = false;
		if(this.getData() == null){
			vazia = true;
		}
		return vazia;
	}

	@Override
	public int size() {
		int size = 0;
		if(!isEmpty()){
			size = 1 + next.size();
		}
		return size;
	}

	@Override
	public T search(T element) {
		T search = null;
		if(element!= null && !this.isEmpty()){
			if(this.data.equals(element)){
				return this.data;
			}else{
				next.search(element);
			}
		}
		return search;
	}

	@Override
	public void insert(T element) {
		if(element != null){
			if(isEmpty()){
				setData(element);
				setNext(new RecursiveSingleLinkedListImpl<>());
			}else{
				next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if(element != null && !isEmpty()){
			if(this.data.equals(element)){
				setData(next.getData());
				setNext(next.getNext());
			}else{
				next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[size()];
		toArray(array, 0);
		return array;
	}

	private void toArray(T[] array, int i){
		if(!this.isEmpty()){
			array[i] = this.getData();
			this.next.toArray(array, i+1);
		}
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
