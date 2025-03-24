import java.util.HashMap;

public class LRUStrategy<E> implements EvictionStrategy<E>{
    class Node{
        E nodeKey;
        Node prev;
        Node next;
        public Node(E Key){
            nodeKey = Key;
            prev = null;
            next = null;
        }
        public void setPrev(Node prev){
            this.prev = prev;
        }
        public void setNext(Node next){
            this.next = next;
        }
    }
    private HashMap<E,Node> mp;
    private Node head;
    private Node tail;

    public LRUStrategy(){
        head = new Node(null);
        tail = new Node(null);
        head.next = tail;
        tail.prev = head;
        mp = new HashMap<>();
    }

    @Override
    public synchronized E getKey() {
        if(head.next == tail)return null;
        return head.next.nodeKey;
    }

    @Override
    public synchronized void updateKey(E Key){
        //this node was used
        //set it to the end
        if(!mp.containsKey(Key))mp.put(Key,new Node(Key));
        Node node = mp.get(Key);
        remove(node);
        insert(node);
    }
    @Override
    public synchronized void removeKey(E Key){
        Node node = mp.get(Key);
        remove(node);
        mp.remove(Key);
    }
    // least recently used one is at the head, while the most recently used is at the tail

    public void remove(Node node) {
        if (node == null || node.prev == null || node.next == null) return; // Avoid NullPointerException
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node){
         //ye node insert krna hai
        tail.prev.next = node;
        node.prev  = tail.prev;
        node.next = tail;
        tail.prev = node;
    }
    //FIFO
    //LRU CACHE
}
