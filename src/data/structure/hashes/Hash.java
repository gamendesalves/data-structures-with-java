package data.structure.hashes;

public interface Hash<K, V> {
	
	V get(K key);
	
	void put(K key, V value);
	
	V delete(K key);
	
	boolean hasKey(K key);
	
	boolean hasValue(V value);
	
	int size();
}
