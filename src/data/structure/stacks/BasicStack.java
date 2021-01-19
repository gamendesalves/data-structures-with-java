package data.structure.stacks;

public class BasicStack<X> implements Stack<X> {

	private X[] data;
	private int stackPointer;

	@SuppressWarnings("unchecked")
	public BasicStack() {
		data = (X[]) new Object[1000];
		stackPointer = 0;
	}

	@Override
	public void push(X newItem) {
		data[stackPointer++] = newItem;
	}

	@Override
	public X pop() {
		if (stackPointer == 0) {
			throw new IllegalAccessError("No more itens on the stack");
		}

		return data[--stackPointer];
	}

	@Override
	public boolean contains(X item) {
		boolean found = false;

		// Basic Linear Function
		for (int i = 0; i < stackPointer; i++) {
			if (data[i].equals(item)) {
				found = true;
				break;
			}
		}

		return found;
	}

	@Override
	public X access(X item) {
		while (stackPointer > 0) {
			X tmpItem = pop();
			if (tmpItem.equals(item)) {
				return tmpItem;
			}
		}

		// if we didn't find the item in the stack throw on exception
		throw new IllegalAccessError("Could not find item on the stack " + item);
	}

	@Override
	public int size() {
		return stackPointer;
	}

}
