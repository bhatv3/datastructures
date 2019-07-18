class MyHashMap {
    int bucketSize = 1000;
    int itemsPerBucket = 1000;
    int[][] data;
    /** Initialize your data structure here. */
    public MyHashMap() {
        data = new int[bucketSize][];
    }
    
    private int bucket(int key){
        return key % bucketSize;
    }
    private int pos(int key){
        return key / itemsPerBucket;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucket = bucket(key);        
        
        if(data[bucket]==null){
            // data[bucket] = new int[itemsPerBucket + (bucket == 0? 1 : 0)];
            data[bucket] = new int[itemsPerBucket];
            Arrays.fill(data[bucket],-1);
        }
        data[bucket][pos(key)]=value;    
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = bucket(key);        
        
        if(data[bucket]!=null){
            return data[bucket][pos(key)];            
        }
        return -1;     
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = bucket(key);        
        
        if(data[bucket]!=null){
            data[bucket][pos(key)]=-1;
        }
    }
}
