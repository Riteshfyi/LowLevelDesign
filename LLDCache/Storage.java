public interface Storage<Key,Value>{
    void put(Key key, Value value);
    Value get(Key key);
    boolean containsKey(Key key);
    void remove(Key key);
    boolean isFull();
}
