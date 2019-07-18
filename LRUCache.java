class LRUCache {
    
    Map<Integer,Node> cache;
    int capacity;
    Node head;
    Node tail;
    int count;
    
    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = tail;
        this.tail.prev = head;        
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node != null){
            deleteNode(node);
            addToHead(node);
            return node.value;
        }        
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node == null){
            // Create
            Node newNode = new Node(key, value);
            cache.put(newNode.key, newNode);
            if(count<capacity){
                count++;        
                addToHead(newNode);
            }else{
                cache.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(newNode);
            }
            
        }else{
            // Update            
            deleteNode(node);
            node.value = value;
            addToHead(node);            
        }
    }
    
    private void addToHead(Node node){
        node.next = head.next;
        head.next.prev = node;
        
        head.next = node;
        node.prev = head;
    }
    
    private void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private class Node{
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int k, int v){
            this.key = k;
            this.value = v;
        }
    }
}
