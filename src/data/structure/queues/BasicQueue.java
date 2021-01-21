package data.structure.queues;

public class BasicQueue<X> implements Queue<X> {
	private X[] data;
	private int front;
	private int end;

	public BasicQueue() {
		this(1000);
	}

	@SuppressWarnings("unchecked")
	public BasicQueue(int size) {
		this.front = -1;
		this.end = -1;
		data = (X[]) new Object[size];
	}

	public void enQueue(X item) {
		// firt see if queue is full
		if ((end + 1) % data.length == front) {
			throw new IllegalStateException("The Queue is full");
		}

		// Otherwise check to see if any items have been added to the queue yet
		else if (size() == 0) {
			front++;
			end++;
			data[end] = item;
		}

		// Otherwise add the item to the end of the queue
		else {
			end++;
			data[end] = item;
		}
	}

	public X deQueue() {
		X item = null;

		// if the queue is empty we can't dequeue anything
		if (size() == 0) {
			throw new IllegalStateException("Can't dequeue because the item is empty");

			// Otherwise if this is the last item on the queue needs to get reset to empty
		} else if (front == end) {
			item = data[front];
			data[front] = null;
			front = -1;
			end = -1;

			// Otherwise grab the front of the queue, return it and adjust the front pointer
		} else {
			item = data[front];
			data[front] = null;
			front++;
		}
		
		return item;
	}

	public boolean contains(X item) {
		boolean found = false;

		// if the queue is empty just immediately return false
		if (size() == 0) {
			return found;
		}

		// Basic Linear Function
		for (int i = front; i < end; i++) {
			if (data[i].equals(item)) {
				found = true;
				break;
			}
		}

		return found;
	}

	public X access(int position) {

		if (size() == 0 || position > size()) {
			throw new IllegalStateException("No Items in the queue or the position is greater than queue");
		}

		int trueIndex = 0;
		for (int i = front; i < end; i++) {
			if (trueIndex == position) {
				return data[i];
			}
			trueIndex++;
		}

		throw new IllegalStateException("Could not get queue item at position" + position);
	}

	public int size() {

		// if the queue is empty return 0
		if (front == -1 && end == -1) {
			return 0;
		} else {
			return end - front + 1;
		}
	}

}
