import java.util.ArrayList;

public class HashTableV1<T extends Comparable<T>> implements DataStructureV1<T> {
    static class ListNode<T extends Comparable<T>> {
        T val;
        ListNode<T> next;
        ListNode<T> prev;
        ListNode() {
            next = null;
            prev = null;
        }
        ListNode(T v) {
            val = v;
            next = null;
            prev = null;
        }
    }

    ArrayList<ListNode<T>> data;
    int hashSize;

    public HashTableV1() {
        data = new ArrayList<>();
        hashSize = 1000;
        for (int i=0;i<hashSize;i++) {
            data.add(new ListNode<>());
        }
    }

    private int hashFunction(T key) {
        String keyString = String.valueOf(key);
        int val = 0;
        for (int i=0;i<keyString.length();i++) {
            val = val + keyString.charAt(i);
        }
        return val/hashSize;
    }

    @Override
    public void insert(T key) {
        if (search(key) == null) {
            int index = hashFunction(key);
            ListNode<T> head = data.get(index);
            insert(key, head);
        }
    }

    private void insert(T key, ListNode<T> node) {
        ListNode<T> p = node;
        while (p.next != null && p.next.val.compareTo(key) < 0) {
            p = p.next;
        }
        ListNode<T> temp = new ListNode<>(key);
        temp.next = p.next;
        temp.prev = p;
        if (p.next != null) {
            p.next.prev = temp;
        }
        p.next = temp;
    }

    private ListNode<T> search(T key) {
        int index = hashFunction(key);
        ListNode<T> head = data.get(index);
        if (head.next == null) {
            return null;
        }
        ListNode<T> p = head.next;
        while (p!= null) {
            if (p.val.equals(key)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    @Override
    public void delete(T key) throws ElementNotFoundException {
        ListNode<T> keyNode = search(key);
        if (keyNode == null) {
            throw new ElementNotFoundException();
        } else {
            if (keyNode.next != null) {
                keyNode.next.prev = keyNode.prev;
            }
            if (keyNode.prev != null) {
                keyNode.prev.next = keyNode.next;
            }
        }
    }

    @Override
    public void ascendingOrder() {
        System.out.println("Ascending order of data:");
        for (ListNode<T> row: data) {
            ListNode<T> p = row.next;
            while (p != null) {
                System.out.print(p.val + ", ");
                p = p.next;
            }
        }
        System.out.println();
    }
}
