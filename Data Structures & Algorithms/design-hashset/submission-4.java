class MyHashSet {
    static class Node {
        public int value;
        public Node next;
        Node(int i) {
            this.value = i;
            this.next = null;
        }

        void addNode(int l) {
            if(this.next == null) {
                this.next = new Node(l);
            } else {
            Node temp = this.next;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(l);
            }
        }

        void removeNode(int k) {
            if(this.next == null) return;
            Node temp = this.next;
            Node prev = temp;
            while(temp.next != null) {
                if(temp.value == k) {
                    prev.next = temp.next;
                    temp.next = null;
                    break;
                } else {
                    prev = temp;
                    temp = temp.next;
                }
            }
        }

        

        boolean contains(int v) {
            Node temp = this.next;
            while(temp != null) {
                if(temp.value == v) return true;
                else temp = temp.next;
            }
            return false;
        }
    }

    private final Node[] nodes;
    
    public MyHashSet() {
        int n = 1000;
        this.nodes = new Node[n];
    }

    public int computeHash(int x) {
        return Math.max(0, ((x % nodes.length) - 1));
    }
    
    public void add(int key) {
        if(contains(key)) {
            return;
        }
        int hash = computeHash(key);
        if(nodes[hash] == null) {
            nodes[hash] = new Node(key);
        } else {
            nodes[hash].addNode(key);
        }
    }
    
    public void remove(int key) {
        int hash = computeHash(key);
        if(nodes[hash] == null) {
            return;
        } else {
            if(nodes[hash].value == key) {
                nodes[hash] = nodes[hash].next;
            } else {
                nodes[hash].removeNode(key);
            }
        }
    }
    
    public boolean contains(int key) {
        int hash = computeHash(key);
        if(nodes[hash] == null) {
            return false;
        } else {
            if(nodes[hash].value == key) {
                return true;
            } else {
                return nodes[hash].contains(key);
            }
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */