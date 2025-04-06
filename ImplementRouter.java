class Router {
int memoryLimit;
    Queue<Packet> packetQueue;
    Set<String> packetSet;
    Map<Integer, OST> destMap;
    
    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        packetQueue = new LinkedList<>();
        packetSet = new HashSet<>();
        destMap = new HashMap<>();
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "," + destination + "," + timestamp;
        if (packetSet.contains(key))
            return false;
        if (packetQueue.size() == memoryLimit) {
            Packet rem = packetQueue.poll();
            String remKey = rem.source + "," + rem.destination + "," + rem.timestamp;
            packetSet.remove(remKey);
            OST ostRem = destMap.get(rem.destination);
            if (ostRem != null)
                ostRem.remove(rem.timestamp);
        }
        OST ost = destMap.get(destination);
        if (ost == null) {
            ost = new OST();
            destMap.put(destination, ost);
        }
        ost.insert(timestamp);
        Packet packet = new Packet(source, destination, timestamp);
        packetQueue.offer(packet);
        packetSet.add(key);
        return true;
    }
    
    public int[] forwardPacket() {
        if (packetQueue.isEmpty())
            return new int[0];
        Packet p = packetQueue.poll();
        String key = p.source + "," + p.destination + "," + p.timestamp;
        packetSet.remove(key);
        OST ost = destMap.get(p.destination);
        if(ost != null)
            ost.remove(p.timestamp);
        return new int[]{p.source, p.destination, p.timestamp};
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        OST ost = destMap.get(destination);
        if (ost == null)
            return 0;
        return ost.queryRange(startTime, endTime);
    }
    
    class Packet {
        int source, destination, timestamp;
        Packet(int s, int d, int t) {
            source = s;
            destination = d;
            timestamp = t;
        }
    }
    
    class OST {
        private Node root;
        private Random rand = new Random();
        
        class Node {
            int key, freq, priority;
            long sum;
            Node left, right;
            Node(int key) {
                this.key = key;
                this.freq = 1;
                this.priority = rand.nextInt();
                this.sum = 1;
            }
        }
        
        private long getSum(Node node) {
            return node == null ? 0 : node.sum;
        }
        
        private void update(Node node) {
            if(node != null)
                node.sum = node.freq + getSum(node.left) + getSum(node.right);
        }
        
        private Node rotateRight(Node y) {
            Node x = y.left;
            y.left = x.right;
            x.right = y;
            update(y);
            update(x);
            return x;
        }
        
        private Node rotateLeft(Node x) {
            Node y = x.right;
            x.right = y.left;
            y.left = x;
            update(x);
            update(y);
            return y;
        }
        
        public void insert(int key) {
            root = insert(root, key);
        }
        
        private Node insert(Node node, int key) {
            if(node == null)
                return new Node(key);
            if(key == node.key)
                node.freq++;
            else if(key < node.key) {
                node.left = insert(node.left, key);
                if(node.left.priority < node.priority)
                    node = rotateRight(node);
            } else {
                node.right = insert(node.right, key);
                if(node.right.priority < node.priority)
                    node = rotateLeft(node);
            }
            update(node);
            return node;
        }
        
        public void remove(int key) {
            root = remove(root, key);
        }
        
        private Node remove(Node node, int key) {
            if(node == null)
                return null;
            if(key < node.key)
                node.left = remove(node.left, key);
            else if(key > node.key)
                node.right = remove(node.right, key);
            else {
                if(node.freq > 1)
                    node.freq--;
                else {
                    if(node.left == null)
                        return node.right;
                    else if(node.right == null)
                        return node.left;
                    else {
                        if(node.left.priority < node.right.priority) {
                            node = rotateRight(node);
                            node.right = remove(node.right, key);
                        } else {
                            node = rotateLeft(node);
                            node.left = remove(node.left, key);
                        }
                    }
                }
            }
            update(node);
            return node;
        }
        
        public int queryRange(int low, int high) {
            return (int)(query(root, high) - query(root, low - 1));
        }
        
        private long query(Node node, int key) {
            if(node == null)
                return 0;
            if(node.key <= key)
                return getSum(node.left) + node.freq + query(node.right, key);
            else
                return query(node.left, key);
        }
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */
