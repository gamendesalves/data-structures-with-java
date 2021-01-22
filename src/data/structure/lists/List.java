package data.structure.lists;

public interface List<X> {

	void add(X item);
	
	void insert(X item, int position);
	
	X removeAt(int position);
	
	X get(int position);
	
	int find(X item);
	
	X remove();
	
	int size();
}
