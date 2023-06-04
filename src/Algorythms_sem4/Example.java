package Algorythms_sem4;

public class Example {
    public static void main(String[] args) {
        Node node = new Node();
        Example example = new Example();
        for (int i = 0; i < 16; i++) {
            example.put(i + 1, i);
        }
        example.remove(2);
        example.remove(4);
        System.out.println(example.size());
    }


    Node head;
    Node[] nodeArray = new Node[16];


    int size() {
        int count = 0;
        for (int i = 0; i < nodeArray.length; i++) {
            if (nodeArray[i] != null) {
                count += 1;
            }
        }
        return count;
    }

    boolean containsKey(Integer key) {
        for (int i = 0; i < nodeArray.length; i++) {
            if (nodeArray[i].key == key) {
                return true;
            }
        }
        return false;
    }

    boolean containsValue(Integer value) {
        for (int i = 0; i < nodeArray.length; i++) {
            if (nodeArray[i].value == value) {
                return true;
            }
        }
        return false;
    }

    public Object replays(Integer key, Integer v) {
        int index = key.hashCode() % 16;
        if (nodeArray[index] != null) {
            Node tempNode = nodeArray[index];
            while (tempNode != null) {
                if (tempNode.key == key) {
                    Integer x = tempNode.value;
                    tempNode.value = v;
                    return x;
                }
                tempNode = tempNode.next;
            }
        }
        return null;
    }

    public Object get(Integer key) {
        int index = key.hashCode() % 16;
        if (nodeArray[index] != null) {
            Node tempNode = nodeArray[index];
            while (tempNode != null) {
                if (tempNode.key == key) {
                    return tempNode.value;
                }
                tempNode = tempNode.next;
            }
        }
        return null;
    }

    public Object remove(Integer key) {
        int index = key.hashCode() % 16;
        if (nodeArray[index] != null) {
            Node tempNode = nodeArray[index];
            if (tempNode.key == key && tempNode.next == null) {
                nodeArray[index] = null;
                return tempNode.value;
            }
            if (tempNode.key == key && tempNode.next != null) {
                nodeArray[index] = tempNode.next;
                return tempNode.value;
            }
            while (tempNode.next != null) {
                if (tempNode.next.key == key) {
                    Integer tmp = tempNode.next.value;
                    tempNode.next = tempNode.next.next;
                    return tmp;
                }
                tempNode = tempNode.next;
            }
        }
        return null;
    }

    public Object put(int v, int k) {
        Node temp = new Node();
        temp.value = v;
        temp.key = k;
        temp.hash = temp.key.hashCode() % 16;
        if (nodeArray[temp.hash] != null) {
            Node tempNode = nodeArray[temp.hash];
            while (tempNode != null) {
                if (tempNode.key == k) {
                    return tempNode.value;
                }
                tempNode = tempNode.next;
            }
            temp.next = nodeArray[temp.hash];
        }
        nodeArray[temp.hash] = temp;
        return null;
    }

}

class Node {
    Integer value, key;
    int hash;
    Node next;
}
