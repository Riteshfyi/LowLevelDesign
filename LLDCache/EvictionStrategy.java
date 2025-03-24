public interface EvictionStrategy <E>{
    public E getKey();

    public void updateKey(E Key);

    public void removeKey(E Key);

}
