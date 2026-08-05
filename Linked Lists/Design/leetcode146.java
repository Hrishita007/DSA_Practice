//LRU Cache
//time complexity: O(1) for get and put operations
//space complexity: O(capacity) for storing the cache entries
import java.util.HashMap;
class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map;

    Node head;
    Node tail;

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
    }

    public int get(int key) {

        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {
        if(capacity==0)  return;
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            remove(node);
            insert(node);
        }else {
            if(map.size()==capacity){
                Node lru = head.next;
                remove(lru);
                map.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            insert(newNode);
            map.put(key, newNode);
        }
    }
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */