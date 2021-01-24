package data.structure.hashes;

public class BasicHashTable<K, V> implements Hash<K, V> {

	private HashEntry<?, ?>[] data;
	private int capacity;
	private int size;

	public BasicHashTable(int tableSize) {
		this.capacity = tableSize;
		this.data = new HashEntry[capacity];
		this.size = 0;
	}

	public V get(K key) {
		int hash = calculateHash(key);

		// if we don't have anything for the given key, just return null
		if (data[hash] == null) {
			return null;
		}
		// Otherwise get the hashentry for the key and return its value
		else {
			return (V) data[hash].getValue();
		}
	}

	public void put(K key, V value) {
		int hash = calculateHash(key);

		data[hash] = new HashEntry<K, V>(key, value);
		size++;
	}

	public V delete(K key) {
		// first get the value for this key so it can be returned
		V value = get(key);

		// clear out the hashtable slot for the key and return the removed value
		if (value != null) {
			int hash = calculateHash(key);
			data[hash] = null;
			size--;
			hash = (hash + 1) % this.capacity;

			// if the enxt slot isn"t empty we should add it so we can keep the hash
			// algorithms clean
			while (data[hash] != null) {
				HashEntry<?, ?> he = data[hash];
				data[hash] = null;
				put((K) he.getKey(), (V) he.getValue());

				// we repositioned the hash item and didn't really add a new one so back of size
				size--;
				hash = (hash + 1) % this.capacity;
			}

		}

		return value;
	}

	public boolean hasKey(K key) {
		boolean found = false;

		if (size() == 0) {
			return found;
		}

		int hash = calculateHash(key);

		if (data[hash] == null) {
			found = false;
		}
		// if this hash entry key is equals the one passed in, the hash table has the
		// key
		else if (data[hash].getKey().equals(key)) {
			found = true;
		}

		return found;
	}

	public boolean hasValue(V value) {
		// loop through all of the hash entries
		for (int i = 0; i < this.capacity; i++) {
			HashEntry entry = data[i];

			// if this hash entry isn't null and the value equals the one passed in, the
			// hash table has this value
			if (entry != null && entry.getValue().equals(value)) {
				return true;
			}
		}

		return false;
	}

	public int size() {
		return this.size;
	}

	private int calculateHash(K key) {
		int hash = (key.hashCode() % this.capacity);

		// this is necessary to deal with collisions
		while (data[hash] != null && !data[hash].getKey().equals(key)) {
			hash = (hash + 1) % this.capacity;
		}

		return hash;
	}

	private class HashEntry<K, V> {
		private K key;
		private V value;

		public HashEntry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

	}
}
