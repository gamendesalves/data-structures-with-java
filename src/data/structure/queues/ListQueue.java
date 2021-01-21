package data.structure.queues;

import java.util.ArrayList;
import java.util.List;

public class ListQueue<X> implements Queue<X> {

	private List<X> data;
	private int front;
	
	public ListQueue() {
		this(1000);
	}

	public ListQueue(int initialCapacity) {
		front = 0;
		data = new ArrayList<>(initialCapacity);
	}

	@Override
	public void enQueue(X item) {
		data.add(item);
	}

	@Override
	public X deQueue() {
		X item = null;

		if (size() == 0) {
			throw new IllegalStateException("Can't dequeue because the item is empty");
		} else {
			item = data.get(front);
			data.remove(front);
		}

		return item;
	}

	@Override
	public boolean contains(X item) {
		return data.contains(item);
	}

	@Override
	public X access(int position) {
		return data.get(position);
	}

	@Override
	public int size() {
		return data.size();
	}

}
