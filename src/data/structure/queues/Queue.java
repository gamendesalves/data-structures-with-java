package data.structure.queues;

public interface Queue<X> {
	
	void enQueue(X item);

	X deQueue();
	
	boolean contains(X item);
	
	X access(int position);
	
	int size();
}
