public interface EvictionStrategy {
    public Object getKey();

    public void updateKey(Object Key);

    public void removeKey(Object Key);

}
