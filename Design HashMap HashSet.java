// hashset using bit manipulation (most optimal way)
class MyHashSet {
    int num[];
    public MyHashSet() {
        num = new int[31251];
    }
	
	// set the bit if that element is present
    public void add(int key) {
        num[getIdx(key)]|=getMask(key);
    }
	
	//unset the bit if a key is not present
    public void remove(int key) {
        num[getIdx(key)] &= (~getMask(key));
    }
	
	//check if bit corresponding to the key is set or not
    public boolean contains(int key) {
        return (num[getIdx(key)]&getMask(key))!=0;
    }
	
	// idx of num[] to which this key belongs
	// for key = 37, it will give 1
    private int getIdx(int key)
    {
        return (key/32);
    }
	
	// get mask representing the bit inside num[idx] that corresponds to given key.
	// for key = 37, it will give 00000000000000000000000000100000
    private int getMask(int key)
    {
        key%=32;
        return (1<<key);
    }
}

//hashset using arraylist (not so optimal way)
class MyHashSet {
    int n = 10000;
    List<Integer>[] arr;

    public MyHashSet() {
        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
    }

    public void add(int key) {
        int idx = key % n;
        if (!arr[idx].contains(key)) {
            arr[idx].add(key);
        }
    }

    public void remove(int key) {
        int idx = key % n;
        arr[idx].remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int idx = key % n;
        return arr[idx].contains(key);
    }
}

//design Hashmap using linkedlist 
class Node {
    int key;
    int val;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }
}

class MyHashMap {

    private Node[] map;

    public MyHashMap() {
        map = new Node[1000];
        for (int i = 0; i < 1000; i++) {
            map[i] = new Node(-1, -1);
        }
    }

    public void put(int key, int value) {
        int hash = hash(key);
        Node cur = map[hash];

        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next.val = value;
                return;
            }
            cur = cur.next;
        }

        cur.next = new Node(key, value);
    }

    public int get(int key) {
        int hash = hash(key);
        Node cur = map[hash].next;

        while (cur != null) {
            if (cur.key == key)
                return cur.val;
            cur = cur.next;
        }

        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        Node cur = map[hash];

        while (cur.next != null) {
            if (cur.next.key == key) {
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }

    private int hash(int key) {
        return key % 1000;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
