package Dictionary;

public interface DictionaryInterface<K, V> {

    // Can be used to replace
    public V add(K key, V value);

    public V remove(K key);

    public V getValue(K key);

    public boolean contains(K keys);

    public Iterator<K> getKeyIterator();

    public Iterator<V> getValueIterator();

    public boolean isEmpty();

    public 
}
