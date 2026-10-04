import java.util.HashMap;
import java.util.Map;

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

    private final int capacity;
    private final Map<Integer, Node> cache;

    // Dummy nodes:
    // head.next = Most Recently Used node
    // tail.prev = Least Recently Used node
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);

        // Accessing a key makes it most recently used
        remove(node);
        insertAtFront(node);

        return node.value;
    }

    public void put(int key, int value) {
        // If key already exists, remove its old node first
        if (cache.containsKey(key)) {
            Node oldNode = cache.get(key);
            remove(oldNode);
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insertAtFront(newNode);

        // If capacity is exceeded, remove least recently used node
        if (cache.size() > capacity) {
            Node lru = tail.prev;

            remove(lru);
            cache.remove(lru.key);
        }
    }

    // Insert a node immediately after head
    private void insertAtFront(Node node) {
        Node firstNode = head.next;

        node.next = firstNode;
        node.prev = head;

        head.next = node;
        firstNode.prev = node;
    }

    // Remove a node from its current position
    private void remove(Node node) {
        Node previousNode = node.prev;
        Node nextNode = node.next;

        previousNode.next = nextNode;
        nextNode.prev = previousNode;
    }
}